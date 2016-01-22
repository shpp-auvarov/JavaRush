package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());
        FileInputStream fileInputStream2 = new FileInputStream(reader.readLine());
        FileInputStream fileInputStream3 = new FileInputStream(reader.readLine());
        while(fileInputStream2.available() > 0){
            int number = fileInputStream2.read();
            fileOutputStream.write(number);
        }
        while(fileInputStream3.available() > 0){
            int number = fileInputStream3.read();
            fileOutputStream.write(number);
        }
        reader.close();
        fileInputStream2.close();
        fileInputStream3.close();
        fileOutputStream.close();
    }
}
