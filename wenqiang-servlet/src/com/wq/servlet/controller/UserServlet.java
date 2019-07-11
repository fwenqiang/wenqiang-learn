package com.wq.servlet.controller;

import com.wq.servlet.domain.User;
import com.wq.servlet.factory.BeanFactory;
import com.wq.servlet.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

   /* private UserService  userService = new UserServiceImpl();*/

    private UserService  userService = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet get请求开始>>>>>>>>>>>>>>>>>>>>>>>>");
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService =(UserService)BeanFactory.getBean("userService");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String userName= req.getParameter("userName");
        String password = req.getParameter("password");
        System.out.println("userName="+userName+"    password="+password);

        User user =new User(userName,password);
        try {
            int isOk =   userService.insert(user);
          RequestDispatcher requestDispatcher = null;
          if(isOk!=0){
              requestDispatcher  = req.getRequestDispatcher("/login/success.jsp");
              requestDispatcher.forward(req,resp);
          }else {
              requestDispatcher  = req.getRequestDispatcher("/login/failed.jsp");
              requestDispatcher.forward(req,resp);
          }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
