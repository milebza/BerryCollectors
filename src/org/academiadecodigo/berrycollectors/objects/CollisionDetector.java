package org.academiadecodigo.berrycollectors.objects;

import org.academiadecodigo.berrycollectors.field.Representation;

/**
 * Created by milena on 08/02/16.
 */
public class CollisionDetector {

    private static final int REDUCE = 7;

    Collidable[] collidables;

    public CollisionDetector(Collidable[] collidables) {
        this.collidables = collidables;
    }

    private boolean containsPixel(Collidable collidable, int x, int y) {

        return (collidable.getRepresentation().getPicture().getX() <= x &&
                x <= collidable.getRepresentation().getPicture().getX() + collidable.getRepresentation().getPicture().getWidth()) &&
                (collidable.getRepresentation().getPicture().getY() <= y &&
                y <= collidable.getRepresentation().getPicture().getY() + collidable.getRepresentation().getPicture().getHeight());
    }

    public Collidable getCollided(Collidable collidable) {

        for (Collidable c : collidables) {

            if (collidable.equals(c) || ( (c instanceof Berry) && c.isCrashed())) {
                continue;
            }

            if (containsPixel(collidable, c.getRepresentation().getPicture().getX()+REDUCE, c.getRepresentation().getPicture().getY()+REDUCE) ||
                    containsPixel(collidable, c.getRepresentation().getPicture().getX()+REDUCE, c.getRepresentation().getPicture().getY() + c.getRepresentation().getPicture().getHeight()-REDUCE) ||
                    containsPixel(collidable, c.getRepresentation().getPicture().getX() + c.getRepresentation().getPicture().getWidth()-REDUCE, c.getRepresentation().getPicture().getY()+REDUCE) ||
                    containsPixel(collidable, c.getRepresentation().getPicture().getX() + c.getRepresentation().getPicture().getWidth()-REDUCE, c.getRepresentation().getPicture().getY() + c.getRepresentation().getPicture().getHeight()-REDUCE)) {

                return c;

            }
        }

        return null;

    }

    public boolean arrangeCollidables(Collidable collidable) {

        Collidable c = getCollided(collidable);

        if (c == null) {
            return false;
        }

        c.getRepresentation().setPicXY(Representation.getRandomX(), Representation.getRandomY());
        return arrangeCollidables(c);
    }

}
