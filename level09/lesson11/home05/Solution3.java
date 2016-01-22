package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
Хочу сделать метод, который будет заменять цифры 3,4,6, стоящие в начале, середине или в конце слова, на буквы "з", "ч", "б" соответственно,
а остальные цифры просто удалять.
Например: строку Я не сп5ал 20 4асов7 он будет менять на Я не спал 20 часов.
*/
public class Solution3
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] c = s.toCharArray();
        ArrayList<Character> isVowel_array = new ArrayList<Character>();
        //ArrayList<Character> isNotVowel_array = new ArrayList<Character>();
        for (int i = 0; i < c.length; i++) {
            if (isVowel(c[i])){

            }else if (c[i]!='3'){
                isVowel_array.add('з');
            }else if (c[i]!='4'){
                isVowel_array.add('ч');
            }else if (c[i]!='6'){
                isVowel_array.add('б');
            }else {
                isVowel_array.add(c[i]);
            }
        }
        String result = "";
        for (int i = 0; i < isVowel_array.size(); i++) {
           result+=String.valueOf(isVowel_array.get(i));
        }
        System.out.println(result);
    }
    public static char[] vowels = new char[]{'1', '2', '4', '5', '7', '8', '9', '0'};


    public static boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);

        for (char d : vowels)
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
