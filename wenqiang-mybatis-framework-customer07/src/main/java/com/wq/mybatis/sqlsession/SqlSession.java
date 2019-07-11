package com.wq.mybatis.sqlsession;

import java.util.List;

public interface SqlSession {

    <T> T selectOne(String statementId, Object param) throws Exception;

    <T> List<T> selectList(String statementId, Object param)throws Exception;
}
