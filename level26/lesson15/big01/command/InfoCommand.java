package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.Map;
import java.util.ResourceBundle;

import static com.javarush.test.level26.lesson15.big01.CashMachine.RESOURCE_PATH;

class InfoCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "info_en");

    @Override
    public void execute() {
        ConsoleHelper.writeMessage(res.getString("before"));
        if (CurrencyManipulatorFactory.hasMoney()) {
            for (Map.Entry<String, CurrencyManipulator> element : CurrencyManipulatorFactory.MANIPULATORS.entrySet()) {
                System.out.println(element.getKey() + " - " + element.getValue().getTotalAmount());
            }
        } else {
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }
    }
}