package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulatorFactory {
    public static final Map<String, CurrencyManipulator> MANIPULATORS = new HashMap();

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        if (MANIPULATORS.containsKey(currencyCode)) {
            return MANIPULATORS.get(currencyCode);
        } else {
            CurrencyManipulator currencyManipulator = new CurrencyManipulator(currencyCode);
            MANIPULATORS.put(currencyCode, currencyManipulator);
            return currencyManipulator;
        }
    }

    private CurrencyManipulatorFactory() {
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return MANIPULATORS.values();
    }

    public static boolean hasMoney() {
        for (Map.Entry<String, CurrencyManipulator> element : CurrencyManipulatorFactory.MANIPULATORS.entrySet()) {
            if (element.getValue().getTotalAmount() > 0) {
                return true;
            }
        }
        return false;
    }
}
