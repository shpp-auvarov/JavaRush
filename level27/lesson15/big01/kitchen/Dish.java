package com.javarush.test.level27.lesson15.big01.kitchen;

public enum Dish {
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);
    private int duration;

    Dish(int number) {
        this.duration = number;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString() {
        Dish[] base = Dish.values();
        String result = "";
        result += base[0];
        for (int i = 1; i < base.length; i++) {
            result += ", " + base[i];
        }
        return result;
    }
}
