package com.wenqiang.design.pattern.factory.factoryMethod;

import com.wenqiang.design.pattern.factory.Shape;

public class Test {
    public static void main(String[] args) {
        Factory factory = new CircleFactory();
        Shape shape = factory.getShape();
        shape.draw();

        Factory factory1 = new RectangleFactory();
        Shape shape1 = factory1.getShape();
        shape1.draw();
    }
}
