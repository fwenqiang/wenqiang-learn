package com.wenqiang.design.pattern.factory.factoryMethod;

import com.wenqiang.design.pattern.factory.Circle;
import com.wenqiang.design.pattern.factory.Shape;

public class CircleFactory implements Factory {
    public Shape getShape() {
        return new Circle();
    }
}
