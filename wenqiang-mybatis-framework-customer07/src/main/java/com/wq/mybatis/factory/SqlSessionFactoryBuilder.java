package com.wq.mybatis.factory;

import com.wq.mybatis.config.Configuration;

public class SqlSessionFactoryBuilder {

    public static SqlSessionFactory builder(Configuration configuration){
        return  new DefaultSessionFactory(configuration);
    }
}
