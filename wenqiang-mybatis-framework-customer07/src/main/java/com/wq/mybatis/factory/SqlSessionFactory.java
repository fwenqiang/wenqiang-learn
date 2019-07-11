package com.wq.mybatis.factory;

import com.wq.mybatis.sqlsession.SqlSession;

public interface SqlSessionFactory {
   public SqlSession openSession();
}
