package com.wq.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Init implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("初始化开始...............S");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
