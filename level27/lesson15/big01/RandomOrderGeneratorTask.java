package com.javarush.test.level27.lesson15.big01;

import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> tablets;
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(interval);
            } catch (InterruptedException ignore) {
                break;
            }
            Tablet tablet = tablets.get((int) (Math.random() * tablets.size()));
            tablet.createTestOrder();
        }
    }
}