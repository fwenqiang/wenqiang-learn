package com.wq.mybatis.config;

import com.wq.mybatis.domain.MappedStatement;
import com.wq.mybatis.domain.SQLSource;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class MapperParser {
   public static void read(Element mappersElement, Map<String, MappedStatement> mappedStatementMap) throws Exception{
        List<Element> mapperXMLList = mappersElement.selectNodes("//mapper");
        if(mapperXMLList!=null &&mapperXMLList.size()>0){
           for (int i = 0; i <mapperXMLList.size() ; i++) {
                Element mapperXML = mapperXMLList.get(i);
                String   mapperXMLPath =  mapperXML.attributeValue("resource");

                Resource resource = new ClassPathResource(mapperXMLPath);
                InputStream is = resource.getInputStream();
                SAXReader saxReader = new SAXReader();
                Document document = saxReader.read(is);

                Element mapperElement = (Element) document.selectSingleNode("//mapper");
                String namespace = mapperElement.attributeValue("namespace");

                List<Element> selectElementList = mapperElement.selectNodes("select");
                if(selectElementList!=null && selectElementList.size()>0){
                   for (int j = 0; j < selectElementList.size() ; j++) {
                      Element  select = selectElementList.get(j);
                      String id = select.attributeValue("id");
                      String paramTypeStr = select.attributeValue("parameterType");
                      String resultTypeStr = select.attributeValue("resultType");
                      String statementType = select.attributeValue("statementType");
                      String sql = select.getTextTrim();

                      MappedStatement mappedStatement = new MappedStatement();
                      mappedStatement.setId(id);
                      if(!StringUtils.isEmpty(paramTypeStr)){
                           Class<?>  paramType = Class.forName(paramTypeStr);
                           mappedStatement.setParamType(paramType);
                      }
                      if(!StringUtils.isEmpty(resultTypeStr)){
                          Class<?>  resultType = Class.forName(resultTypeStr);
                          mappedStatement.setResultType(resultType);
                      }
                       SQLSource sqlSource = new SQLSource(sql);
                       mappedStatement.setSqlSource(sqlSource);
                       mappedStatement.setStatementType(statementType);
                       mappedStatementMap.put(namespace+"."+id,mappedStatement);
                   }
                }
           }
        }
   }
}
