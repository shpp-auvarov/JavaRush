package com.javarush.test.level31.lesson06.bonus01;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipInputStream;

/* Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002
*/
public class Solution {
    public static void main(String[] args) {
        String resultPathFile = args[0];
        List<String> base = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            base.add(args[i]);
        }
        Collections.sort(base);
        ByteArrayOutputStream source = new ByteArrayOutputStream();
        for (String element : base) {
            try {
                Files.copy(new File(element).toPath(), source);
            } catch (IOException ignore) {
            }
        }
        try (FileOutputStream fileOutputStream = new FileOutputStream(resultPathFile)) {
            try (ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(source.toByteArray()))) {
                while (zis.getNextEntry() != null) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int count;
                    while ((count = zis.read(buffer)) != -1) {
                        byteArrayOutputStream.write(buffer, 0, count);
                    }
                    byte[] bytes = byteArrayOutputStream.toByteArray();
                    fileOutputStream.write(bytes);
                }
            } catch (Exception ignore) {
            }
        } catch (IOException ignore) {
        }
    }
}