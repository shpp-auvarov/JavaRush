package com.javarush.test.level33.lesson15.big01.tests;

import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.HashBiMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {
    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        long startTime = new Date().getTime();
        for (String element : strings) {
            ids.add(shortener.getId(element));
        }
        long endTime = new Date().getTime();
        return endTime - startTime;
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        long startTime = new Date().getTime();
        for (Long element : ids) {
            strings.add(shortener.getString(element));
        }
        long endTime = new Date().getTime();
        return endTime - startTime;
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10_000; i++) {
            origStrings.add(Helper.generateRandomString());
        }
        Set<Long> origIds = new HashSet<>();
        for (long i = 0; i < 10_000; i++) {
            origIds.add(i);
        }
        long firstDuration = getTimeForGettingIds(shortener1, origStrings, origIds);
        long secondDuration = getTimeForGettingIds(shortener2, origStrings, origIds);
        Assert.assertTrue(firstDuration > secondDuration);
        firstDuration = getTimeForGettingStrings(shortener1, origIds, origStrings);
        secondDuration = getTimeForGettingStrings(shortener2, origIds, origStrings);
        Assert.assertEquals(firstDuration, secondDuration, 5);
    }
}