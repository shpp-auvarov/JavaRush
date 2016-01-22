package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).  Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
…
я 9
*/

public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++)
        {
            alphabet.add(abcArray[i]);
        }

        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
        {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < abcArray.length; i++) {
            map.put(abcArray[i], 0);
        }
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            char[] word = s.toCharArray();
            for (int j = 0; j < word.length; j++) {
                if(map.containsKey(word[j])){
                    map.put(word[j], map.get(word[j])+1);
                }
            }
        }
        for (int i = 0; i < abcArray.length; i++) {
            System.out.println(abcArray[i] + " " + map.get(abcArray[i]));
        }


        //напишите тут ваш код
    }

}
