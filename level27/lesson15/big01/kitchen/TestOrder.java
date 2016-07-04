package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.ArrayList;

public class TestOrder extends Order {
    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException {
        ConsoleHelper.writeMessage(Dish.allDishesToString());
        Dish[] elements = Dish.values();
        this.dishes = new ArrayList<>();
        int size = (int) (Math.random() * elements.length * 2);
        for (int i = 0; i < size; i++) {
            this.dishes.add(elements[(int) (Math.random() * elements.length)]);
        }
    }
}
