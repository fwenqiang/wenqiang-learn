package com.wq.mybatis.framework.factory;


import com.wq.mybatis.framework.sqlsession.SqlSession;

public interface SqlSessionFactory {
   public SqlSession openSession();
}
