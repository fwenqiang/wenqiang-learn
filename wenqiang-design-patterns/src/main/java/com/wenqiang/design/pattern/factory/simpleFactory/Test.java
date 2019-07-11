package com.wenqiang.design.pattern.factory.simpleFactory;

import com.wenqiang.design.pattern.factory.Circle;
import com.wenqiang.design.pattern.factory.Rectangle;
import com.wenqiang.design.pattern.factory.Shape;

public class Test {
   /* public static void main(String[] args) {
        Shape shape = SimpleFactory.getShape(1);
        Shape shape1 = SimpleFactory.getShape(2);
        shape.draw();
        shape1.draw();
    }*/

    public static void main(String[] args) {
        Shape shape = (Shape) SimpleFactory2.getShape(Circle.class);

        Shape shape1 = (Shape) SimpleFactory2.getShape(Rectangle.class);

        shape.draw();
        shape1.draw();
    }
}
