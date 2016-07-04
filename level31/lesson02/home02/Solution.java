package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {

    public static List<String> getFileTree(String root) throws IOException {
        List<String> result = new ArrayList<>();
        Queue<String> taskList = new LinkedList<>();
        taskList.add(root);
        while (!taskList.isEmpty()) {
            String dir = taskList.poll();
            File[] files = new File(dir).listFiles();
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                if (file.isDirectory()) {
                    taskList.add(file.getAbsolutePath());
                } else {
                    result.add(file.getAbsolutePath());
                }
            }
        }
        return result;
    }
}
