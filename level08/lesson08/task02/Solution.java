package com.javarush.test.level08.lesson08.task02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        //напишите тут ваш код
        HashSet<Integer> numbers = new HashSet<Integer>();
        for (int i = 0; i < 20; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        //напишите тут ваш код
        /*Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            int number = iterator.next();
            if(number > 10)
                set.remove(iterator);

        }*/
        HashSet<Integer> newSet = new HashSet<Integer>();
        for(int i : set){
            if(i < 10){
                newSet.add(i);
            }
        }
        return newSet;

    }
}
