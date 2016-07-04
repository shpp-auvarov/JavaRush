package com.javarush.test.level30.lesson06.home01;

import java.util.concurrent.RecursiveTask;

public class BinaryRepresentationTask extends RecursiveTask<String> {
    final int n;

    public BinaryRepresentationTask(int i) {
        this.n = i;
    }

    @Override
    protected String compute() {
        int a = n % 2;
        int b = n / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            BinaryRepresentationTask binaryRepresentationTask = new BinaryRepresentationTask(b);
            binaryRepresentationTask.fork();
            return binaryRepresentationTask.join() + result;
        }
        return result;
    }
}
