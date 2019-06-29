package com.wq.mybatis.impl;

import com.wq.mybatis.SqlSession;

import java.util.List;

public class DefaultSqlSession implements SqlSession {

    public <T> T findOne(String sqlId, Object params) {
        return null;
    }

    public <T> List<T> selectList(String sqlId, Object params) {
        return null;
    }

    public void insert(String sqlId, Object params) {

    }

    public void update(String sqlId, Object params) {

    }

    public void delete(String sqlId, Object params) {

    }
}
