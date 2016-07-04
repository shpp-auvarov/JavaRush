package com.javarush.test.level27.lesson15.big01.statistic.event;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.util.Date;
import java.util.List;

import static com.javarush.test.level27.lesson15.big01.statistic.event.EventType.COOKED_ORDER;

public class CookedOrderEventDataRow implements EventDataRow {
    private String tabletName; //- имя планшета, используйте tablet.toString()
    private String cookName; // - имя повара
    private int cookingTimeSeconds; // - время приготовления заказа в секундах
    private List<Dish> cookingDishs; // - список блюд для приготовления
    private Date currentDate;

    public CookedOrderEventDataRow(String tabletName, String cookName, int cookingTimeSeconds, List<Dish> cookingDishs) {
        this.tabletName = tabletName;
        this.cookName = cookName;
        this.cookingTimeSeconds = cookingTimeSeconds;
        this.cookingDishs = cookingDishs;
        currentDate = new Date();
    }

    @Override
    public EventType getType() {
        return COOKED_ORDER;
    }

    @Override
    public Date getDate() {
        return currentDate;
    }

    @Override
    public int getTime() {
        return cookingTimeSeconds;
    }

    public String getCookName() {
        return cookName;
    }
}
