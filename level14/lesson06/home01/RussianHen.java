package com.javarush.test.level14.lesson06.home01;

/**
 7. В каждом из четырех последних классов написать свою реализацию метода getDescription.
 Методы должны возвращать строку вида:
 <getDescription() родительского класса>  + <" Моя страна - Sssss. Я несу N яиц в месяц.">
 где Sssss - название страны
 где N - количество яиц в месяц
 */
public class RussianHen extends Hen implements Country{

    @Override
    public int getCountOfEggsPerMonth() {
        return 5;
    }
    public String getDescription(){
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}