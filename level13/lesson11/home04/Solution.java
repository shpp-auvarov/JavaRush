package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        OutputStream outputStream = new FileOutputStream(reader.readLine());
        ArrayList<String> list = new ArrayList<String>();
        while (true){
            String s = reader.readLine();
            String s1 = s + "\r\n";
            list.add(s1);
            if (s.equals("exit")){
                for(String element : list){
                    outputStream.write(element.getBytes());
                }
                break;
            }
        }
        outputStream.close();
       /* while (true) {
            String s = reader.readLine();
            String s1 = s + "\r\n";
            InputStream inputStream = new StringBufferInputStream(s1);

            while (inputStream.available() > 0) {

                int data = inputStream.read();
                outputStream.write(data);
            }
            if (s.equals("exit")) {
                inputStream.close();
                break;
            }
            inputStream.close();

        }

        outputStream.close();*/

    }
}
