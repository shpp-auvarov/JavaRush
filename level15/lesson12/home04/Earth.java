package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Andrey on 15.11.2015.
 */
public class Earth implements Planet{
    private static volatile Earth instance;
    private Earth() {
    }
    public static Earth getInstance() {
        if (instance == null) {
            synchronized (Earth.class) {
                if (instance == null) {
                    instance = new Earth();
                }
            }
        }

        return instance;
    }
}
