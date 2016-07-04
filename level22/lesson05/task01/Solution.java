package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) {
            throw new TooShortStringException();
        }

        int start = string.indexOf(" ");
        int last = start;
        if (start == -1) {
            throw new TooShortStringException();
        }
        int count = 0;
        for (int i = 0; i < 4; i++) {
            last = string.indexOf(" ", last + 1);
            if (last != -1) {
                count++;
            }
        }

        if (count != 4) {
            throw new TooShortStringException();
        }
        return string.substring(start + 1, last);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("JavaRush - лучший сервис"));
    }
}
