package com.wenqiang.design.pattern.factory.simpleFactory;

import com.wenqiang.design.pattern.factory.Shape;

public class SimpleFactory2 {

   /* public static Object getShape(Class<? extends Shape> classz){
         Object object =null;
        try {
            object = Class.forName(classz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  object;
    }*/

   public static Object getShape(Class<? extends Shape> classz){
       try {
           Object o= null;
           o =   Class.forName(classz.getName()).newInstance();
           return  o;
       } catch (InstantiationException e) {
           e.printStackTrace();
       } catch (IllegalAccessException e) {
           e.printStackTrace();
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }
       return  null;
   }
}
