package org.academiadecodigo.berrycollectors.objects;

import org.academiadecodigo.berrycollectors.Sound;
import org.academiadecodigo.berrycollectors.field.Representation;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

/**
 * Created by milena on 10/02/16.
 */
public class ControlledMonster extends Monster {

    private Text text;
    private int counter;

    public ControlledMonster(Representation representation, CollidableType collidableType) {
        super(representation, collidableType);
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public void move() {

        if(isCrashed()) {
            return;
        }

        if (representation.checkPos(getDirection())) {
            setDirection(getDirection().opposite());
        }

        for(int i = 0; i < getSpeed(); i++) {

            representation.moveInDirection(getDirection(), 1);

            Collidable c = getDetector().getCollided(this);
            if (c != null) {
                c.collided();

                if (c instanceof Monster) {
                    collided();
                } else {
                    Sound.play("/sources/collect.wav");
                    counter++;
                    text.setText(this.getClass().getSimpleName() + " COLLECTED " + counter + " BERRIES");
                }
            }
        }

    }
}
