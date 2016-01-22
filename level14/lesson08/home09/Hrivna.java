package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Andrey on 08.11.2015.
 */
public class Hrivna extends Money{
    public Hrivna(double amount) {
        super(amount);
    }

    public String getCurrencyName() {
        return "HRN";
    }
}
