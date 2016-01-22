package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        int maxId = 1;
        int count = 0;
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            if (line.length() > 0) {
                int id = Integer.parseInt(line.substring(0, 8).replaceAll(" ", ""));
                if (count == 0) {
                    maxId = id;
                } else {
                    if (id > maxId) {
                        maxId = id;
                    }
                }
                count++;
            }
        }

        bufferedReader.close();
        reader.close();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));

        String idNumber = (maxId + 1) + "";
        while (idNumber.length() < 8) {
            idNumber += " ";
        }

        String productName = "";
        for (int i = 1; i < args.length - 2; i++) {
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
        if (count > 0) {
            some = "\r\n";
        }
        bufferedWriter.write(some + idNumber + productName + price + quantity);
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
