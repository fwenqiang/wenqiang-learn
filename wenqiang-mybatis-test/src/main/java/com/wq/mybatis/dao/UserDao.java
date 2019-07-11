package com.wq.mybatis.dao;

import com.wq.mybatis.domain.User;

public interface UserDao {
    public User findUserById(User user) throws Exception;
}
