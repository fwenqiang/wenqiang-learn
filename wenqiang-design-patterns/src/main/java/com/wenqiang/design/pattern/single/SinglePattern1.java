package com.wenqiang.design.pattern.single;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * https://blog.csdn.net/qq_34337272/article/details/80455972
 * 单例模式-饿汉模式
 * 1,私有构造方法，私有的单例对象
 * 2,JVM加载类时，已经实例化单例对象，确保线程安全的
 * 3.单例对象是静态的，确保整个应用中，全局唯一
 * 4.本方式是线程安全的
 */
public class SinglePattern1 {
    private static  SinglePattern1 instance = new SinglePattern1();
    private SinglePattern1(){

    }

    public  static  SinglePattern1 getInstance(){
        return  instance;
    }


    public static void main(String[] args) {
      ExecutorService executorService = Executors.newFixedThreadPool(10);
      for(int i = 0;i<20;i++){
          executorService.execute(new Runnable() {
              public void run() {
                  SinglePattern1 singlePattern1 = SinglePattern1.getInstance();
                  System.out.println(singlePattern1.toString()+"  内存地址   "+Thread.currentThread().getName());
              }
          });
      }
    }




    /*public static void main(String[] args) {
        SinglePattern1 s1= SinglePattern1.getInstance();

        SinglePattern1 s2 = SinglePattern1.getInstance();

        System.out.println(s1.equals(s2));//s1和s2指向同一个对象

        int s1Hash =  s1.hashCode();
        int s2Hash = s2.hashCode();
        System.out.println(s1Hash+"  hashCode  "+s2Hash);

        System.out.println(s1+"   "+s2);
    }*/
}
