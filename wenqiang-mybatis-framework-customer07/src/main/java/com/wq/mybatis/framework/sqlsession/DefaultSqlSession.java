package com.wq.mybatis.framework.sqlsession;

import com.wq.mybatis.framework.config.Configuration;
import com.wq.mybatis.framework.domain.MappedStatement;

import java.util.List;

public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration){
        this.configuration = configuration;
    }

    @Override
    public <T> T selectOne(String statementId, Object param) throws Exception {
        List<T> list = selectList(statementId,param);
        if(list!=null && list.size()>0){
            return  list.get(0);
        }
        return  null;
    }


    @Override
    public <T> List<T> selectList(String statementId, Object param) throws Exception {
        MappedStatement ms = configuration.getMappedStatementMap().get(statementId);
        Executor executor = new SimpleExecutor(configuration);
        return  executor.query(ms,param);
    }
}
