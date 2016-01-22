package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer[] number = new Integer[20];
        for (int i = 0; i < 20; i++) {
            number[i] = Integer.parseInt(reader.readLine());
        }
        Integer[] number1 = new Integer[10];
        Integer[] number2 = new Integer[10];
        for (int i = 0; i < 10; i++) {
            number1[i] = number[i];
        }
        for (int i = 10; i < number.length; i++) {
            number2[i-10] = number[i];
        }
        for (int i = 0; i < number2.length; i++) {
            System.out.println(number2[i]);
        }
        //напишите тут ваш код

    }
}
