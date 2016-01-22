package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(reader.readLine()));
        String line = "";
        while ((line= bufferedReader.readLine())!=null){
            String[] array = line.split(" ");
            for (int i = 0; i < array.length; i++) {
                try {
                    int number = Integer.parseInt(array[i]);
                    bufferedWriter.write(number + " ");
                }catch (NumberFormatException e){

                }
            }
        }
        reader.close();
        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
