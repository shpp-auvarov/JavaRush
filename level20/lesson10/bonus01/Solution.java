package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static void main(String[] args) {
        int[] number = getNumbers(10000);
        for (int i = 0; i < number.length; i++) {
            System.out.println(number[i]);
        }
    }

    public static int[] getNumbers(int N) {
        ArrayList<Integer> base = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            if (isRightNumber(i)) {
                base.add(i);
            }
        }

        int[] result = new int[base.size()];
        for (int i = 0; i < base.size(); i++) {
            result[i] = base.get(i);
        }
        return result;
    }

    private static boolean isRightNumber(int number) {
        int count = 0;
        int workNumber = number;
        ArrayList<Integer> base = new ArrayList<>();
        while (workNumber > 0) {
            base.add(workNumber % 10);
            workNumber = workNumber / 10;
        }
        int size = base.size();
        for (int i = 0; i < size; i++) {
            int element = base.get(i);
            int result = element;
            for (int j = 1; j < size; j++) {
                result *= element;
            }
            count += result;
        }
        return (count == number) ? true : false;
    }
}
