package com.javarush.test.level30.lesson08.task01;

/* Найдем число 2 в максимальной степени
Реализуйте логику метода maxPowerOf2,
который должен возвращать число 2 в максимальной степени, которое получается поместить в переданное число
Аргументом maxPowerOf2 может быть только положительное число
Используйте только операции: 1)побитовые сдвиги, 2) присваивание, 3) побитовое ИЛИ
Не оставляйте комментарии
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(maxPowerOf2(140_000));   //131072
        System.out.println(maxPowerOf2(1026));      //1024
        System.out.println(maxPowerOf2(17));        //16
        System.out.println();
        System.out.println();
        System.out.println();

        int x = 131072;
        System.out.println(x + " " + Integer.toString(x, 2) + " | " + (x >> 1) + " " +Integer.toString((x >> 1), 2));
        x |= x >> 1;
        System.out.println(x + " " + Integer.toString(x, 2) + " | " + (x >> 1) + " " +Integer.toString((x >> 1), 2));
        x |= x >> 2;
        System.out.println(x + " " + Integer.toString(x, 2) + " | " + (x >> 1) + " " +Integer.toString((x >> 1), 2));

        x |= x >> 4;
        System.out.println(x + " " + Integer.toString(x, 2) + " | " + (x >> 1) + " " +Integer.toString((x >> 1), 2));

        x |= x >> 8;
        System.out.println(x + " " + Integer.toString(x, 2) + " | " + (x >> 1) + " " +Integer.toString((x >> 1), 2));

        x |= x >> 16;
        System.out.println(x + " " + Integer.toString(x, 2) + " ^ " + (x >> 1) + " " +Integer.toString((x >> 1), 2));
        System.out.println((x ^ (x >> 1)) + " " +Integer.toString(x ^ (x >> 1), 2));
    }

    public static int maxPowerOf2(int x) {
        int part = x >> 1;
        x = x | part;
        part = x >> 2;
        x = x | part;
        part = x >> 4;
        x = x | part;
        part = x >> 5;
        x = x | part;
        part = x >> 8;
        x = x | part;
        part = x >> 16;
        x = x | part;
        int last = x >> 1;
        int result = x ^ last;
        return result;

//        x |= x >> 1;
//        x |= x >> 2;
//        x |= x >> 4;
//        x |= x >> 8;
//        x |= x >> 16;
//        return x ^ (x >> 1);
    }
}
