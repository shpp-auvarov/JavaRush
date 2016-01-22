package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        Integer[] list = new Integer[5];
        list[0] = Integer.parseInt(reader.readLine());
        list[1] = Integer.parseInt(reader.readLine());
        list[2] = Integer.parseInt(reader.readLine());
        list[3] = Integer.parseInt(reader.readLine());
        list[4] = Integer.parseInt(reader.readLine());

        for (int i = 0; i < list.length; i++) {
            int min = list[i];
            int s = i;
            for (int j = i+1; j < list.length; j++) {
                if (list[j] < min){
                    min = list[j];
                    s = j;
                }
            }
            if (s != i){
                int temp = list[i];
                list[i] = list[s];
                list[s] = temp;
            }
        }
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }


        //напишите тут ваш код
    }
}
