package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        args = new String[1];
        args[0] = "C:/Users/Andrey/Desktop/test3.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> dataBase = new TreeMap<>();
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            String[] base = line.split(" ");
            String name = base[0];
            double value = Double.parseDouble(base[1]);
            if (dataBase.containsKey(name)) {
                dataBase.put(name, dataBase.get(name) + value);
            } else {
                dataBase.put(name, value);
            }
        }
        bufferedReader.close();
        for (Map.Entry<String, Double> e : dataBase.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
