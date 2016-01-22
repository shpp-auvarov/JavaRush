package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Andrey on 08.11.2015.
 */
public class BelarusianHen extends Hen implements Country{

    @Override
    public int getCountOfEggsPerMonth() {
        return 2;
    }
    public String getDescription(){
        return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}