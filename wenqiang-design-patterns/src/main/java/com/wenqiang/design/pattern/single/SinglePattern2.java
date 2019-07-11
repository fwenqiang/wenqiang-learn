package com.wenqiang.design.pattern.single;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单例模式-懒汉模式（需要使用的时候，才实例化）
 * 特点:
 * 1.方法上进行同步，确保只会产生一个实例
 *
 * 缺点:
 * 1.多线程环境，容易发生阻塞,效率低下
 * 2.每次都进行锁的获取和释放，浪费资源(事实上，只有实例化的过程，才需要同步)
 **/
public class SinglePattern2 {
    private static SinglePattern2 instance;
    private SinglePattern2(){

    }

    public  static synchronized SinglePattern2 getInstance(){
        if(instance==null){
            instance =   new SinglePattern2();
        }
        return  instance;
    }

    public static void main(String[] args) {
       ExecutorService executorService = Executors.newFixedThreadPool(10);
       for(int i=0;i<10;i++){
           executorService.execute(new Runnable() {
               public void run() {
                   SinglePattern2 singlePattern2 = SinglePattern2.getInstance();
                   System.out.println(singlePattern2.toString()+" >>>>>>>>>>>>>>> "+Thread.currentThread().getName());
               }
           });
       }
    }
}
