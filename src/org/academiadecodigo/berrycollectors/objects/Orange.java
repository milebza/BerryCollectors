package org.academiadecodigo.berrycollectors.objects;

import org.academiadecodigo.berrycollectors.field.Direction;
import org.academiadecodigo.berrycollectors.field.Field;
import org.academiadecodigo.berrycollectors.field.Representation;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by milena on 12/02/16.
 */
public class Orange extends ControlledMonster implements KeyboardHandler {

    public Orange() {

        super(new Representation(CollidableType.ORANGE.getPicsPath(CollidableType.ORANGE)), CollidableType.ORANGE);
        setSpeed(CollidableType.ORANGE.getSpeed());
        getRepresentation().setPicXY(Field.getWidth()+Field.MARGIN-getRepresentation().getPicture().getWidth(), Field.getHeight()+Field.MARGIN-getRepresentation().getPicture().getHeight());

        Text yourText = new Text(Field.MARGIN + Field.getWidth()/4, Field.getHeight() + Field.MARGIN, "Orange COLLECTED " + getCounter() + " BERRIES");
        setText(yourText);
        getText().setColor(Color.BLACK);
        getText().draw();
        control();
    }

    private void control() {
        Keyboard k = new Keyboard(this);

        KeyboardEvent keyUp = new KeyboardEvent();
        keyUp.setKey(KeyboardEvent.KEY_UP);
        keyUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(keyUp);

        KeyboardEvent keyDown = new KeyboardEvent();
        keyDown.setKey(KeyboardEvent.KEY_DOWN);
        keyDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(keyDown);

        KeyboardEvent keyLeft = new KeyboardEvent();
        keyLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(keyLeft);

        KeyboardEvent keyRight = new KeyboardEvent();
        keyRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(keyRight);

    }

    @Override
    public void keyPressed(KeyboardEvent e) {

        switch (e.getKey()) {
            case KeyboardEvent.KEY_UP:
                setDirection(Direction.UP);
                break;
            case KeyboardEvent.KEY_DOWN:
                setDirection(Direction.DOWN);
                break;
            case KeyboardEvent.KEY_LEFT:
                setDirection(Direction.LEFT);
                break;
            case KeyboardEvent.KEY_RIGHT:
                setDirection(Direction.RIGHT);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {
    }
}
