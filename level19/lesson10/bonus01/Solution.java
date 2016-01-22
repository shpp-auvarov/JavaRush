package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
               строка0            ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
               строка5            ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(reader.readLine()));
        ArrayList<String> dataBaseFromFile1 = new ArrayList<>();
        ArrayList<String> dataBaseFromFile2 = new ArrayList<>();
        String line = "";
        while ((line = bufferedReader1.readLine()) != null) {
            dataBaseFromFile1.add(line);
        }
        while ((line = bufferedReader2.readLine()) != null) {
            dataBaseFromFile2.add(line);
        }
        reader.close();
        bufferedReader1.close();
        bufferedReader2.close();

        while (true) {
            String firstFile = "";
            String secondFile = "";
            String firstFile2 = "";
            String secondFile2 = "";
            if (dataBaseFromFile1.size() > 0) {
                firstFile = dataBaseFromFile1.get(0);
            }
            if (dataBaseFromFile2.size() > 0) {
                secondFile = dataBaseFromFile2.get(0);
            }
            if (dataBaseFromFile1.size() > 1) {
                firstFile2 = dataBaseFromFile1.get(1);
            }
            if (dataBaseFromFile2.size() > 1) {
                secondFile2 = dataBaseFromFile2.get(1);
            }
            if (firstFile.equals(secondFile)) {
                lines.add(new LineItem(Type.SAME, firstFile));
                dataBaseFromFile1.remove(0);
                dataBaseFromFile2.remove(0);
            } else {
                if (secondFile.equals(firstFile2)) {
                    lines.add(new LineItem(Type.REMOVED, firstFile));
                    dataBaseFromFile1.remove(0);
                } else if (firstFile.equals(secondFile2)) {
                    lines.add(new LineItem(Type.ADDED, secondFile));
                    dataBaseFromFile2.remove(0);
                }
            }
            if (dataBaseFromFile1.size() == 0 && dataBaseFromFile2.size() == 0) {
                break;
            }
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

    }
}
