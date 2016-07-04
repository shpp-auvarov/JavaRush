package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
//        List<Word> result = detectAllWords(crossword, "home", "same", "r", "re");
        List<Word> result = detectAllWords(crossword, "home", "same", "emoh", "emas", "fderlk", "klredf", "fulmp", "poeejj", "jjeeop",
                "pmluf", "kovhj", "jhvok", "lprr", "rrpl", "lprr", "voel", "lock", "r", "re", "eo", "oe"/*, null, "", " "*/);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).toString());
        }
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            ArrayList<Word> middleResult = findWord(crossword, words[i]);
            for (int j = 0; j < middleResult.size(); j++) {
                result.add(middleResult.get(j));
            }
        }
        return result;
    }

    public static ArrayList<Word> findWord(int[][] base, String word) {
        ArrayList<Word> result = new ArrayList<>();
        int rowSize = base.length;
        int columnSize = base[0].length;
        char firstLetter = word.charAt(0);
        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++) {
                char one = (char) base[row][column];
                if (one == firstLetter) {
                    if (word.length() == 1) {
                        Word newWord = new Word(word);
                        newWord.setStartPoint(row, column);
                        newWord.setEndPoint(row, column);
                        result.add(newWord);
                    } else {
                        ArrayList<Word> middleResult = checkWord(base, word, row, column);
                        if (middleResult != null) {
                            for (int j = 0; j < middleResult.size(); j++) {
                                result.add(middleResult.get(j));
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public static ArrayList<Word> checkWord(int[][] base, String word, int row, int column) {
        ArrayList<Word> result = new ArrayList<>();
        int shift = word.length() - 1;
        if (isRight(base, word, row, column)) {
            Word resultWord = new Word(word);
            resultWord.setStartPoint(column, row);
            resultWord.setEndPoint(column + shift, row);
            result.add(resultWord);
        }
        if (isRightBottom(base, word, row, column)) {
            Word resultWord = new Word(word);
            resultWord.setStartPoint(column, row);
            resultWord.setEndPoint(column + shift, row + shift);
            result.add(resultWord);
        }
        if (isBottom(base, word, row, column)) {
            Word resultWord = new Word(word);
            resultWord.setStartPoint(column, row);
            resultWord.setEndPoint(column, row + shift);
            result.add(resultWord);
        }
        if (isLeftBottom(base, word, row, column)) {
            Word resultWord = new Word(word);
            resultWord.setStartPoint(column, row);
            resultWord.setEndPoint(column - shift, row + shift);
            result.add(resultWord);
        }
        if (isLeft(base, word, row, column)) {
            Word resultWord = new Word(word);
            resultWord.setStartPoint(column, row);
            resultWord.setEndPoint(column - shift, row);
            result.add(resultWord);
        }
        if (isLeftTop(base, word, row, column)) {
            Word resultWord = new Word(word);
            resultWord.setStartPoint(column, row);
            resultWord.setEndPoint(column - shift, row - shift);
            result.add(resultWord);
        }
        if (isTop(base, word, row, column)) {
            Word resultWord = new Word(word);
            resultWord.setStartPoint(column, row);
            resultWord.setEndPoint(column, row - shift);
            result.add(resultWord);
        }
        if (isRightTop(base, word, row, column)) {
            Word resultWord = new Word(word);
            resultWord.setStartPoint(column, row);
            resultWord.setEndPoint(column + shift, row - shift);
            result.add(resultWord);
        }
        if (result.size() > 0) {
            return result;
        } else {
            return null;
        }
    }

    public static boolean isRight(int[][] base, String word, int row, int column) {
        int sizeLine = base[0].length;
        int lengthWord = word.length();
        int count = 0;
        for (int i = column; i < sizeLine; i++) {
            if (base[row][i] == word.charAt(count)) {
                count++;
                if (count == lengthWord) {
                    return true;
                }
            } else {
                break;
            }
        }
        return count == lengthWord ? true : false;
    }

    public static boolean isRightBottom(int[][] base, String word, int row, int column) {
        int sizeLine = base[0].length;
        int sizeBase = base.length;
        int lengthWord = word.length();
        int count = 0;
        for (int i = column; i < sizeLine; i++) {
            if (row >= sizeBase) {
                break;
            }
            if (base[row][i] == word.charAt(count)) {
                count++;
                if (count == lengthWord) {
                    return true;
                }
            } else {
                break;
            }
            row++;
        }
        return count == lengthWord ? true : false;
    }

    public static boolean isBottom(int[][] base, String word, int row, int column) {
        int sizeBase = base.length;
        int lengthWord = word.length();
        int count = 0;
        for (int i = row; i < sizeBase; i++) {
            if (base[i][column] == word.charAt(count)) {
                count++;
                if (count == lengthWord) {
                    return true;
                }
            } else {
                break;
            }
        }
        return count == lengthWord ? true : false;
    }

    public static boolean isLeftBottom(int[][] base, String word, int row, int column) {
        int sizeBase = base.length;
        int lengthWord = word.length();
        int count = 0;
        for (int i = row; i < sizeBase; i++) {
            if (column < 0) {
                break;
            }
            if (base[i][column] == word.charAt(count)) {
                count++;
                if (count == lengthWord) {
                    return true;
                }
            } else {
                break;
            }
            column--;
        }
        return count == lengthWord ? true : false;
    }

    public static boolean isLeft(int[][] base, String word, int row, int column) {
        int lengthWord = word.length();
        int count = 0;
        for (int i = column; i >= 0; i--) {
            if (base[row][i] == word.charAt(count)) {
                count++;
                if (count == lengthWord) {
                    return true;
                }
            } else {
                break;
            }
        }
        return count == lengthWord ? true : false;
    }

    public static boolean isLeftTop(int[][] base, String word, int row, int column) {
        int lengthWord = word.length();
        int count = 0;
        for (int i = row; i >= 0; i--) {
            if (column < 0) {
                break;
            }
            if (base[i][column] == word.charAt(count)) {
                count++;
                if (count == lengthWord) {
                    return true;
                }
            } else {
                break;
            }
            column--;
        }
        return count == lengthWord ? true : false;
    }

    public static boolean isTop(int[][] base, String word, int row, int column) {
        int lengthWord = word.length();
        int count = 0;
        for (int i = row; i >= 0; i--) {
            if (base[i][column]== word.charAt(count)) {
                count++;
                if (count == lengthWord) {
                    return true;
                }
            } else {
                break;
            }
        }
        return count == lengthWord ? true : false;
    }

    public static boolean isRightTop(int[][] base, String word, int row, int column) {
        int sizeLine = base[0].length;
        int lengthWord = word.length();
        int count = 0;
        for (int i = column; i < sizeLine; i++) {
            if (row < 0) {
                break;
            }
            if (base[row][i] == word.charAt(count)) {
                count++;
                if (count == lengthWord) {
                    return true;
                }
            } else {
                break;
            }
            row--;
        }
        return count == lengthWord ? true : false;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}