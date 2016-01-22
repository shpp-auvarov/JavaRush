package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while (!(line = reader.readLine()).equals("exit")) {
            new ReadThread(line).run();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(fileName);
                int[] array = new int[256];
                while (fileInputStream.available() > 0) {
                    array[fileInputStream.read()]++;
                }
                fileInputStream.close();
                int maxInt = array[0];
                int index = 0;
                for (int i = 0; i < array.length; i++) {
                    if (array[i] > maxInt) {
                        maxInt = array[i];
                        index = i;
                    }
                }
                resultMap.put(fileName, index);
            } catch (IOException e) {
            }
        }
    }
}
