package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

import static com.javarush.test.level26.lesson15.big01.CashMachine.RESOURCE_PATH;
import static com.javarush.test.level26.lesson15.big01.ConsoleHelper.askCurrencyCode;
import static com.javarush.test.level26.lesson15.big01.ConsoleHelper.getValidTwoDigits;

class DepositCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "deposit_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currency = askCurrencyCode();
        String[] date = getValidTwoDigits(currency);
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currency);
        currencyManipulator.addAmount(Integer.parseInt(date[0]), Integer.parseInt(date[1]));
    }
}
