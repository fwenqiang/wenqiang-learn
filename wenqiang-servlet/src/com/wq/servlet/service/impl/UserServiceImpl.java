package com.wq.servlet.service.impl;

import com.wq.servlet.dao.UserDao;
import com.wq.servlet.domain.User;
import com.wq.servlet.factory.BeanFactory;
import com.wq.servlet.service.UserService;

public class UserServiceImpl implements UserService {

   /* private UserDao userDao =new UserDaoImpl();*/
    private UserDao userDao = null;
    @Override
    public int insert(User user) throws Exception {
        userDao =(UserDao) BeanFactory.getBean("userDao");
        return userDao.insert(user);
    }
}
