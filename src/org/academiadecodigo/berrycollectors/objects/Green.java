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
public class Green extends ControlledMonster implements KeyboardHandler {

    public Green() {
        super(new Representation(CollidableType.GREEN.getPicsPath(CollidableType.GREEN)), CollidableType.GREEN);
        setSpeed(CollidableType.GREEN.getSpeed());
        getRepresentation().setPicXY(Field.MARGIN, Field.MARGIN);

        Text yourText = new Text(Field.MARGIN, Field.getHeight()+ Field.MARGIN, "Green COLLECTED " + getCounter() + " BERRIES");
        setText(yourText);
        getText().setColor(Color.BLACK);
        getText().draw();
        control();
    }



    private void control() {
        Keyboard k = new Keyboard(this);

        KeyboardEvent keyW = new KeyboardEvent();
        keyW.setKey(KeyboardEvent.KEY_W);
        keyW.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(keyW);

        KeyboardEvent keyS = new KeyboardEvent();
        keyS.setKey(KeyboardEvent.KEY_S);
        keyS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(keyS);

        KeyboardEvent keyA = new KeyboardEvent();
        keyA.setKey(KeyboardEvent.KEY_A);
        keyA.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(keyA);

        KeyboardEvent keyD = new KeyboardEvent();
        keyD.setKey(KeyboardEvent.KEY_D);
        keyD.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(keyD);

    }

    @Override
    public void keyPressed(KeyboardEvent e) {

        switch (e.getKey()) {
            case KeyboardEvent.KEY_W:
                setDirection(Direction.UP);
                break;
            case KeyboardEvent.KEY_S:
                setDirection(Direction.DOWN);
                break;
            case KeyboardEvent.KEY_A:
                setDirection(Direction.LEFT);
                break;
            case KeyboardEvent.KEY_D:
                setDirection(Direction.RIGHT);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {
    }
}
