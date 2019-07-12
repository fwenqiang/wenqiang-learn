package com.wq.mybatis.framework.factory;


import com.wq.mybatis.framework.config.Configuration;

public class SqlSessionFactoryBuilder {

    public static SqlSessionFactory builder(Configuration configuration){
        return  new DefaultSessionFactory(configuration);
    }
}
