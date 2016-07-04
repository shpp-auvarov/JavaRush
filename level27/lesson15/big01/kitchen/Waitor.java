package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.concurrent.LinkedBlockingQueue;

public class Waitor implements Runnable {
    private LinkedBlockingQueue<Order> readyQueue;

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (readyQueue.peek() != null) {
                Order order = readyQueue.poll();
                ConsoleHelper.writeMessage(order.toString() + " was cooked by " + order.getCooked().toString());
            }
        }
    }

    public void setReadyQueue(LinkedBlockingQueue<Order> readyQueue) {
        this.readyQueue = readyQueue;
    }
}
