package org.academiadecodigo.berrycollectors.field;

import org.academiadecodigo.berrycollectors.RandomGenerator;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Representation {

    public static final int SIZE_WIDTH = 50;
    public static final int SIZE_HEIGHT = 63;

    private Picture picture;
    private String[] picPaths;

    public Representation(String[] picPaths) {

        this.picPaths = picPaths;

        picture = new Picture(getRandomX(), getRandomY(), picPaths[0]);
        picture.draw();
    }

    public Picture getPicture() {
        return picture;
    }

    public String[] getPicsPath() {
        return picPaths;
    }

    public void setPicXY(int x, int y) {
        int xIncrement = x-getPicture().getX();
        int yIncrement = y-getPicture().getY();

        getPicture().translate(xIncrement, yIncrement);
    }

    public void moveUp(int increment) {

        if (picture.getY() - increment <= Field.MARGIN) {
            picture.translate(0, - (picture.getY() - Field.MARGIN));
        } else {
            picture.translate(0, -increment);
        }
    }

    public void moveDown(int increment) {

        if (picture.getY() + increment > Field.MARGIN + Field.getHeight() - picture.getHeight()) {
            picture.translate(0, Field.getHeight() + Field.MARGIN - picture.getHeight() - picture.getY());
        } else {
            picture.translate(0, increment);
        }
    }

    public void moveLeft(int increment) {

        if (picture.getX() - increment <= Field.MARGIN) {
            picture.translate( - (picture.getX()- Field.MARGIN), 0);
        } else {
            picture.translate(-increment, 0);
        }
    }

    public void moveRight(int increment) {

        if (picture.getX() + increment >= Field.MARGIN + Field.getWidth() - picture.getWidth()) {
            picture.translate(Field.getWidth()+ Field.MARGIN - picture.getWidth() - picture.getX(), 0);
        } else {
            picture.translate(increment, 0);
        }
    }

    public void moveInDirection(Direction direction, int number) {
        switch (direction) {
            case UP:
                moveUp(number);
                break;

            case DOWN:
                moveDown(number);
                break;

            case LEFT:
                moveLeft(number);
                break;

            case RIGHT:
                moveRight(number);
                break;
        }
    }

    public boolean checkPos(Direction direction) {

        return (picture.getX() == Field.MARGIN && direction == Direction.LEFT) ||
                (picture.getX() == Field.MARGIN + Field.getWidth() - picture.getWidth() && direction == Direction.RIGHT) ||
                (picture.getY() == Field.MARGIN && direction == Direction.UP) ||
                (picture.getY() == Field.MARGIN + Field.getHeight() - picture.getHeight() && direction == Direction.DOWN);
    }

    public static int getRandomX() {
        return RandomGenerator.getRandomByRange(Field.MARGIN + SIZE_WIDTH, (Field.getWidth() + Field.MARGIN - SIZE_WIDTH - SIZE_WIDTH));
    }

    public static int getRandomY() {
        return RandomGenerator.getRandomByRange(Field.MARGIN + SIZE_HEIGHT, (Field.getHeight() + Field.MARGIN - SIZE_HEIGHT - SIZE_HEIGHT));
    }


}
