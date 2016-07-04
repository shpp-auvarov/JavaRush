package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.Advertisement;
import com.javarush.test.level27.lesson15.big01.ad.StatisticAdvertisementManager;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {
    public void printAdvertisementProfit() {
        TreeMap<Date, Long> result = StatisticEventManager.getInstance().profitFromAdvertisement();
        long total = 0;
        for (Map.Entry<Date, Long> element : result.entrySet()) {
            total += element.getValue();
            ConsoleHelper.writeMessage(new SimpleDateFormat("dd-MMM-yyyy").format(element.getKey()) + " - " + String.format("%.2f", element.getValue() / 100f));
        }
        if (total > 0) {
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "Total - %.2f", total / 100f));
        }
        ConsoleHelper.writeMessage("");
    }

    public void printCookWorkloading() {
        TreeMap<Date, TreeMap<String, Integer>> result = StatisticEventManager.getInstance().cookWorkloading();
        for (Map.Entry<Date, TreeMap<String, Integer>> element : result.entrySet()) {
            ConsoleHelper.writeMessage(new SimpleDateFormat("dd-MMM-yyyy").format(element.getKey()));
            for (Map.Entry<String, Integer> innerElement : element.getValue().entrySet()) {
                if (innerElement.getValue() > 0) {
                    ConsoleHelper.writeMessage(innerElement.getKey() + " - " + innerElement.getValue() + " min");
                }
            }
            ConsoleHelper.writeMessage("");
        }
    }

    public void printActiveVideoSet() {
        TreeMap<Advertisement, String> base = StatisticAdvertisementManager.getInstance().videoRequest(true);
        for (Map.Entry<Advertisement, String> element : base.entrySet()) {
            Advertisement advertisement = element.getKey();
            ConsoleHelper.writeMessage(advertisement.getName() + " - " + advertisement.getHits());
        }
    }

    public void printArchivedVideoSet() {
        TreeMap<Advertisement, String> base = StatisticAdvertisementManager.getInstance().videoRequest(false);
        for (Map.Entry<Advertisement, String> element : base.entrySet()) {
            Advertisement advertisement = element.getKey();
            ConsoleHelper.writeMessage(advertisement.getName());
        }
    }
}
