package com.javarush.test.level26.lesson15.big01;


import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public String getCurrencyCode() {
        return currencyCode;
    }

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination)) {
            denominations.put(denomination, denominations.get(denomination) + count);
        } else {
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount() {
        int total = 0;
        for (Map.Entry<Integer, Integer> element : denominations.entrySet()) {
            total += element.getKey() * element.getValue();
        }
        return total;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException, ConcurrentModificationException {
        Map<Integer, Integer> newMap = new TreeMap(Collections.reverseOrder());
        newMap.putAll(denominations);
        int workAmount = expectedAmount;
        ArrayList<Integer> baseArray = new ArrayList<>();
        for (Map.Entry<Integer, Integer> element : newMap.entrySet()) {
            int key = element.getKey();
            int size = element.getValue();
            for (int i = 0; i < size; i++) {
                baseArray.add(key);
            }
        }
        ArrayList<Integer> resultArray = new ArrayList<>();
        int sizeArray = baseArray.size();
        for (int i = 0; i < sizeArray; i++) {
            int number = baseArray.get(i);
            if (workAmount == 0) {
                break;
            }
            if (isCorrect(baseArray, i, number, workAmount)) {
                workAmount -= number;
                resultArray.add(number);
            } else {
                for (int j = i + 1; j < sizeArray; j++) {
                    int newNumber = baseArray.get(j);
                    if (number != newNumber) {
                        i += j - i - 1;
                        break;
                    }
                }
            }
        }

        int total = 0;
        for (int i = 0; i < resultArray.size(); i++) {
            total += resultArray.get(i);
        }

        if (total == expectedAmount) {
            for (int i = 0; i < resultArray.size(); i++) {
                denominations.put(resultArray.get(i), denominations.get(resultArray.get(i)) - 1);
            }
            Map<Integer, Integer> resultMap = new TreeMap(Collections.reverseOrder());
            for (int i = 0; i < resultArray.size(); i++) {
                int number = resultArray.get(i);
                if (resultMap.containsKey(number)) {
                    resultMap.put(number, resultMap.get(number) + 1);
                } else {
                    resultMap.put(number, 1);
                }
            }
            return resultMap;
        } else {
            throw new NotEnoughMoneyException();
        }
    }

    private boolean isCorrect(ArrayList<Integer> baseArray, int index, int numberInArray, int Amount) {
        if (Amount - numberInArray < 0) {
            return false;
        } else if (Amount - numberInArray == 0) {
            return true;
        }
        Amount -= numberInArray;
        for (int i = index + 1; i < baseArray.size(); i++) {
            int workElement = baseArray.get(i);
            if (Amount - workElement == 0) {
                return true;
            }
            if (isCorrect(baseArray, i, workElement, Amount)) {
                return true;
            }
        }
        return false;
    }
}