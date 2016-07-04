package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;

import static com.javarush.test.level26.lesson15.big01.command.CommandExecutor.execute;

public class CashMachine {
    public static final String RESOURCE_PATH = "com.javarush.test.level26.lesson15.big01.resources.";
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        try {
            execute(Operation.LOGIN);
            Operation command = ConsoleHelper.askOperation();
            do {
                execute(command);
            } while ((command = ConsoleHelper.askOperation()) != Operation.EXIT);
        } catch (InterruptOperationException e) {
            ConsoleHelper.printExitMessage();
        }
    }
}
