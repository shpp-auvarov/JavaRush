package com.javarush.test.level25.lesson07.home01;

public interface CustomThreadManipulator {
    public void start(String threadName) throws InterruptedException;
    public void stop() throws InterruptedException;
}
