package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        int countSpace = 0;
        int countTotalAmount = 0;
        String line = "";
        while ((line = reader.readLine()) != null) {
            char[] array = line.toCharArray();
            for (int i = 0; i < array.length; i++) {
                countTotalAmount++;
                if (array[i] == ' ') {
                    countSpace++;
                }
            }
        }
        reader.close();
        System.out.println(Math.round(countSpace * 1.0 / countTotalAmount * 100.0));

    }
}
