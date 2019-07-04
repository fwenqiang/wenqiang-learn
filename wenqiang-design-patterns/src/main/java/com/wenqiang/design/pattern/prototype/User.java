package com.wenqiang.design.pattern.prototype;

import java.io.*;
import java.util.Date;

public class User implements Cloneable,Serializable{
    private String name;
    private Date birthday;

    public User(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public  <T extends Serializable> T deepClone()throws Exception{
        //0,声明一个新对象
        T cloneObj = null;

        //1,当前对象的二进制流写入到out
        ByteArrayOutputStream out  = new ByteArrayOutputStream();
        ObjectOutputStream obs =new ObjectOutputStream(out);
        obs.writeObject(this);

        //2,将out里的二进制流读取到ios,然后通过ois读取对象
        ByteArrayInputStream ios =new ByteArrayInputStream(out.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(ios);
        cloneObj =(T)ois.readObject();

        //3,返回拷贝对象
        return  cloneObj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
