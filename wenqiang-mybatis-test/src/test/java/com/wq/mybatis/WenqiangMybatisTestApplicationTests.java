package com.wq.mybatis;

import com.wq.mybatis.dao.UserDao;
import com.wq.mybatis.dao.impl.UserDaoImpl;
import com.wq.mybatis.domain.User;
import com.wq.mybatis.framework.config.Configuration;
import com.wq.mybatis.framework.factory.SqlSessionFactory;
import com.wq.mybatis.framework.factory.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WenqiangMybatisTestApplicationTests {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public  void init() throws Exception{
        Resource resource = new ClassPathResource("mybatis-config.xml");
        InputStream is = resource.getInputStream();
        Configuration configuration =new Configuration(is);
        sqlSessionFactory =  SqlSessionFactoryBuilder.builder(configuration);

    }

    @Test
    public void contextLoads() throws Exception {
        UserDao userDao =new UserDaoImpl(sqlSessionFactory);
        User user = new User();
        user.setId(9);
        user = userDao.findUserById(user);
        System.out.println(user+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

}
