package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader secondReader = new BufferedReader(new FileReader(reader.readLine()));
        FileWriter fileWriter = new FileWriter(reader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        String line = "";
        while ((line = secondReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        String[] workArray = stringBuilder.toString().split(" ");
        stringBuilder = new StringBuilder();
        for (int i = 0; i < workArray.length; i++) {
            stringBuilder.append(Math.round(Double.parseDouble(workArray[i])) + " ");
        }
        String result = stringBuilder.toString();
        byte[] resultByteArray = result.getBytes();
        for (int i = 0; i < resultByteArray.length; i++) {
            fileWriter.write(resultByteArray[i]);
        }
        reader.close();
        secondReader.close();
        fileWriter.close();
    }
}
