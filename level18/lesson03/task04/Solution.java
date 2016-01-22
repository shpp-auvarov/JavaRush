package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> array = new HashMap<>();
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        int firstNumber = fileInputStream.read();
        array.put(firstNumber, 1);
        while (fileInputStream.available() > 0) {
            int number = fileInputStream.read();
            if (array.containsKey(number)) {
                array.put(number, array.get(number) + 1);
            } else {
                array.put(number, 1);
            }
        }
        reader.close();
        fileInputStream.close();

        int minNumber = array.get(firstNumber);
        for (Map.Entry<Integer, Integer> element : array.entrySet()) {
            if (element.getValue() < minNumber) {
                minNumber = element.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> element : array.entrySet()) {
            if (element.getValue() == minNumber) {
                System.out.println(element.getKey() + " ");
            }
        }
    }
}
