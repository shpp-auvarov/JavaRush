package com.javarush.test.level12.lesson04.task04;

/* Три метода возвращают минимальное из двух переданных в него чисел
Написать public static методы: int min(int, int), long min(long, long), double min(double, double).
Каждый метод должен возвращать минимальное из двух переданных в него чисел.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    //Напишите тут ваши методы
    public static int min(int i1, int i2){
        if (i1 > i2){
            return i2;
        }else {
            return i1;
        }
    }
    public static long min(long i1, long i2){
        if (i1 > i2){
            return i2;
        }else {
            return i1;
        }
    }
    public static double min(double i1, double i2){
        if (i1 > i2){
            return i2;
        }else {
            return i1;
        }
    }
}
