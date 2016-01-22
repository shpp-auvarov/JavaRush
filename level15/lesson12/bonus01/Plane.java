package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by Andrey on 16.11.2015.
 */
public class Plane implements Flyable {
    @Override
    public void fly() {

    }
    public int qty;

    public Plane(int qty) {
        this.qty = qty;
    }
}
