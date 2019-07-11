package com.wq.mybatis.dao.impl;
import com.wq.mybatis.factory.SqlSessionFactory;
import com.wq.mybatis.dao.UserDao;
import com.wq.mybatis.domain.User;
import com.wq.mybatis.sqlsession.SqlSession;

public class UserDaoImpl implements UserDao {

    /**
     * 这里不能直接new，这是工厂，只能用依赖注入(在此采用构造方法注入)
     */
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findUserById(User user) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        String statementId="test.findUserById";
        user = sqlSession.selectOne(statementId,user);
        return user;
    }
}
