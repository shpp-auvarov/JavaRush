package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            String filePath = "C:/Users/Andrey/Desktop/test1.txt";
            OutputStream outputStream = new FileOutputStream(filePath);


            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);

            User user1 = new User();
            user1.setLastName("Иванов");
            user1.setFirstName("Иван");
            user1.setBirthDate(sdf.parse("11 03 1985"));
            user1.setMale(true);
            user1.setCountry(User.Country.UKRAINE);

            User user2 = new User();
            user2.setLastName("Петров");
            user2.setFirstName("Петр");
            user2.setBirthDate(sdf.parse("01 12 1980"));
            user2.setMale(false);
            user2.setCountry(User.Country.RUSSIA);

            User user3 = new User();
            user3.setLastName("Сидоров");
            user3.setMale(true);
            user3.setCountry(User.Country.OTHER);

            javaRush.users.add(user1);
            javaRush.users.add(user2);
            javaRush.users.add(user3);

            javaRush.save(outputStream);
            outputStream.flush();
            outputStream.close();

            InputStream inputStream = new FileInputStream(filePath);
            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            inputStream.close();
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            System.out.println(javaRush.users.size() + " <> " + loadedObject.users.size());
            for (User user : javaRush.users) {
                System.out.println(user.getLastName() + " " + user.getFirstName() + " " + user.getBirthDate() + " " +  user.isMale() + " " + user.getCountry());
            }
            System.out.println("============");
            for (User user : loadedObject.users) {
                System.out.println(user.getLastName() + " " + user.getFirstName() + " " + user.getBirthDate() + " " +  user.isMale() + " " + user.getCountry());
            }

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            for (User element : users) {
                if (element.getFirstName() != null) {
                    printWriter.print(element.getFirstName() + ",");
                } else {
                    printWriter.print(",");
                }
                if (element.getLastName() != null) {
                    printWriter.print(element.getLastName() + ",");
                } else {
                    printWriter.print(",");
                }
                if (element.getBirthDate() != null) {
                    printWriter.print(format.format(element.getBirthDate()) + ",");
                } else {
                    printWriter.print(",");
                }
                printWriter.print(element.isMale() + ",");
                if (element.getCountry() != null) {
                    printWriter.print(element.getCountry().getDisplayedName());
                }
                printWriter.println("");
                printWriter.flush();
            }
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            String line = "";
            while ((line = reader.readLine()) != null) {
                User user = new User();
                String[] base = line.split(",");
                for (int i = 0; i < base.length; i++) {
                    System.out.print(base[i] + " ");
                }
                System.out.println();
                if (base[0] != "") {
                    user.setFirstName(base[0]);
                }
                if (base[1] != "") {
                    user.setLastName(base[1]);
                }
                if (base[2] != "") {
                    user.setBirthDate(format.parse(base[2]));
                }
                user.setMale(new Boolean(base[3]));
                if (base[4].equals("Ukraine")) {
                    user.setCountry(User.Country.UKRAINE);
                } else if (base[4].equals("Russia")) {
                    user.setCountry(User.Country.RUSSIA);
                } else {
                    user.setCountry(User.Country.OTHER);
                }
                users.add(user);
            }
        }
    }
}
