package com.javarush.test.level22.lesson13.task02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        args = new String[2];
        args[0] = "C:\\Users\\Andrey\\Desktop\\test5.txt";
        args[1] = "C:\\Users\\Andrey\\Desktop\\test5_utf.txt";
        String fileInputFile = args[0];
        String fileOutputFile = args[1];
        FileInputStream inputStream = new FileInputStream(fileInputFile);
        FileOutputStream outputStream = new FileOutputStream(fileOutputFile);

        Charset windows1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");

        byte[] buffer = new byte[1000000];
        inputStream.read(buffer);
        String s = new String(buffer, utf8);
        buffer = s.getBytes(windows1251);
        outputStream.write(buffer);
        inputStream.close();
        outputStream.flush();
        outputStream.close();
    }
}
