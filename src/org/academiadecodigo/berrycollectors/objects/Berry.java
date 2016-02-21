package org.academiadecodigo.berrycollectors.objects;

import org.academiadecodigo.berrycollectors.field.Representation;

/**
 * Created by milena on 11/02/16.
 */
public class Berry implements Collidable{
    Representation representation;

    private boolean collided;

    public Berry() {
        representation = new Representation(CollidableType.BERRY.getPicsPath(CollidableType.BERRY));
    }

    public Representation getRepresentation() {
        return representation;
    }

    public boolean setCollision(boolean collided) {

        return this.collided = collided;
    }

    public boolean isCrashed() {
        return collided;
    }

    public void collided() {
        setCollision(true);
        representation.getPicture().delete();
    }


}
