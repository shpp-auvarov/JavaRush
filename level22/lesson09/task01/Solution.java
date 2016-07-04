package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(reader.readLine()));
        String line;
        Map<String, Integer> workBase = new HashMap<>();
        while ((line = bufferedReader.readLine()) != null) {
            String[] base = line.split(" ");
            for (int i = 0; i < base.length; i++) {
                String word = base[i];
                if (workBase.containsKey(word)) {
                    workBase.put(word, workBase.get(word) + 1);
                } else {
                    workBase.put(word, 1);
                }
            }
        }
        reader.close();
        bufferedReader.close();
        Map<String, String> resultMap = new HashMap<>();
        for (Map.Entry<String, Integer> element : workBase.entrySet()) {
            String word = element.getKey();
            StringBuilder stringBuilder = new StringBuilder(word);
            String reverse = stringBuilder.reverse().toString();
            if (workBase.containsKey(reverse)) {
                if (word.equals(reverse)) {
                    if (element.getValue() > 1) {
                        if (!resultMap.containsKey(word)) {
                            resultMap.put(word, reverse);
                        }
                    }
                } else {
                    if ((!resultMap.containsKey(word)) && (!resultMap.containsKey(reverse))) {
                        resultMap.put(word, reverse);
                    }
                }
            }
        }
        for (Map.Entry<String, String> element : resultMap.entrySet()) {
            Pair pair = new Pair();
            pair.first = element.getKey();
            pair.second = element.getValue();
            result.add(pair);
        }
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).first + " " + result.get(i).second);
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
