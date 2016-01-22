package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
    public static void printMatrix(int m, Integer n, String value){
        for (int i = 0; i < 5; i++) {
            System.out.println(value);
            printMatrix(m, n, value);
        }
    }
    public static void printMatrix(Integer m, Integer n, String value){
        for (int i = 0; i < 5; i++) {
            System.out.println(value);
        }
    }
    public static void printMatrix(Integer m, Integer n, Integer value){
        for (int i = 0; i < n; i++) {
            System.out.println(value);
        }
    }
    public static void printMatrix(short m, Integer n, String value){
        for (int i = 0; i < m; i++) {
            System.out.println(n + 1);
        }
    }
    public static void printMatrix(String m, Integer n, String value){
        for (int i = 0; i < 5; i++) {
            System.out.println(m);
        }
    }
    public static void printMatrix(double m, Integer n, String value){
        for (int i = 0; i < 5; i++) {
            System.out.println(m*1.0);
        }
    }
    public static void printMatrix(Integer m, float n, String value){
        for (int i = 0; i < n; i++) {
            System.out.println(m/1.0);
        }
    }
    public static void printMatrix(float m, Integer n, String value){
        for (int i = 0; i < 5; i++) {
            System.out.println(value);
        }
    }

}
