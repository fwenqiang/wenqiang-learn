package com.wq.mybatis.sqlsession;

import com.wq.mybatis.domain.MappedStatement;

import java.util.List;

public interface Executor {

    public <T> List<T> query(MappedStatement mappedStatement, Object param) throws Exception;
}
