package com.javarush.test.level14.lesson08.bonus01;

import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            int[] array = new int[1];
            System.out.println(array[2]);

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            Object[] s = new Integer[4];
            s[0] = 4.4;


        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new IllegalArgumentException("Some message");


        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new NullPointerException();


        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new NumberFormatException();


        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new InterruptedException();


        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new IllegalThreadStateException();


        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new IndexOutOfBoundsException();


        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            throw new NegativeArraySizeException();


        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here

    }
}
