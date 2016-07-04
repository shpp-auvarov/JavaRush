package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> QUEUE = new LinkedBlockingQueue<>();
    private static final LinkedBlockingQueue<Order> READY_QUEUE = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Cook cook1 = new Cook("Amigo");
        cook1.setQueue(QUEUE);
        cook1.setReadyQueue(READY_QUEUE);
        Cook cook2 = new Cook("Diego");
        cook2.setQueue(QUEUE);
        cook2.setReadyQueue(READY_QUEUE);

        List<Tablet> tabletList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            tablet.setQueue(QUEUE);
            tabletList.add(tablet);
        }

        Waitor waitor = new Waitor();
        waitor.setReadyQueue(READY_QUEUE);

        Thread thread = new Thread(new RandomOrderGeneratorTask(tabletList, ORDER_CREATING_INTERVAL));
        thread.start();
        Thread threadCook1 = new Thread(cook1);
        threadCook1.start();
        Thread threadCook2 = new Thread(cook2);
        threadCook2.start();
        Thread threadWaitor = new Thread(waitor);
        threadWaitor.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignore) {
        }
        thread.interrupt();
        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}