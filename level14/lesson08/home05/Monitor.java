package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Andrey on 08.11.2015.
 */
public class Monitor implements CompItem {
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
