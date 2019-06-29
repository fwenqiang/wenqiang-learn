package com.wq.mybatis;

import java.util.List;

public interface SqlSession {
    <T> T findOne(String sqlId,Object params);

    <T> List<T> selectList(String  sqlId, Object params);

    void insert(String sqlId,Object params);

    void update(String sqlId,Object params);

    void delete(String sqlId,Object params);
}
