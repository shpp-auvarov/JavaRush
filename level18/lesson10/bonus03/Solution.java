package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        ArrayList<String> backUp = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            backUp.add(line);
        }
        bufferedReader.close();
        reader.close();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        for (int j = 0; j < backUp.size(); j++) {
            if (args[0].equals("-u") && (Integer.parseInt(args[1]) == Integer.parseInt(backUp.get(j).substring(0, 8).replaceAll(" ", "")))) {
                String idNumber = args[1];
                while (idNumber.length() < 8) {
                    idNumber += " ";
                }

                String productName = "";
                for (int i = 2; i < args.length - 2; i++) {
                    productName += args[i] + " ";
                }

                while (productName.length() < 30) {
                    productName += " ";
                }
                if (productName.length() > 30) {
                    productName = productName.substring(0, 30);
                }

                String price = args[args.length - 2];
                while (price.length() < 8) {
                    price += " ";
                }
                if (price.length() > 8) {
                    price = price.substring(0, 8);
                }

                String quantity = args[args.length - 1];
                while (quantity.length() < 4) {
                    quantity += " ";
                }
                if (quantity.length() > 4) {
                    quantity = quantity.substring(0, 4);
                }
                String some = "";
                if (j > 0) {
                    some = "\r\n";
                }
                bufferedWriter.write(some + idNumber + productName + price + quantity);
            } else if (args[0].equals("-d") && (Integer.parseInt(args[1]) == Integer.parseInt(backUp.get(j).substring(0, 8).replaceAll(" ", "")))) {

            } else {
                String some = "";
                if (j > 0) {
                    some = "\r\n";
                }
                bufferedWriter.write(some + backUp.get(j));
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
