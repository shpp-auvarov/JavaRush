package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        args = new String[1];
        args[0] = "span";
        String tag = "<" + args[0];
        String tagEnd = "</" + args[0] + ">";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(reader.readLine()));
        TreeMap<Integer, String> result = new TreeMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        String resultString = stringBuilder.toString();
        ArrayList<TransferNumber> indicesStart = new ArrayList<>();
        int count = 0;
        for (int i = resultString.indexOf(tag); i < resultString.length() - tagEnd.length() + 1; i++) {
            if (resultString.substring(i, i + tag.length()).equals(tag)) {
                indicesStart.add(new TransferNumber(count, i));
                count++;
            } else if (resultString.substring(i, i + tagEnd.length()).equals(tagEnd)) {
                int indexEndOfCutting = i + tagEnd.length();
                result.put(indicesStart.get(indicesStart.size() - 1).order, resultString.substring(indicesStart.get(indicesStart.size() - 1).value, indexEndOfCutting));
                indicesStart.remove(indicesStart.get(indicesStart.size() - 1));
            }
        }
        reader.close();
        bufferedReader.close();
        for (int i = 0; i < result.size(); i++) {
            if (i != result.size() - 1) {
                System.out.println(result.get(i));
            } else {
                System.out.print(result.get(i));
            }
        }
    }

    private static class TransferNumber {
        private Integer order;
        private Integer value;

        public TransferNumber(Integer order, Integer value) {
            this.order = order;
            this.value = value;
        }
    }
}
