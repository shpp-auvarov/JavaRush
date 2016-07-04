package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private Tablet tablet;
    protected List<Dish> dishes;
    private Cook cooked;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    @Override
    public String toString() {
        if (dishes.size() == 0) {
            return "";
        }
        return "Your order: " + dishes.toString() + " of Tablet{number=" + tablet.getNumber() + "}";
    }

    public int getTotalCookingTime() {
        int result = 0;
        for (int i = 0; i < dishes.size(); i++) {
            result += dishes.get(i).getDuration();
        }
        return result;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    protected void initDishes() throws IOException {
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public Tablet getTablet() {
        return tablet;
    }

    public void setCooked(Cook cooked) {
        this.cooked = cooked;
    }

    public Cook getCooked() {
        return cooked;
    }
}