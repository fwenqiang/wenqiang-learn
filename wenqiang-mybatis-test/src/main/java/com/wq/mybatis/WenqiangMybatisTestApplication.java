package com.wq.mybatis;

import org.dom4j.io.SAXReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WenqiangMybatisTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(WenqiangMybatisTestApplication.class, args);

        SAXReader saxReader =  new SAXReader();
    }

}
