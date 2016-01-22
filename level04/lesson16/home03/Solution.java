package com.javarush.test.level04.lesson16.home03;

import java.io.*;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean m = true;
        int sum = 0;
        while (m){
            int s = Integer.parseInt(reader.readLine());
            sum = sum + s;
            if (s==-1){
                m = false;
                System.out.println(sum);
            }
        }
        //напишите тут ваш код
    }
}
