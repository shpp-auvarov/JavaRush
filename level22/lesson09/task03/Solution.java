package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new FileReader(bufferedReader.readLine()));
            ArrayList<String> base = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] word = line.split(" ");
                for (int i = 0; i < word.length; i++) {
                    base.add(word[i]);
                }
            }
            bufferedReader.close();
            reader.close();
            String[] resultArray = new String[base.size()];
            for (int i = 0; i < base.size(); i++) {
                if (i == 0) {
                    resultArray[i] = base.get(i).substring(1);
                } else {
                    resultArray[i] = base.get(i);
                }
            }
            StringBuilder result = getLine(resultArray);
            System.out.println(result.toString());
        } catch (Exception e) {
        }
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int k = 0; k < words.length; k++) {
            ArrayList<String> someArray = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                someArray.add(words[i]);
            }
            stringBuilder = new StringBuilder();
            String ch = "";
            boolean work = true;
            boolean flag = false;
            while (someArray.size() != 0 && work) {
                if (flag) {
                    for (int i = 0; i < someArray.size(); i++) {
                        String word = someArray.get(i);
                        if (word.substring(0, 1).toLowerCase().equals(ch)) {
                            if (isConsistOneSequence(someArray, i)) {
                                stringBuilder.append(" " + word);
                                ch = word.substring(word.length() - 1).toLowerCase();
                                someArray.remove(i);
                                break;
                            }
                        }
                        if (i == someArray.size() - 1) {
                            work = false;
                            stringBuilder = new StringBuilder();
                        }
                    }
                } else {
                    for (int i = k; i < someArray.size(); i++) {
                        if (isConsistOneSequence(someArray, i)) {
                            String word = someArray.get(i);
                            ch = word.substring(word.length() - 1).toLowerCase();
                            stringBuilder.append(word);
                            flag = true;
                            someArray.remove(i);
                            break;
                        }
                    }
                    if (!flag) {
                        work = false;
                        k = words.length;
                    }
                }
            }
            if (someArray.size() == 0) {
                break;
            }
        }
        return stringBuilder;
    }

    private static boolean isConsistOneSequence(ArrayList<String> baseArray, int index) {
        if (baseArray.size() == 1) {
            return true;
        }
        for (int k = 0; k < baseArray.size(); k++) {
            if (k != index) {
                String startLetter = baseArray.get(k).substring(0, 1).toLowerCase();
                String lastLetter = baseArray.get(index).substring(baseArray.get(index).length() - 1).toLowerCase();
                if (startLetter.equals(lastLetter)) {
                    lastLetter = baseArray.get(k).substring(baseArray.get(k).length() - 1).toLowerCase();
                    ArrayList<String> someArray = new ArrayList<>();
                    for (int i = 0; i < baseArray.size(); i++) {
                        if ((i != k) && (i != index)) {
                            someArray.add(baseArray.get(i));
                        }
                    }
                    boolean work = true;
                    while (someArray.size() != 0 && work) {
                        for (int i = 0; i < someArray.size(); i++) {
                            String word = someArray.get(i);
                            if (word.substring(0, 1).toLowerCase().equals(lastLetter)) {
                                if (isConsistOneSequence(someArray, i)) {
                                    lastLetter = word.substring(word.length() - 1).toLowerCase();
                                    someArray.remove(i);
                                    break;
                                }
                            }
                            if (i == someArray.size() - 1) {
                                work = false;
                            }
                        }
                    }

                    if (someArray.size() == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
