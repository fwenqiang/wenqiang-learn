package com.wenqiang.design.pattern.factory.abstractFactory;

public class M3A1_Factory implements Factory {
    public Gun getGun() {
        return new M3A1();
    }

    public Bullet getBullet() {
        return  new M3A1_Bullet();
    }
}
