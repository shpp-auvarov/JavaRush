package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Andrey on 15.11.2015.
 */
public class Moon implements Planet{
    private static volatile Moon instance;
    private Moon() {
    }
    public static Moon getInstance() {
        if (instance == null) {
            synchronized (Moon.class) {
                if (instance == null) {
                    instance = new Moon();
                }
            }
        }

        return instance;
    }
}