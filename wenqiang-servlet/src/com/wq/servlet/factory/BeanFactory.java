package com.wq.servlet.factory;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanFactory {
    private static Map<String,Object> beanFactory=new HashMap<>();

    static {
        try {
            SAXReader saxReader =new SAXReader();
            InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("/bean.xml");
            Document document = saxReader.read(inputStream);
            List<Element> beanList =  document.selectNodes("/beans/bean");
            if(beanList!=null && beanList.size()>0){
                beanList.forEach(bean->{
                    String id =  bean.attributeValue("id");
                    String classPath =  bean.attributeValue("class");
                    Object instance = null;
                    try {
                        instance = Class.forName(classPath).newInstance();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    beanFactory.put(id,instance);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object getBean(String beanId){
        return  beanFactory.get(beanId);
    }
}
