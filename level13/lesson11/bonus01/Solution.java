package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        BufferedReader reader1 = new BufferedReader(new FileReader(filename));
        ArrayList<Integer> list = new ArrayList<Integer>();
        String line = null;
        while ( (line = reader1.readLine()) != null){
            String[] ws = line.trim().split("\\s");
            for (String data : ws) {
                if (Integer.parseInt(data) % 2 == 0) {
                    list.add(Integer.parseInt(data));
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            int min = list.get(i);
            int s = i;
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(j) < min){
                    min = list.get(j);
                    s = j;
                }
            }
            if (s != i){
                int temp = list.get(i);
                list.set(i, list.get(s));
                list.set(s, temp);
            }
        }
//
        for (Integer element : list){
            System.out.println(element);
        }
    }
}
