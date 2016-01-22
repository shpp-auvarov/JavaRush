package com.javarush.test.level14.lesson02.task01;

/**
 * Created by Andrey on 06.11.2015.
 */
public class some1 {
    public static void main(String[] args) {
        String a = "Мама";
        String b = "Мыла";
        String c = "Раму";
        printResult(a, b ,c);
        printResult(a, c ,b);
        printResult(b, a ,c);
        printResult(b, c ,a);
        printResult(c, a ,b);
        printResult(c, b ,a);

    }
    public static void printResult(String x, String y, String z){
        System.out.println(x + y + z);
    }
    
}
