package com.wenqiang.design.pattern.connectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UserService {
   private Connection connection;

   private static class SingleInstance{
     private static UserService  userService = new UserService();
   }

   public  UserService(){
       connection =  ConnectorUtil.getConnection();
   }

   public static UserService getInstance(){
      return SingleInstance.userService;
   }

    public void insert(String id,String name,String no) {
        String addStr ="insert into user(id,name,no) values('"+id+"','"+name+"','"+no+"')";
        Statement statement=null;
        try {
            statement = connection.createStatement();
            statement.execute(addStr);

            if("1350".equals(id)){//模仿某个线程执行service某个方法中某个步骤出现异常
                Thread.sleep(3000);//模仿当前线程执行时间较长。。。。。
                System.out.println("发生异常。。。。。");
                System.out.println("记录"+id+"插入失败。。。。");
                connection.rollback();  //出现异常事务回滚。。。
                throw new Exception();
            }else{
                connection.commit();
                System.out.println("记录"+id+"插入成功。。。。");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
