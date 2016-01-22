package com.javarush.test.level17.lesson10.bonus02;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public volatile static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException {
        if (args[0].equals("-c")) {
            for (int i = 0; i < args.length / 3; i++) {
                String[] time = args[3 + 3 * i].split("/");
                String newTime = time[1] + "/" + time[0] + "/" + time[2];
                if (args[2 + i * 3].toLowerCase().equals("м")) {
                    allPeople.add(Person.createMale(args[1 + 3 * i], new Date(newTime)));
                } else {
                    allPeople.add(Person.createFemale(args[1 + 3 * i], new Date(newTime)));
                }
                System.out.println(allPeople.size() - 1);
            }
        } else if (args[0].equals("-u")) {
            for (int i = 0; i < args.length / 4; i++) {
                String[] time = args[4 + 4 * i].split("/");
                String newTime = time[1] + "/" + time[0] + "/" + time[2];
                allPeople.get(Integer.parseInt(args[1 + 4 * i])).setName(args[2 + 4 * i]);
                allPeople.get(Integer.parseInt(args[1 + 4 * i])).setSex(args[3 + 4 * i].toLowerCase().equals("м") ? Sex.MALE : Sex.FEMALE);
                allPeople.get(Integer.parseInt(args[1 + 4 * i])).setBirthDay(new Date(newTime));
            }
        } else if (args[0].equals("-d")) {
            for (int i = 1; i < args.length; i++) {
                int id = Integer.parseInt(args[i]);
                Person person = allPeople.get(id);
                person.setName("");
                person.setSex(null);
                person.setBirthDay(null);
            }
        } else if (args[0].equals("-i")) {
            for (int i = 1; i < args.length; i++) {
                Person person = allPeople.get(Integer.parseInt(args[i]));
                System.out.println(person.getName() + " " + (person.getSex() == Sex.MALE ? "м" : "ж") + " " + new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDay()));
            }
        }
    }
}
