package com.wq.springioc.framework.factory;

import com.wq.springioc.framework.bean.BeanDefinition;
import com.wq.springioc.framework.bean.ConstructorArg;
import com.wq.springioc.framework.bean.Property;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultListableBeanFactory extends AbstractBeanFactory {

    private Map<String,Object> instanceMap = new HashMap<>();

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    private String beanXMLPath;

    public DefaultListableBeanFactory(String beanXMLPath) {
        this.beanXMLPath = beanXMLPath;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(beanXMLPath);
        SAXReader saxReader = new SAXReader();
        Document document  = null;
        try {
            document = saxReader.read(inputStream);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        List<Element> beans =  document.selectNodes("//bean");
        if(beans!=null &&beans.size()>0){
            for(Element bean:beans){
              String id =   bean.attributeValue("id");
              String clazz =  bean.attributeValue("class");
              BeanDefinition beanDefinition = new BeanDefinition();
              beanDefinition.setId(id);
              beanDefinition.setClazz(clazz);

              //构造函数处理
                List<ConstructorArg> constructorArgList = new ArrayList<>();
              List<Element> constructorElementList =  bean.selectNodes("constructor-arg");
              if(constructorElementList!=null && constructorElementList.size()>0){
                      constructorElementList.forEach(e->{
                      int index = Integer.parseInt(e.attributeValue("index"));
                      Object value = e.attributeValue("value");

                      ConstructorArg constructorArg = new ConstructorArg();
                      constructorArg.setIndex(index);
                      constructorArg.setValue(value);

                      constructorArgList.add(constructorArg);
                  });
              }
              beanDefinition.setConstructorArgList(constructorArgList);
              //属性处理
                List<Property> propertyList = new ArrayList<>();
                List<Element> propertyElementList =  bean.selectNodes("property");
                if(propertyElementList!=null && propertyElementList.size()>0){
                    for (Element element : propertyElementList) {
                       String name=  element.attributeValue("name");
                       String value =element.attributeValue("value");
                       String ref = element.attributeValue("ref");
                       Property property = new Property(name,value,ref);
                       propertyList.add(property);
                    }
                }

                beanDefinition.setPropertiesList(propertyList);
                beanDefinitionMap.put(id,beanDefinition);
            }
        }

    }

    @Override
    public Object getBean(String beanName) {
        Object instance =  instanceMap.get(beanName);
        if(instance!=null){
            return instanceMap.get(beanName);
        }

        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        String clazz =  beanDefinition.getClazz();

        if(beanDefinition.getConstructorArgList()!=null){

        }


        return null;
    }

    @Override
    public Object getBean(Class<?> clazz) {
        return null;
    }

    public String getBeanXMLPath() {
        return beanXMLPath;
    }

    public void setBeanXMLPath(String beanXMLPath) {
        this.beanXMLPath = beanXMLPath;
    }
}
