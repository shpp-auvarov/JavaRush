package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {
    public static void main(String[] args) {
        try {
            Solution solution = new Solution("C:/Users/Andrey/Desktop/test1.txt");
            solution.writeObject("Hi");
            solution.close();

            //SAVE
            FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/Andrey/Desktop/test1.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(solution);
            outputStream.flush();
            outputStream.close();
            //LOAD
            FileInputStream fileInputStream = new FileInputStream("C:/Users/Andrey/Desktop/test1.txt");
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            Solution t2 = (Solution) inputStream.readObject();
            inputStream.close();
            t2.writeObject("Hi2");
        } catch (Exception e) {

        }
    }

    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(fileName);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        fileName = (String)in.readObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
