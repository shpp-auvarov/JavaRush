package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        int result = 0;
        String line = "";
        while ((line = reader1.readLine()) != null) {
            String[] array = line.replaceAll("\\p{Punct}", " ").toLowerCase().split(" ");
            for (int i = 0; i < array.length; i++) {
                if (array[i].equals("world")){
                    result++;
                }
            }
        }
        System.out.println(result);
        reader.close();
        reader1.close();
    }
}
