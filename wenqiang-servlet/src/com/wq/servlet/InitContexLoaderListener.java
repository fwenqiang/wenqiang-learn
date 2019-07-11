package com.wq.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitContexLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("初始化操作>>>>>>>>>>>>>>>>>>>>");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
