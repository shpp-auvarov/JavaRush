package com.javarush.test.level31.lesson06.home01;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        if (args == null || args.length != 2) {
            return;
        }
        String absPathFile = args[0];
        String absPathZipArchive = args[1];
        Map<ZipEntry, byte[]> base = new HashMap<>();
        String inputFileName = new File(absPathFile).getName();
        File source = new File(absPathZipArchive);
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(source))) {
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count;
                while ((count = zipInputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, count);
                }
                byte[] bytes = byteArrayOutputStream.toByteArray();
                base.put(zipEntry, bytes);
            }
        } catch (Exception ignore) {
        }
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(source));
        for (Map.Entry<ZipEntry, byte[]> element : base.entrySet()) {
            if (inputFileName.equals(element.getKey().getName())) {
                out.putNextEntry(new ZipEntry(element.getKey().getName()));
                FileInputStream in = new FileInputStream(new File(absPathFile));
                int len;
                byte[] buf = new byte[1024];
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                in.close();
                out.closeEntry();
                continue;
            }
            if (element.getValue() != null) {
                out.putNextEntry(element.getKey());
                out.write(element.getValue());
                out.closeEntry();
            }
        }
        out.close();
    }
}
