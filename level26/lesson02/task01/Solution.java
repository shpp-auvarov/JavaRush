package com.javarush.test.level26.lesson02.task01;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static void main(String[] args) {
        Integer[] test = {5, 3, 2, 1, 4};
        test = sort(test);
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }

    public static Integer[] sort(Integer[] array) {
        int median = findMedian(array);
        Map<Integer, ArrayList<Integer>> base = new TreeMap<>();
        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            int distance = Math.abs(number - median);
            if (base.containsKey(distance)) {
                ArrayList<Integer> ElementArray = base.get(distance);
                ElementArray.add(number);
                base.put(distance, ElementArray);
            } else {
                ArrayList<Integer> firstElementArray = new ArrayList<>();
                firstElementArray.add(number);
                base.put(distance, firstElementArray);
            }
        }
        int count = 0;
        Integer[] result = new Integer[array.length];
        for (Map.Entry<Integer, ArrayList<Integer>> element : base.entrySet()) {
            ArrayList<Integer> baseArray = element.getValue();
            Integer[] arrayResult = new Integer[baseArray.size()];
            for (int i = 0; i < baseArray.size(); i++) {
                arrayResult[i] = baseArray.get(i);
            }
            arrayResult = quickSort(arrayResult, 0, arrayResult.length - 1);
            for (int i = 0; i < arrayResult.length; i++) {
                result[count] = arrayResult[i];
                count++;
            }
        }
        return result;
    }

    private static int findMedian(Integer[] array) {
        array = quickSort(array, 0, array.length - 1);
        if (array.length % 2 == 0) {
            return (array[array.length / 2 - 1] + array[array.length / 2]) / 2;
        } else {
            return array[array.length / 2];
        }
    }

    public static Integer[] quickSort(Integer[] arr, int start, int end) {
        int p = arr[end];
        int indexLast = -1;
        for (int i = start; i <= end; i++) {
            int number = arr[i];
            if ((number >= p) && (indexLast == -1)) {
                indexLast = i;
            } else if ((number < p) && (indexLast != -1)) {
                int temp = arr[indexLast];
                arr[indexLast] = number;
                arr[i] = temp;
                indexLast++;
            }
        }
        if (indexLast != -1) {
            int temp = arr[indexLast];
            arr[indexLast] = p;
            arr[end] = temp;

            if (indexLast - start > 1) {
                arr = quickSort(arr, start, indexLast - 1);
            }
            if (end - indexLast > 1) {
                arr = quickSort(arr, indexLast + 1, end);
            }
        }
        return arr;
    }
}
