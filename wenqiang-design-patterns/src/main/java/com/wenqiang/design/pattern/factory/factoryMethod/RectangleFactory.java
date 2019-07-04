package com.wenqiang.design.pattern.factory.factoryMethod;

import com.wenqiang.design.pattern.factory.Rectangle;
import com.wenqiang.design.pattern.factory.Shape;

public class RectangleFactory implements Factory {
    public Shape getShape() {
        return new Rectangle();
    }
}
