package com.wq.mybatis.framework.sqlsession;

import com.wq.mybatis.framework.domain.MappedStatement;

import java.util.List;

public interface Executor {

    public <T> List<T> query(MappedStatement mappedStatement, Object param) throws Exception;
}
