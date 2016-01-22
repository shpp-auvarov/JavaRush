package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(reader.readLine()));
        String line = "";
        while ((line = bufferedReader.readLine())!=null){
            for (int i = 0; i < line.length(); i++) {
                if (line.substring(i, i+1).equals(".")){
                    bufferedWriter.write("!");
                }else {
                    bufferedWriter.write(line.substring(i, i+1));
                }
            }
        }
        reader.close();
        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
