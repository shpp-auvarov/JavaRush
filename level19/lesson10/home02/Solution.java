package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        HashMap<String, Double> dataBase = new HashMap<>();
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
        double maxValue = 0;
        for (Map.Entry<String, Double> e : dataBase.entrySet()) {
            if (e.getValue() > maxValue) {
                maxValue = e.getValue();
            }
        }
        for (Map.Entry<String, Double> e : dataBase.entrySet()) {
            if (e.getValue() == maxValue) {
                System.out.println(e.getKey());
                ;
            }
        }
    }
}
