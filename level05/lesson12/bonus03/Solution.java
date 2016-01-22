package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int maximum = Integer.parseInt(reader.readLine());;
        int i = 0;
        while (i < N-1){
            int s = Integer.parseInt(reader.readLine());
            if (s > maximum){
                maximum = s;
            }
            i++;
        }

        //напишите тут ваш код




        System.out.println(maximum);
    }
}
