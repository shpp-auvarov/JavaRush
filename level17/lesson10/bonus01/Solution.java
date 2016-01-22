package com.javarush.test.level17.lesson10.bonus01;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException {
        if (args[0].equals("-c")) {
            String[] time = args[args.length - 1].split("/");
            String newTime = time[1] + "/" + time[0] + "/" + time[2];
            if (args[2].toLowerCase().equals("м")) {
                allPeople.add(Person.createMale(args[1], new Date(newTime)));
            } else {
                allPeople.add(Person.createFemale(args[1], new Date(newTime)));
            }
            System.out.println(allPeople.size() - 1);
        } else if (args[0].equals("-u")) {
            String[] time = args[args.length - 1].split("/");
            String newTime = time[1] + "/" + time[0] + "/" + time[2];
            allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
            allPeople.get(Integer.parseInt(args[1])).setSex(args[3].toLowerCase().equals("м") ? Sex.MALE : Sex.FEMALE);
            allPeople.get(Integer.parseInt(args[1])).setBirthDay(new Date(newTime));
        } else if (args[0].equals("-d")) {
            int id = Integer.parseInt(args[1]);
            Person person = allPeople.get(id);
            person.setName("");
            person.setSex(null);
            person.setBirthDay(null);
        } else if (args[0].equals("-i")) {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            System.out.println(person.getName() + " " + (person.getSex() == Sex.MALE ? "м" : "ж") + " " + new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDay()));
        }
    }
}
