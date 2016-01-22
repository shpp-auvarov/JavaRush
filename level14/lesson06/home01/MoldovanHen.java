package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Andrey on 08.11.2015.
 */
public class MoldovanHen extends Hen implements Country{

    @Override
    public int getCountOfEggsPerMonth() {
        return 3;
    }
    public String getDescription(){
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}