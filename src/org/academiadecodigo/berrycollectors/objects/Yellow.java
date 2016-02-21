package org.academiadecodigo.berrycollectors.objects;

import org.academiadecodigo.berrycollectors.field.Representation;

/**
 * Created by milena on 03/02/16.
 */
public class Yellow extends Monster {

    public Yellow() {
        super(new Representation(CollidableType.YELLOW.getPicsPath(CollidableType.YELLOW)), CollidableType.YELLOW);
        setSpeed(CollidableType.YELLOW.getSpeed());
    }


}
