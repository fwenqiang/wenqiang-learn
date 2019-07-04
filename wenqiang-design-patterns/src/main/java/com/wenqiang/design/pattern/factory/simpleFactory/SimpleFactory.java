package com.wenqiang.design.pattern.factory.simpleFactory;

import com.wenqiang.design.pattern.factory.Circle;
import com.wenqiang.design.pattern.factory.Rectangle;
import com.wenqiang.design.pattern.factory.Shape;

/**
 * 简单工厂
 */
public class SimpleFactory {
    public static Shape getShape(int type){
        switch (type){
            case 1:
                return new Circle();
            case 2:
                return  new Rectangle();
                default:
                    return new Circle();
        }
    }
}
