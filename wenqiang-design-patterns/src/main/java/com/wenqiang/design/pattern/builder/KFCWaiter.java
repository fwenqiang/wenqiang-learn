package com.wenqiang.design.pattern.builder;

public class KFCWaiter {
    MealBuilder mealBuilder;

    public KFCWaiter(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }

    public Meal constact(){
        mealBuilder.bulidFood();
        mealBuilder.buildDrink();
        return  mealBuilder.getResult();
    }
}
