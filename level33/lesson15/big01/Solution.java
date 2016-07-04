package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> result = new HashSet<>();
        for (String element : strings) {
            Long longElement = shortener.getId(element);
            if (longElement != null) {
                result.add(longElement);
            }
        }
        return result;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> result = new HashSet<>();
        for (Long element : keys) {
            String longElement = shortener.getString(element);
            if (longElement != null) {
                result.add(longElement);
            }
        }
        return result;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> base = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            base.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);
        Long startingTime = new Date().getTime();
        Set<Long> idResultBase = getIds(shortener, base);
        Long endTime = new Date().getTime();
        Long duration = endTime - startingTime;
        Helper.printMessage(duration.toString());

        startingTime = new Date().getTime();
        Set<String> stringsResultBase = getStrings(shortener, idResultBase);
        endTime = new Date().getTime();
        duration = endTime - startingTime;
        Helper.printMessage(duration.toString());
        if (base.equals(stringsResultBase)) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }
    }

    public static void main(String[] args) {
        StorageStrategy storageStrategy = new HashMapStorageStrategy();
        testStrategy(storageStrategy, 100);
        StorageStrategy storageStrategy2 = new OurHashMapStorageStrategy();
        testStrategy(storageStrategy2, 100);
        StorageStrategy storageStrategy3 = new FileStorageStrategy();
        testStrategy(storageStrategy3, 100);
        StorageStrategy storageStrategy4 = new OurHashBiMapStorageStrategy();
        testStrategy(storageStrategy4, 100);
        StorageStrategy storageStrategy5 = new HashBiMapStorageStrategy();
        testStrategy(storageStrategy5, 100);
        StorageStrategy storageStrategy6 = new DualHashBidiMapStorageStrategy();
        testStrategy(storageStrategy6, 100);

    }
}