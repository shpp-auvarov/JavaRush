package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BotClient extends Client {
    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String userName = "";
            String text;

            if (message.contains(": ")) {
                userName = message.substring(0, message.indexOf(": "));
                text = message.substring(message.indexOf(": ") + 2);
            } else {
                text = message;
            }
            String result = "";
            if ("дата".equalsIgnoreCase(text)) {
                result = "d.MM.YYYY";
            } else if ("день".equalsIgnoreCase(text)) {
                result = "d";
            } else if ("месяц".equalsIgnoreCase(text)) {
                result = "MMMM";
            } else if ("год".equalsIgnoreCase(text)) {
                result = "YYYY";
            } else if ("время".equalsIgnoreCase(text)) {
                result = "H:mm:ss";
            } else if ("час".equalsIgnoreCase(text)) {
                result = "H";
            } else if ("минуты".equalsIgnoreCase(text)) {
                result = "m";
            } else if ("секунды".equalsIgnoreCase(text)) {
                result = "s";
            }
            if (!result.equals("")) {
                sendTextMessage(String.format("Информация для %s: %s", userName, new SimpleDateFormat(result).format(Calendar.getInstance().getTime())));
            }
        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return new Date() + "_bot_" + (int) (Math.random() * 100);
    }

    public static void main(String[] args) {
        new BotClient().run();
    }
}