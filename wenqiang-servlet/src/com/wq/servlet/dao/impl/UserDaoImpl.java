package com.wq.servlet.dao.impl;

import com.wq.servlet.dao.UserDao;
import com.wq.servlet.domain.User;
import com.wq.servlet.util.ConnectorUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDaoImpl implements UserDao {
    @Override
    public int insert(User user) throws Exception{
        Connection connection= null;
        PreparedStatement ps = null;
        try {
            connection= ConnectorUtil.getConnection();
            String sql = "insert user(user_name,password) values(?,?)";
            ps  = connection.prepareStatement(sql);
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getPassword());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return  0;
        } finally {
            if(ps!=null){
                ps.close();
            }
            if(connection!=null){
                connection.close();
            }
        }
    }
}
