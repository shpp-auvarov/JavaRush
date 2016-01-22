package com.javarush.test.level16.lesson07.task02;

/* Stopwatch (Секундомер)
1. Разберись, что делает программа.
2. Реализуй логику метода doSeveralSteps так, чтобы учитывалась скорость бегуна.
2.1. Метод getSpeed() в классе Runner показывает, сколько шагов в секунду делает бегун.
Нужно, чтобы бегун действительно делал заданное количество шагов в секунду.
Если Иванов делает 4 шага в секунду, то за 2 секунды он сделает 8 шагов.
Если Петров делает 2 шага в секунду, то за 2 секунды он сделает 4 шага.
2.2. Метод sleep в классе Thread принимает параметр типа long.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double[] list = new double[7];
        for (int i = 0; i < list.length; i++) {
            list[i] = Double.parseDouble(reader.readLine());
        }
        int result = calculateNorm(list, 40);
        System.out.println("our card result : " + result);
    }
    public static int calculateNorm(double[] array, int norm) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] / norm >= 1) {
                result++;
            }
        }
        return result;
    }
}
