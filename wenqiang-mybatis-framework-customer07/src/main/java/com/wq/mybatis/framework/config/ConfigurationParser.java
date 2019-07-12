package com.wq.mybatis.framework.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.dom4j.Element;

public class ConfigurationParser {
     public static void read(Element environments,BasicDataSource ds){
          String defaultDS =  environments.attributeValue("default");
          //4.根据默认的数据库节点名称，获取默认的数据库配置
          Element defaultEelement = (Element) environments.selectSingleNode("environment[@id='"+defaultDS+"']");
          Element driverElement = (Element)defaultEelement.selectSingleNode("//property[@name='driver']");
          String driver =  driverElement.attributeValue("value");

          Element urlElement = (Element)defaultEelement.selectSingleNode("//property[@name='url']");
          String url =  urlElement.attributeValue("value");

          Element usernameElement = (Element)defaultEelement.selectSingleNode("//property[@name='username']");
          String username =  usernameElement.attributeValue("value");

          Element passwordElement = (Element)defaultEelement.selectSingleNode("//property[@name='password']");
          String password =  passwordElement.attributeValue("value");

          ds.setDriverClassName(driver);
          ds.setUrl(url);
          ds.setUsername(username);
          ds.setPassword(password);
     }
}
