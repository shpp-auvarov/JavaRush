package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message receive = connection.receive();
                if (receive.getType() == MessageType.USER_NAME) {
                    String userName = receive.getData();
                    if (userName != null && !userName.isEmpty() && !connectionMap.containsKey(userName)) {
                        connectionMap.put(userName, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        return userName;
                    }
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                if (!entry.getKey().equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    Message answer = new Message(MessageType.TEXT, userName + ": " + message.getData());
                    sendBroadcastMessage(answer);
                } else {
                    ConsoleHelper.writeMessage("Ошибка при получени текстового сообщение.");
                }
            }
        }

        public void run() {
            String userName = "";
            try (Connection connection = new Connection(socket)) {
                ConsoleHelper.writeMessage("Установленно новое соединение с удаленным сервером " + connection.getRemoteSocketAddress());
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным сервером");
            }
            connectionMap.remove(userName);
            sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто");
        }
    }

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Введите порт: ");
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            ConsoleHelper.writeMessage("Сервер запущен.");
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка при создании сервера.");
        }
        while (true) {
            try {
                new Handler(serverSocket.accept()).start();
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Ошибка при создании подключения.");
                if (serverSocket != null) {
                    try {
                        serverSocket.close();
                    } catch (IOException ignore) {
                    }
                }
                break;
            }
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> element : connectionMap.entrySet()) {
            try {
                element.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при отправке сообщения пользователю " + element.getKey());
            }
        }
    }
}