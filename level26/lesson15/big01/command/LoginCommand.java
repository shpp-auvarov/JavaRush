package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

import static com.javarush.test.level26.lesson15.big01.CashMachine.RESOURCE_PATH;

public class LoginCommand implements Command {
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "login_en");
    ;

    @Override
    public void execute() throws InterruptOperationException {
        while (true) {
            ConsoleHelper.writeMessage(res.getString("before"));
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String number = ConsoleHelper.readString().replace(" ", "");
            if (!number.matches("^[0-9]{12}$") || !validCreditCards.containsKey(number)) {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }
            String pin = ConsoleHelper.readString().replace(" ", "");
            if (!pin.matches("^[0-9]{4}$")) {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }
            if (pin.equals(validCreditCards.getObject(number))) {
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), number));
                return;
            } else {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), number));
            }
        }
    }
}