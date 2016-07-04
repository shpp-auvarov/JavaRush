package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Andrey on 27.03.2016.
 */
public class Hippodrome {
    private ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public static Hippodrome game;

    public static void main(String[] args) {
        game = new Hippodrome();
        game.getHorses().add(new Horse("Sleven", 3, 0));
        game.getHorses().add(new Horse("Lucky", 3, 0));
        game.getHorses().add(new Horse("Gomer", 3, 0));
        game.run();
        game.printWinner();
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        for (int i = 0; i < getHorses().size(); i++) {
            getHorses().get(i).move();
        }
    }

    public void print() {
        for (int i = 0; i < getHorses().size(); i++) {
            getHorses().get(i).print();
        }
        System.out.println();
        System.out.println();
    }

    public Horse getWinner() {
        int index = 0;
        double max = 0;
        int size = this.getHorses().size();
        for (int i = 0; i < size; i++) {
            double d = this.getHorses().get(i).getDistance();
            if (d > max) {
                max = d;
                index = i;
            }
        }
        return this.getHorses().get(index);
    }

    public void printWinner() {
        System.out.println("Winner is " + this.getWinner().getName() + "!");
    }
}
