package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            String[] base = line.split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < base.length - 3; i++) {
                stringBuilder.append(base[i]);
                if (i != base.length - 4) {
                    stringBuilder.append(" ");
                }
            }
            String name = stringBuilder.toString();
            String date = base[base.length - 2] + "/" + base[base.length - 3] + "/" + base[base.length - 1];
            PEOPLE.add(new Person(name, new Date(date)));
        }
        bufferedReader.close();
    }
}
