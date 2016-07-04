package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook implements Runnable {
    private String name;
    private boolean busy;
    private LinkedBlockingQueue<Order> queue;
    private LinkedBlockingQueue<Order> readyQueue;

    public void setReadyQueue(LinkedBlockingQueue<Order> readyQueue) {
        this.readyQueue = readyQueue;
    }

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void startCookingOrder(Order order) {
        busy = true;
        try {
            Thread.sleep(order.getTotalCookingTime() * 10);
        } catch (InterruptedException ignore) {

        }
        ConsoleHelper.writeMessage("Start cooking - " + order.toString() + ", cooking time " + order.getTotalCookingTime() + "min");
        StatisticEventManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(), name, order.getTotalCookingTime() * 60, order.getDishes()));
        order.setCooked(this);
        readyQueue.add(order);
        busy = false;
    }

    public boolean isBusy() {
        return busy;
    }

    public LinkedBlockingQueue<Order> getQueue() {
        return queue;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (queue.peek() != null)
                if (!isBusy()) {
                    startCookingOrder(queue.poll());
                }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}