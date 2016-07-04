package com.javarush.test.level20.lesson10.bonus02;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 0},
                {1, 0, 0, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int result = 0;
        int sizeRow = a.length;
        int sizeColumn = a[0].length;
        for (int row = 0; row < sizeRow; row++) {
            for (int column = 0; column < sizeColumn; column++) {
                if (a[row][column] == 1) {
                    a = clearArray(a, row, column);
                    result++;
                }
            }
        }
        return result;
    }

    private static byte[][] clearArray(byte[][] a, int row, int column) {
        int sizeRow = findQuantityRow(a, row, column);
        int sizeColumn = findQuantityColumn(a[row], column);
        for (int k = row; k < row + sizeRow; k++) {
            for (int m = column; m < column + sizeColumn; m++) {
                a[k][m] = 0;
            }
        }
        return a;
    }

    private static int findQuantityColumn(byte[] bytes, int column) {
        int result = 0;
        int size = bytes.length;
        for (int i = column; i < size; i++) {
            if (bytes[i] == 0) {
                break;
            } else {
                result++;
            }
        }
        return result;
    }

    private static int findQuantityRow(byte[][] a, int row, int column) {
        int result = 0;
        int size = a.length;
        for (int j = row; j < size; j++) {
            if (a[j][column] == 0) {
                break;
            } else {
                result++;
            }
        }
        return result;
    }
}