package com.wenqiang.design.pattern.connectionPool;

/**
 * https://blog.csdn.net/sunbo94/article/details/79409298
 */
public class Test {
    public static void main(String[] args) {
         for (int i=1300;i<1500;i++){
               Thread thread = new Thread(new Task(i+""));
               thread.start();
         }
    }
}
