package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            String s = reader.readLine();
            if (s.contains("obj")){
                String[] ws = s.trim().split("\\?");
                String[] newWS = ws[1].trim().split("&");
                ArrayList<Integer> numbers = new ArrayList<Integer>();
                for (int i = 0; i < newWS.length; i++) {
                    String[] otherWS = newWS[i].trim().split("=");
                    if (otherWS[0].equals("obj")){
                        numbers.add(i);
                    }
                    if (i == newWS.length-1) {
                        System.out.print(otherWS[0]);
                    }else{
                        System.out.print(otherWS[0] + " ");
                    }
                }
                System.out.println();
                for (int k = 0; k < numbers.size(); k++) {
                    String[] lastWS = newWS[numbers.get(k)].trim().split("=");
                    if (checkString(lastWS[1])){
                       alert(Double.parseDouble(lastWS[1]));
                     }else {
                        alert(lastWS[1]);
                     }
                }
            }else {
                String[] ws = s.trim().split("\\?");
                String[] newWS = ws[1].trim().split("&");
                for (int i = 0; i < newWS.length; i++) {
                    String[] otherWS = newWS[i].trim().split("=");
                    if (i == newWS.length-1) {
                        System.out.print(otherWS[0]);
                    }else{
                        System.out.print(otherWS[0] + " ");
                    }
                }
            }

        } catch (Exception e){
            System.out.println("Sorry try again");
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
    public static boolean checkString(String string) {
        try {
            Double.parseDouble(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
