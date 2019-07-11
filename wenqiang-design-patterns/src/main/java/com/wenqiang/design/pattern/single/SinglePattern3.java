package com.wenqiang.design.pattern.single;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * https://blog.csdn.net/sunqingzhong44/article/details/79473399
 * https://www.cnblogs.com/shangxiaofei/p/4694794.html
 * https://blog.csdn.net/lirongqian123/article/details/79410516
 * https://blog.csdn.net/PanPa_WoNiu/article/details/89204334
 * https://www.cnblogs.com/a154627/p/10046147.html
 * 双重检查锁模式
 * 特点:
 * 1.只有在对象为null的情况下，才进行加锁
 * 2.同步块内，再次进行了为null判断，防止多线程环境，多次实例化操作(可能有多个线程，在同步那块发生阻塞)
 * 3.实例的必须声明为  volatile，解决实例化对象时，指令重排序问题
 *
 * 缺点:
 * 1.实例化过程，分解为1：分配内存空间  2，实例化对象  3，对象内存地址赋值给instance
 * 2,实例化的三步，可能会进行重排序，比方说2和3位置颠倒，就导致install有了内存地址，但是指向的对象还没来得及实例化操作.
 * 3.这样就导致其他线程，进来时，发现install不为null，但是拿到的对象却为null
 * 4,为什么会发生代码重排序？怎么解决这个问题?
 */
public class SinglePattern3 {
    private static volatile SinglePattern3 instance;

    private SinglePattern3(){

    }
    public static SinglePattern3 getInstance(){
        //只有在实例化时，才需要进行同步
        if(instance==null){
            synchronized(SinglePattern3.class){
                //多线程环境下，有可能多个线程进入第一个为null的判断，然后发生阻塞。如果第一个线程先获取到类锁，那么进行实例化操作，然后释放锁，第二个等待的线程，这时候就能获取到类锁，也进入下边的方法，这个时候，实际上已经实例化了，不为 null了，不需要实例化了，所以要进行第二次不为null判断
                 if(instance==null){
                     instance =  new SinglePattern3();
                 }
            }
        }
        return  instance;
    }


    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i <20 ; i++) {
               executorService.execute(new Runnable() {
                   public void run() {
                       SinglePattern3 singlePattern3 = SinglePattern3.getInstance();
                       System.out.println(singlePattern3.toString()+">>>>>>>>>>>>>>>>>>>>>>>"+ Thread.currentThread().getName());
                   }
               });
        }
    }
}
