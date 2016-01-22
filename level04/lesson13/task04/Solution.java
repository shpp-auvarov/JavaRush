package com.javarush.test.level04.lesson13.task04;

import java.io.*;

/* Рисуем линии
Используя цикл for вывести на экран:
- горизонтальную линию из 10 восьмёрок
- вертикальную линию из 10 восьмёрок.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        for (int i = 0; i < 11; i++) {
            if (i == 0){
                System.out.println("8888888888");
            }
            else {
                System.out.println(8);
            }
        }
        //напишите тут ваш код

    }
}
