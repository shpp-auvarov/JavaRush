package com.javarush.test.level32.lesson06.task01;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "1234567890";
        String letter1 = alphabet.charAt((int) (Math.random() * alphabet.length())) + "";
        String letter2 = numbers.charAt((int) (Math.random() * numbers.length())) + "";
        String letter3 = (alphabet.charAt((int) (Math.random() * alphabet.length())) + "").toUpperCase();
        String letter4 = alphabet.charAt((int) (Math.random() * alphabet.length())) + "";
        String letter5 = numbers.charAt((int) (Math.random() * numbers.length())) + "";
        String letter6 = (alphabet.charAt((int) (Math.random() * alphabet.length())) + "").toUpperCase();
        String letter7 = alphabet.charAt((int) (Math.random() * alphabet.length())) + "";
        String letter8 = alphabet.charAt((int) (Math.random() * alphabet.length())) + "";
        String result = letter1 + letter2 + letter3 + letter4 + letter5 + letter6 + letter7 + letter8;

        InputStream inputStream = new ByteArrayInputStream(result.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        try {
            while (bis.available() > 0) {
                int data = bis.read();
                outputStream.write(data);
            }
        } catch (Exception e) {
        }
        return outputStream;
    }
}
