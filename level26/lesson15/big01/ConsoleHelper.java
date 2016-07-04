package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

import static com.javarush.test.level26.lesson15.big01.CashMachine.RESOURCE_PATH;

public class ConsoleHelper {
    private static ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "common_en");

    public static final BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        while (true) {
            String result = "";
            try {
                result = bufferReader.readLine();
            } catch (IOException e) {

            }
            if (result.toLowerCase().contains(res.getString("operation.EXIT").toLowerCase())) {
                throw new InterruptOperationException();
            }
            if (result != "") {
                return result;
            }
        }
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        String currency = "";
        while (true) {
            writeMessage(res.getString("choose.currency.code"));
            currency = readString();
            if (currency.length() == 3) {
                return currency.toUpperCase();
            } else {
                writeMessage(res.getString("invalid.data"));
            }
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        String denomination;
        String count;
        while (true) {
            writeMessage(String.format(res.getString("choose.denomination.and.count.format"),currencyCode));
            String inputDate = readString();
            String[] array = inputDate.split(" ");
            denomination = array[0];
            count = array[1];
            int a = Integer.parseInt(denomination);
            int b = Integer.parseInt(count);
            if (a < 0 || b < 0 || array.length != 2) {
                writeMessage(res.getString("invalid.data"));
            } else {
                return new String[]{denomination, count};
            }
        }
    }

    public static Operation askOperation() throws InterruptOperationException {
        while (true) {
            writeMessage(res.getString("choose.operation"));
            writeMessage("1 - " + res.getString("operation.INFO") + "; 2 - " + res.getString("operation.DEPOSIT") + "; 3 - " + res.getString("operation.WITHDRAW") + "; 4 - " + res.getString("operation.EXIT"));
            return Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
        }
    }

    public static void printExitMessage() {
        writeMessage(res.getString("the.end"));
    }
}
