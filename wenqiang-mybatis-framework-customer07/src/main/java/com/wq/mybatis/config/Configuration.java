package com.wq.mybatis.config;

import com.wq.mybatis.domain.MappedStatement;
import org.apache.commons.dbcp.BasicDataSource;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Configuration {

    private   BasicDataSource ds = new BasicDataSource();

    private  Map<String, MappedStatement> mappedStatementMap = new HashMap();


    public Configuration(InputStream is){
        try {
          /*  //1.加载mybatis-config.xml配置
            Resource resource = new ClassPathResource("mybatis-config.xml");
            InputStream is = resource.getInputStream();*/
            //2.SAX解析mybatis-config.xml配置
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(is);
            //3.初始化ds
            Element environments = (Element) document.selectSingleNode("//environments");
            ConfigurationParser.read(environments,ds);
            //4,初始化mappedStamementMap
            Element mappersElement = (Element) document.selectSingleNode("//mappers");
            MapperParser.read(mappersElement,mappedStatementMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BasicDataSource getDs() {
        return ds;
    }

    public void setDs(BasicDataSource ds) {
        this.ds = ds;
    }

    public Map<String, MappedStatement> getMappedStatementMap() {
        return mappedStatementMap;
    }

    public void setMappedStatementMap(Map<String, MappedStatement> mappedStatementMap) {
        this.mappedStatementMap = mappedStatementMap;
    }
}
