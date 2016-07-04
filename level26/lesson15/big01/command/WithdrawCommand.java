package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.ConcurrentModificationException;
import java.util.Map;
import java.util.ResourceBundle;

import static com.javarush.test.level26.lesson15.big01.CashMachine.RESOURCE_PATH;

class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currency = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currency);
        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            String s = ConsoleHelper.readString();
            int countInt;
            try {
                countInt = Integer.parseInt(s);
                if (countInt > 0) {
                    if (currencyManipulator.isAmountAvailable(countInt)) {
                        Map<Integer, Integer> result = currencyManipulator.withdrawAmount(countInt);
                        for (Map.Entry<Integer, Integer> element : result.entrySet()) {
                            ConsoleHelper.writeMessage("\t" + element.getKey() + " - " + element.getValue());
                        }
                        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), countInt, currency));
                        return;
                    } else {
                        ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                    }
                } else {
                    ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                }
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
            } catch (ConcurrentModificationException ignore) {
            }
        }
    }
}