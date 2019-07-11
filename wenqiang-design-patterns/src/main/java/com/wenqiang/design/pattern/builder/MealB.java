package com.wenqiang.design.pattern.builder;

public class MealB extends MealBuilder {
    void bulidFood() {
        meal.setFood("面条");
    }

    void buildDrink() {
      meal.setDrink("蛋汤");
    }
}
