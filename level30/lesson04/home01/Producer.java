package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int N = 1; N < 10; N++) {
            ShareItem item = new ShareItem("ShareItem-" + N, N);
            System.out.format("Элемент '%s' добавлен", item.description);
            System.out.println();
            queue.offer(item);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignore) {
                break;
            }
            if (queue.hasWaitingConsumer()) {
                System.out.println("Consumer в ожидании!");
            }
        }
    }
}