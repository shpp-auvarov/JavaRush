package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        if (a > b && a > c && a > d){
            System.out.println(a);
        }else if(b > a && b > c && b > d){
            System.out.println(b);
        }else if(c > a && c > b && c > d){
            System.out.println(c);
        }else{
            System.out.println(d);
        }

        //напишите тут ваш код

    }
}
