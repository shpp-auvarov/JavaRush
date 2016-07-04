package com.javarush.test.level22.lesson13.task03;

/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println("+380501234567" + " " + checkTelNumber("+380501234567"));
        System.out.println("+38(050)1234567" + " " + checkTelNumber("+38(050)1234567"));
        System.out.println("+38050123-45-67" + " " + checkTelNumber("+38050123-45-67"));
        System.out.println("050123-4567" + " " + checkTelNumber("050123-4567"));

        System.out.println("+38)050(1234567" + " " + checkTelNumber("+38)050(1234567"));
        System.out.println("+38(050)1-23-45-6-7" + " " + checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println("050ххх4567" + " " + checkTelNumber("050ххх4567"));
        System.out.println("050123456" + " " + checkTelNumber("050123456"));
        System.out.println("(0)501234567" + " " + checkTelNumber("(0)501234567"));
    }

    public static boolean checkTelNumber(String telNumber) {
        if (telNumber.charAt(0) == '+') {
            if (telNumber.substring(1).replaceAll("[^0-9]", "").length() != 12) {
                return false;
            }
        }
        if (telNumber.substring(0, 1).replaceAll("[0-9,(]", "").length() == 0) {
            if (telNumber.replaceAll("[^0-9]", "").length() != 10) {
                return false;
            }
        }
        if (telNumber.replaceFirst("[-]", "").replaceFirst("[-]", "").contains("-")) {
            return false;
        }
        if (telNumber.contains("--")) {
            return false;
        }
        if (telNumber.replaceAll("[^),(]", "").length() != 0) {
            if (telNumber.replaceAll("[^),(]", "").length() != 2) {
                return false;
            }
            if (telNumber.replaceAll("[^(]", "").length() != 1) {
                return false;
            }
            if (telNumber.replaceAll("[^)]", "").length() != 1) {
                return false;
            }
            if (telNumber.indexOf(")") < telNumber.indexOf("(")) {
                return false;
            }
            if (telNumber.indexOf(")") - telNumber.indexOf("(") != 4) {
                return false;
            }
            if (telNumber.indexOf(")") > telNumber.indexOf("-") && telNumber.indexOf("-") != -1) {
                return false;
            }
        }
        if (telNumber.substring(telNumber.length() - 1).replaceAll("[^a-zA-Z]", "").length() > 0) {
            return false;
        }
        if (telNumber.substring(telNumber.length() - 1).replaceAll("[0-9]", "").length() == 1) {
            return false;
        }
        return true;
    }
}
