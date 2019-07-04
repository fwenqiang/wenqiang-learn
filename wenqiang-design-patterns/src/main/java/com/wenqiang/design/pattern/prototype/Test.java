package com.wenqiang.design.pattern.prototype;

import java.util.Date;

public class Test {
    public static void main(String[] args) throws Exception {
        User u =new User("eric",new Date());

        User shallowCloneObj= (User) u.clone();
        User deepCloneObj= u.deepClone();

        System.out.println("原来的:"+u);
        System.out.println("浅克隆:"+shallowCloneObj);
        System.out.println("深克隆:"+deepCloneObj);
    }
}
