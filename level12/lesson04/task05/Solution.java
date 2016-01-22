package com.javarush.test.level12.lesson04.task05;

/* Три метода возвращают максимальное из двух переданных в него чисел
Написать public static методы: int max(int, int), long max (long, long), double max (double, double).
Каждый метод должен возвращать максимальное из двух переданных в него чисел.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    //Напишите тут ваши методы
    public static int max (int m1, int m2){
        if (m1 > m2){
            return m1;
        }else {
            return m2;
        }
    }
    public static long max (long m1, long m2){
        if (m1 > m2){
            return m1;
        }else {
            return m2;
        }
    }
    public static double max (double m1, double m2){
        if (m1 > m2){
            return m1;
        }else {
            return m2;
        }
    }
}
