package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        String order = "";
        ArrayList<Dish> result = new ArrayList<>();
        ConsoleHelper.writeMessage(Dish.allDishesToString());
        while (!(order = readString()).toLowerCase().contains("exit")) {
            try {
                result.add(Dish.valueOf(order));
            } catch (IllegalArgumentException ex) {
                ConsoleHelper.writeMessage(order + " is not detected");
            }
        }
        return result;
    }
}
