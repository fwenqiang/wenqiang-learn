package com.wenqiang.design.pattern.builder;

public class MealA extends MealBuilder {
    void bulidFood() {
        meal.setFood("米饭");
    }

    void buildDrink() {
      meal.setDrink("鸡汤");
    }
}
