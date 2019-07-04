package com.wenqiang.design.pattern.connectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * spring bean采用单例模式，服务于多线程，为何数据库连接池里的连接不采用单例模式，服务于多线程呢？
 * 事务问题
 * 假如有两个线程，
 * 第一个线程插入记录A成功，但是其他原因导致事务失败，没来得及回滚；
 * 第二个线程插入记录B成功了，提交了事务，假如B的事务先于A提交，那么会导致记录A和B都插入成功，A再次回滚也没有用了。
 */
public class ConnectorUtil {
    private static final String url = "jdbc:mysql://134.175.204.199:3306/learn";
    private static final String usrname = "root";
    private static final String password = "123456a";
    private static final String driver = "com.mysql.jdbc.Driver";


    private static volatile Connection connection = null;

    private static volatile AtomicInteger count = new AtomicInteger(0);

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static  Connection getConnection(){
        if(connection==null){
            synchronized (ConnectorUtil.class){
                if(connection==null){
                    try {
                        connection =  DriverManager.getConnection(url,usrname,password);
                        connection.setAutoCommit(false);
                        count.getAndIncrement();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return  connection;
    }
}
