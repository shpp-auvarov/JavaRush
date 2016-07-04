package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

import static com.javarush.test.level27.lesson15.big01.statistic.event.EventType.COOKED_ORDER;
import static com.javarush.test.level27.lesson15.big01.statistic.event.EventType.SELECTED_VIDEOS;

public class StatisticEventManager {
    private static StatisticEventManager ourInstance = new StatisticEventManager();

    public static StatisticEventManager getInstance() {
        return ourInstance;
    }

    private StatisticEventManager() {
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    public StatisticStorage statisticStorage = new StatisticStorage();

    private class StatisticStorage {
        Map<EventType, List<EventDataRow>> storage;

        private StatisticStorage() {
            this.storage = new HashMap<>();
            EventType[] some = EventType.values();
            for (int i = 0; i < some.length; i++) {
                storage.put(some[i], new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }

        private TreeMap<Date, Long> profitFromAdvertisement() {
            HashMap<Date, Long> base = new HashMap<>();
            for (int i = 0; i < storage.get(SELECTED_VIDEOS).size(); i++) {
                VideoSelectedEventDataRow videoSelectedEventDataRow = (VideoSelectedEventDataRow) storage.get(SELECTED_VIDEOS).get(i);
                Calendar cal = Calendar.getInstance();
                cal.setTime(videoSelectedEventDataRow.getDate());
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                cal.set(Calendar.MILLISECOND, 0);
                Date keyDate = cal.getTime();
                if (base.containsKey(keyDate)) {
                    base.put(keyDate, base.get(keyDate) + videoSelectedEventDataRow.getAmount());
                } else {
                    base.put(keyDate, videoSelectedEventDataRow.getAmount());
                }
            }
            TreeMap<Date, Long> resultBase = new TreeMap<>(new Comparator<Date>() {
                @Override
                public int compare(Date date1, Date date2) {
                    return date2.after(date1) ? 1 : -1;
                }
            });
            resultBase.putAll(base);
            return resultBase;
        }

        private TreeMap<Date, TreeMap<String, Integer>> cookWorkloading() {
            HashMap<Date, HashMap<String, Integer>> base = new HashMap<>();
            for (int i = 0; i < storage.get(COOKED_ORDER).size(); i++) {
                CookedOrderEventDataRow cookedOrderEventDataRow = (CookedOrderEventDataRow) storage.get(COOKED_ORDER).get(i);
                Calendar cal = Calendar.getInstance();
                cal.setTime(cookedOrderEventDataRow.getDate());
                cal.set(Calendar.HOUR_OF_DAY, 0);
                cal.set(Calendar.MINUTE, 0);
                cal.set(Calendar.SECOND, 0);
                cal.set(Calendar.MILLISECOND, 0);
                Date keyDate = cal.getTime();
                String cookName = cookedOrderEventDataRow.getCookName();
                int workTimeByCook = (int) Math.ceil(cookedOrderEventDataRow.getTime() * 1.0 / 60);
                if (base.containsKey(keyDate)) {
                    HashMap<String, Integer> innerBase = base.get(keyDate);
                    if (innerBase.containsKey(cookName)) {
                        innerBase.put(cookName, innerBase.get(cookName) + workTimeByCook);
                    } else {
                        innerBase.put(cookName, workTimeByCook);
                    }
                } else {
                    base.put(keyDate, new HashMap<String, Integer>());
                    base.get(keyDate).put(cookName, workTimeByCook);
                }
            }
            TreeMap<Date, TreeMap<String, Integer>> resultBase = new TreeMap<>(new Comparator<Date>() {
                @Override
                public int compare(Date date1, Date date2) {
                    return date2.after(date1) ? 1 : -1;
                }
            });
            for (Map.Entry<Date, HashMap<String, Integer>> element : base.entrySet()) {
                HashMap<String, Integer> innerBase = element.getValue();
                for (Map.Entry<String, Integer> innerElement : innerBase.entrySet()) {
                    innerBase.put(innerElement.getKey(), innerElement.getValue());
                }
                TreeMap<String, Integer> innerResultBase = new TreeMap<>();
                innerResultBase.putAll(innerBase);
                resultBase.put(element.getKey(), innerResultBase);
            }
            return resultBase;
        }
    }

    public TreeMap<Date, Long> profitFromAdvertisement() {
        return statisticStorage.profitFromAdvertisement();
    }

    public TreeMap<Date, TreeMap<String, Integer>> cookWorkloading() {
        return statisticStorage.cookWorkloading();
    }

}
