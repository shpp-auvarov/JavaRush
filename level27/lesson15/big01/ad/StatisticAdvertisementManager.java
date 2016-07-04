package com.javarush.test.level27.lesson15.big01.ad;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();

    public static StatisticAdvertisementManager getInstance() {
        return ourInstance;
    }

    private StatisticAdvertisementManager() {
    }

    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    public TreeMap<Advertisement, String> videoRequest(boolean active) {
        ArrayList<Advertisement> result = new ArrayList<>();
        List<Advertisement> base = advertisementStorage.list();
        if (active) {
            for (int i = 0; i < base.size(); i++) {
                Advertisement advertisement = base.get(i);
                if (advertisement.getHits() >= 1) {
                    result.add(advertisement);
                }
            }
        } else {
            for (int i = 0; i < base.size(); i++) {
                Advertisement advertisement = base.get(i);
                if (advertisement.getHits() <= 0) {
                    result.add(advertisement);
                }
            }
        }
        TreeMap<Advertisement, String> resultBase = new TreeMap<>(new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
            }
        });
        for (int i = 0; i < result.size(); i++) {
            resultBase.put(result.get(i), "");
        }
        return resultBase;
    }
}
