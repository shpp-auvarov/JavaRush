package com.javarush.test.level31.lesson02.home01;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {
    private static List<File> paths = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String directory = args[0];
        String inputFile = args[1];
//        String directory = "C:/Users/Andrey/Desktop/test/";
//        String inputFile = "C:/Users/Andrey/Desktop/result.txt";
        File resultFile = new File(inputFile);

        checkAndFillPaths(directory);

        paths.remove(new File(inputFile));

        String newName = new File(inputFile).getParent() + File.separator + "allFilesContent.txt";
        File totalFile = new File(newName);
        resultFile.renameTo(totalFile);

        Collections.sort(paths, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                String first = o1.getName();
                String second = o2.getName();
                return first.compareTo(second);
            }
        });

        FileWriter fileWriter = new FileWriter(totalFile);

        for (int i = 0; i < paths.size(); i++) {
            BufferedReader br = new BufferedReader(new FileReader(paths.get(i)));
            String line = "";
            while ((line = br.readLine()) != null) {
                fileWriter.write(line);
                fileWriter.write("\n");
            }
            br.close();
        }
        fileWriter.close();

    }

    private static void checkAndFillPaths(String directory) {
        File dir = new File(directory);
        File[] files = dir.listFiles();
        if (files.length == 0) {
            return;
        } else if (files.length == 0) {
            dir.delete();
        } else {
            for (File file : files) {
                if (file.isDirectory()) {
                    checkAndFillPaths(file.getAbsolutePath());
                } else {
                    if (file.length() > 50) {
                        file.delete();
                    } else {
                        paths.add(file);
                    }
                }
            }
        }
    }
}
