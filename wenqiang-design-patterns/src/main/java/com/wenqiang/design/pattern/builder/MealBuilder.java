package com.wenqiang.design.pattern.builder;

public abstract  class MealBuilder {
    Meal meal  =new Meal();

    abstract void bulidFood();

    abstract  void buildDrink();

    public Meal getResult() {
        return meal;
    }
}
