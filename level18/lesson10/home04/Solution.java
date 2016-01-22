package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(firstFile);
        ArrayList<Integer> backUp = new ArrayList<>();
        while (fileInputStream.available()> 0){
            backUp.add(fileInputStream.read());
        }
        fileInputStream.close();
        FileInputStream fileInputStreamSecondFile = new FileInputStream(reader.readLine());
        FileOutputStream fileOutputStream = new FileOutputStream(firstFile);
        while (fileInputStreamSecondFile.available() > 0){
            int data = fileInputStreamSecondFile.read();
            fileOutputStream.write(data);
        }
        for (int i = 0; i < backUp.size(); i++) {
            fileOutputStream.write(backUp.get(i));
        }
        reader.close();
        fileInputStreamSecondFile.close();
        fileOutputStream.close();
    }
}
