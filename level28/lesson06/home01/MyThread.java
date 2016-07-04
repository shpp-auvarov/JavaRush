package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    public static AtomicInteger order = new AtomicInteger(1);

    public MyThread() {
        super();
        if (order.get() == 11) {
            order.set(1);
        }
        setPriority(order.getAndIncrement());
    }

    public MyThread(Runnable target) {
        super(target);
        if (order.get() == 11) {
            order.set(1);
        }
        setPriority(order.getAndIncrement());
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        if (order.get() == 11) {
            order.set(1);
        }
        setPriority(order.getAndIncrement());
    }

    public MyThread(String name) {
        super(name);
        if (order.get() == 11) {
            order.set(1);
        }
        setPriority(order.getAndIncrement());
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        if (order.get() == 11) {
            order = new AtomicInteger(1);
        }
        setPriority(order.getAndIncrement());
        if (this.getPriority() > group.getMaxPriority()) {
            this.setPriority(group.getMaxPriority());
        }
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        if (order.get() == 11) {
            order.set(1);
        }
        setPriority(order.getAndIncrement());
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        if (order.get() == 11) {
            order = new AtomicInteger(1);
        }
        setPriority(order.getAndIncrement());
        if (this.getPriority() > group.getMaxPriority()) {
            this.setPriority(group.getMaxPriority());
        }
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        if (order.get() == 11) {
            order = new AtomicInteger(1);
        }
        setPriority(order.getAndIncrement());
        if (this.getPriority() > group.getMaxPriority()) {
            this.setPriority(group.getMaxPriority());
        }
    }
}