package org.academiadecodigo.berrycollectors.field;

import org.academiadecodigo.berrycollectors.RandomGenerator;

/**
 * Created by milena on 03/02/16.
 */
public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    /**
     * Obtains the opposite direction
     * @return the opposite direction
     */
    public Direction opposite() {
        Direction direction = null;
        switch (this) {
            case UP:
                direction = DOWN;
                break;

            case DOWN:
                direction = UP;
                break;

            case LEFT:
                direction = RIGHT;
                break;

            case RIGHT:
                direction = LEFT;
                break;
        }

        return direction;
    }

    /**
     * Obtains a random direction
     * @return a random direction
     */
    public static Direction choose() {

        int d = RandomGenerator.getRandomByRange(0, values().length-1);

        return values()[d];

    }

}
