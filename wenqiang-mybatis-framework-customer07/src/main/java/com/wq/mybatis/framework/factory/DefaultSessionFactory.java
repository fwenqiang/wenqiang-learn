package com.wq.mybatis.framework.factory;

import com.wq.mybatis.framework.config.Configuration;
import com.wq.mybatis.framework.sqlsession.DefaultSqlSession;
import com.wq.mybatis.framework.sqlsession.SqlSession;
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
