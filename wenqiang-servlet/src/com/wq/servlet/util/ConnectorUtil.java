package com.wq.servlet.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * spring bean采用单例模式，服务于多线程，为何数据库连接池里的连接不采用单例模式，服务于多线程呢？
 * 事务问题
 * 假如有两个线程，
 * 第一个线程插入记录A成功，但是其他原因导致事务失败，没来得及回滚；
 * 第二个线程插入记录B成功了，提交了事务，假如B的事务先于A提交，那么会导致记录A和B都插入成功，A再次回滚也没有用了。
 */
public class ConnectorUtil {

    private static final String dbPath = "/db.properties";

    private static BasicDataSource ds ;
    static {
        ds = new BasicDataSource();
        try {
            Properties properties =new Properties();
            InputStream inputStream =  ConnectorUtil.class.getClassLoader().getResourceAsStream(dbPath);
            properties.load(inputStream);

            ds.setDriverClassName(properties.getProperty("driver"));
            ds.setUrl(properties.getProperty("url"));
            ds.setUsername(properties.getProperty("username"));
            ds.setPassword(properties.getProperty("password"));
            ds.setInitialSize(5);
            ds.setMaxTotal(100);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection()throws Exception{
       return ds.getConnection();
    }
}
