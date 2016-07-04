package com.javarush.test.level34.lesson15.big01.model;

import com.javarush.test.level34.lesson15.big01.controller.EventListener;

import java.nio.file.Paths;

public class Model {
    public static final int FIELD_SELL_SIZE = 20;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("D:\\Java\\JavaRush2\\JavaRushHomeWork\\src\\com\\javarush\\test\\level34\\lesson15\\big01\\res\\levels.txt"));

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level) {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        currentLevel++;
        restartLevel(currentLevel);
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        for (Wall wall : gameObjects.getWalls()) {
            if (gameObject.isCollision(wall, direction)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBoxCollision(Direction direction) {
        Player player = gameObjects.getPlayer();
        GameObject stopped = null;
        for (GameObject gameObject : gameObjects.getAll()) {
            if (!(gameObject instanceof Player) && !(gameObject instanceof Home) && player.isCollision(gameObject, direction)) {
                stopped = gameObject;
                break;
            }
        }

        if ((stopped == null)) {
            return false;
        }
        if (stopped instanceof Box) {
            Box stoppedBox = (Box) stopped;
            if (checkWallCollision(stoppedBox, direction)) {
                return true;
            }
            for (Box box : gameObjects.getBoxes()) {
                if (stoppedBox.isCollision(box, direction)) {
                    return true;
                }
            }
            switch (direction) {
                case LEFT:
                    stoppedBox.move(-FIELD_SELL_SIZE, 0);
                    break;
                case RIGHT:
                    stoppedBox.move(FIELD_SELL_SIZE, 0);
                    break;
                case UP:
                    stoppedBox.move(0, -FIELD_SELL_SIZE);
                    break;
                case DOWN:
                    stoppedBox.move(0, FIELD_SELL_SIZE);
            }
        }
        return false;
    }

    public void checkCompletion() {
        for (Home home : gameObjects.getHomes()) {
            boolean find = false;
            for (Box box : gameObjects.getBoxes()) {
                if (home.getX() == box.getX() && home.getY() == box.getY()) {
                    find = true;
                    break;
                }
            }
            if (!find) {
                return;
            }
        }
        eventListener.levelCompleted(currentLevel);
    }

    public void move(Direction direction) {
        Player player = gameObjects.getPlayer();
        if (checkWallCollision(player, direction)) {
            return;
        }
        if (checkBoxCollision(direction)) {
            return;
        }
        switch (direction) {
            case LEFT:
                player.move(-FIELD_SELL_SIZE, 0);
                break;
            case RIGHT:
                player.move(FIELD_SELL_SIZE, 0);
                break;
            case UP:
                player.move(0, -FIELD_SELL_SIZE);
                break;
            case DOWN:
                player.move(0, FIELD_SELL_SIZE);
        }
        checkCompletion();
    }
}
