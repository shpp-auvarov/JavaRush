package com.javarush.test.level30.lesson02.task01;

/* Осваиваем методы класса Integer
Используя метод Integer.parseInt(String, int) реализуйте логику метода convertToDecimalSystem,
который должен переводить переданную строку в десятичное число и возвращать его в виде строки.
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        int result;
        String firstTwoLetters = s.substring(0, 2);
        String firstLetter = s.substring(0, 1);
        if (firstTwoLetters.equals("0x")){
            result = Integer.valueOf(s.substring(2), 16);
        }else if (firstTwoLetters.equals("0b")){
            result = Integer.valueOf(s.substring(2), 2);
        }else if (firstLetter.equals("0")){
            result = Integer.valueOf(s.substring(1), 8);
        }else {
            result = Integer.parseInt(s);
        }
        return result + "";
    }
}
