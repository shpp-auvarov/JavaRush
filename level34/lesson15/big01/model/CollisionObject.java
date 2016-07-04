package com.javarush.test.level34.lesson15.big01.model;

public abstract class CollisionObject extends GameObject {
    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction) {
        if (direction == Direction.DOWN) {
            return (gameObject.getX() == getX()) && (gameObject.getY() == getY() + Model.FIELD_SELL_SIZE);
        } else if (direction == Direction.UP) {
            return (gameObject.getX() == getX()) && (gameObject.getY() == getY() - Model.FIELD_SELL_SIZE);
        } else if (direction == Direction.LEFT) {
            return (gameObject.getX() == getX() - Model.FIELD_SELL_SIZE) && (gameObject.getY() == getY());
        } else {
            return (gameObject.getX() == getX() + Model.FIELD_SELL_SIZE) && (gameObject.getY() == getY());
        }
    }
}