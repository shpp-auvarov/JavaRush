package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
Хочу сделать метод, который будет заменять цифры 3,4,6, стоящие в начале, середине или в конце слова, на буквы "з", "ч", "б" соответственно,
а остальные цифры просто удалять.
Например: строку Я не сп5ал 20 4асов7 он будет менять на Я не спал 20 часов.
*/
public class Solution2
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        deleteNumberAndReplace(s);
        System.out.println(s);
    }
    public static void deleteNumberAndReplace(String s){
        for (int i = 0; i < s.length(); i++) {
            StringBuffer str = new StringBuffer(s);
            if(deleteNumber(Integer.valueOf(s.substring(i, i + 1)))){
                str.replace(i, i+1, "");
                s = str.toString();
                i--;
            }else if (Integer.valueOf(s.substring(i, i + 1)) ==3){
                str.replace(i, i + 1, "з");
                s = str.toString();
            }else if (Integer.valueOf(s.substring(i, i + 1)) ==4){
                str.replace(i, i+1, "ч");
                s = s.toString();
            }else if (Integer.valueOf(s.substring(i, i + 1)) ==6){
                str.replace(i, i+1, "б");
                s = str.toString();
            }
        }
    }
    public static Boolean deleteNumber(Integer s){
        //int newS = Integer.parseInt(s);
        ArrayList<Integer> Numbers = new ArrayList<Integer>();
        Numbers.add(1);
        Numbers.add(2);
        Numbers.add(4);
        Numbers.add(5);
        Numbers.add(7);
        Numbers.add(8);
        Numbers.add(9);
        Numbers.add(0);
        for (int i = 0; i < Numbers.size(); i++) {
            if (s == Numbers.get(i)){
                return true;
            }
        }
        return false;
    }
}