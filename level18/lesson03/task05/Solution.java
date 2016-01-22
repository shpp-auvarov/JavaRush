package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        while (fileInputStream.available() > 0) {
            int number = fileInputStream.read();
            if (!list.contains(number)) {
                list.add(number);
            }
        }
        reader.close();
        fileInputStream.close();

        for (int i = 0; i < list.size(); i++) {
            int minNumber = list.get(i);
            int index = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < minNumber) {
                    index = j;
                    minNumber = list.get(j);
                }
            }
            if (index != i) {
                int temp = list.get(i);
                int tempIndex = list.get(index);
                list.remove(i);
                list.add(i, tempIndex);
                list.remove(index);
                list.add(index, temp);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " ");
        }
    }
}
