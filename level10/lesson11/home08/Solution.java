package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //напишите тут ваш код
        ArrayList<String>[] lists = new ArrayList[5];
        ArrayList<String> list1 = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            list1.add("name" + i);
        }
        ArrayList<String> list2 = new ArrayList<String>();
        for (int i = 0; i < 4; i++) {
            list2.add("name" + i);
        }
        ArrayList<String> list3 = new ArrayList<String>();
        for (int i = 0; i < 3; i++) {
            list3.add("name" + i);
        }
        ArrayList<String> list4 = new ArrayList<String>();
        for (int i = 0; i < 7; i++) {
            list4.add("name" + i);
        }
        ArrayList<String> list5 = new ArrayList<String>();
        for (int i = 0; i < 2; i++) {
            list5.add("name" + i);
        }
        lists[0] = list1;
        lists[1] = list2;
        lists[2] = list3;
        lists[3] = list4;
        lists[4] = list5;

        return lists;

    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}