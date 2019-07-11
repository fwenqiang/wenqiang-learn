package com.wq.mybatis.factory;

import com.wq.mybatis.config.Configuration;
import com.wq.mybatis.sqlsession.DefaultSqlSession;
import com.wq.mybatis.sqlsession.SqlSession;

public class DefaultSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public DefaultSessionFactory(Configuration configuration){
         this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
