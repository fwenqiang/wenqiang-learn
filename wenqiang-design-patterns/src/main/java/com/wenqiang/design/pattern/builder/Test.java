package com.wenqiang.design.pattern.builder;

public class Test {
    public static void main(String[] args) {
        KFCWaiter kfcWaiter =  new KFCWaiter(new MealA());

        Meal meala =    kfcWaiter.constact();
        System.out.println(meala.getFood()+"   "+meala.getDrink());

        KFCWaiter kfcWaiter2 =  new KFCWaiter(new MealB());

        Meal mealb= kfcWaiter2.constact();

        System.out.println(mealb.getFood()+"   "+mealb.getDrink());
    }
}
