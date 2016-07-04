package com.javarush.test.level34.lesson08.bonus01;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<K, V>();

    public V getByKey(K key, Class<V> clazz) throws Exception {
        if (!cache.containsKey(key)) {
            cache.put(key, clazz.getConstructor(key.getClass()).newInstance(key));
        }
        return cache.get(key);
    }

    public boolean put(V obj) {
        try {
            Method getKey = obj.getClass().getDeclaredMethod("getKey");
            getKey.setAccessible(true);
            cache.put((K) getKey.invoke(obj), obj);
        } catch (Exception ignore) {
            return false;
        }
        return true;
    }

    public int size() {
        return cache.size();
    }
}