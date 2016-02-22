package org.academiadecodigo.berrycollectors;

import org.academiadecodigo.berrycollectors.objects.*;
import org.academiadecodigo.berrycollectors.field.Field;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class Game implements KeyboardHandler {

    public static final int MANUFACTURED_MONSTERS = 12;
    public static final int BERRIES = 20;

    private Collidable[] collidables;
    private Monster[] monsters;
    private ControlledMonster green;
    private ControlledMonster orange;

    private int delay;
    private boolean start;

    public Game(int width, int height, int delay) {

        Field.init(width, height);
        this.delay = delay;

    }

    private void createCollidablesArray() {

        monsters = new Monster[MANUFACTURED_MONSTERS];
        collidables = new Collidable[MANUFACTURED_MONSTERS + BERRIES];
        Monster monster;

        for (int i = 0; i < BERRIES; i++) {
            collidables[i] = new Berry();
        }

        for (int i = BERRIES; i < collidables.length; i++) {
            monster = new Yellow();
            collidables[i] = monster;
            monsters[i-BERRIES] = monster;
            monsters[i-BERRIES].createCollisionDetector(monsters);
        }
    }

    public void init() {

        createCollidablesArray();

        green = new Green();
        green.createCollisionDetector(collidables);

        orange = new Orange();
        orange.createCollisionDetector(collidables);

    }

    public void start() throws InterruptedException {

        boolean stop = true;
        playersStart();
        Sound.play("/sources/sound.wav");

        for (Monster c : monsters) {
            c.getDetector().arrangeCollidables(c);
        }

        while (stop) {

            Thread.sleep(delay);

            if (start) {
                green.move();
                orange.move();

                for (Monster c : monsters) {
                    c.move();
                }
            }

            if (green.isCrashed() || orange.isCrashed() || green.getCounter()+orange.getCounter() == BERRIES) {
                stop = false;
            }

        }

        Field.placard(green, orange);

        Thread.sleep(2000);
        System.exit(0);

    }

    private void playersStart() {
        Keyboard k = new Keyboard(this);
        KeyboardEvent keySpace = new KeyboardEvent();
        keySpace.setKey(KeyboardEvent.KEY_SPACE);
        keySpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(keySpace);
    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        start = true;
    }

    @Override
    public void keyReleased(KeyboardEvent e) {
    }

}
