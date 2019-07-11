package com.wenqiang.design.pattern.connectionPool;

public class Task implements Runnable {
    private String id;

    public Task(String id) {
        this.id = id;
    }

    public void run() {
        String name = "name"+id;
        String no = "no"+id;
        UserService.getInstance().insert(id,name,no);
    }
}
