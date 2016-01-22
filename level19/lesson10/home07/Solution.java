package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]));
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            int count = 0;
            String[] base = line.split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < base.length; i++) {
                String word = base[i];
                if (word.length() > 6) {
                    stringBuilder.append(word + ",");
                    count++;
                }
            }
            if (count > 0) {
                String result = stringBuilder.toString();
                bufferedWriter.write(result.substring(0, result.length()-1));
                bufferedWriter.write("\r\n");
            }
        }
        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
