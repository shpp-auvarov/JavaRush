package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел.
Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно.
Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        //напишите тут ваш код
        ArrayList<int[]> list = new ArrayList<int[]>();

        int[] list1 = new int[5];
        for (int i = 0; i < list1.length; i++) {
            list1[i]= i;
        }
        int[] list2 = new int[2];
        for (int i = 0; i < list2.length; i++) {
            list2[i]= i;
        }
        int[] list3 = new int[4];
        for (int i = 0; i < list3.length; i++) {
            list3[i]= i;
        }
        int[] list4 = new int[7];
        for (int i = 0; i < list4.length; i++) {
            list4[i]= i;
        }
        int[] list5 = new int[0];
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        list.add(list5);

        return list;
     }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
