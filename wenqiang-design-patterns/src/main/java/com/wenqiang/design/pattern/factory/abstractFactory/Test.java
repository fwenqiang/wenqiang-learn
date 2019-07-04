package com.wenqiang.design.pattern.factory.abstractFactory;

public class Test {
    public static void main(String[] args) {
        Factory ak = new AK_Factory();
        Gun akGun =  ak.getGun();
        Bullet akBullet = ak.getBullet();


        Factory m1a1 = new M3A1_Factory();


    }
}
