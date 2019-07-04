package com.wenqiang.design.pattern.factory.abstractFactory;

public class AK_Factory implements Factory {
    public Gun getGun() {
        return new AK();
    }

    public Bullet getBullet() {
        return new AK_Bullet();
    }
}
