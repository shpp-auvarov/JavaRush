package com.javarush.test.level27.lesson04.home01;

public class ThreadDeadlock {
    static Object data;
    public synchronized Object getData() {
        return data;
    }
}
