package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    public static Map<Operation, Command> operationCommandMap;

    static {
        operationCommandMap = new HashMap<>();
        operationCommandMap.put(Operation.LOGIN, new LoginCommand());
        operationCommandMap.put(Operation.INFO, new InfoCommand());
        operationCommandMap.put(Operation.DEPOSIT, new DepositCommand());
        operationCommandMap.put(Operation.WITHDRAW, new WithdrawCommand());
        operationCommandMap.put(Operation.EXIT, new ExitCommand());
    }
    public static final void execute(Operation operation) throws InterruptOperationException {
        operationCommandMap.get(operation).execute();
    }

    private CommandExecutor() {
    }
}
