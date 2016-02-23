package org.academiadecodigo.berrycollectors.objects;

import org.academiadecodigo.berrycollectors.field.Representation;

/**
 * Created by milena on 08/02/16.
 */
public class CollisionDetector {

    private static final int REDUCE = 7;

    private Collidable[] collidables;

    public CollisionDetector(Collidable[] collidables) {
        this.collidables = collidables;
    }

    /**
     * Checks if a pixel is inside a collidable
     * @param collidable the collidable to check
     * @param x the x coordinate of the pixel
     * @param y the y coordinate of the pixel
     * @return true if the pixel is inside
     */
    private boolean isPixelInside(Collidable collidable, int x, int y) {

        return (collidable.getRepresentation().getPicture().getX() <= x &&
                x <= collidable.getRepresentation().getPicture().getX() + collidable.getRepresentation().getPicture().getWidth()) &&
                (collidable.getRepresentation().getPicture().getY() <= y &&
                y <= collidable.getRepresentation().getPicture().getY() + collidable.getRepresentation().getPicture().getHeight());
    }

    /**
     * Gives a collidable that collided
     * @param collidable the collidable to check collisions with the array
     * @return the collidable that collided or null
     */
    public Collidable getCollided(Collidable collidable) {

        for (Collidable c : collidables) {

            if (collidable.equals(c) || ( (c instanceof Berry) && c.isCrashed())) {
                continue;
            }

            if (isPixelInside(collidable, c.getRepresentation().getPicture().getX()+REDUCE, c.getRepresentation().getPicture().getY()+REDUCE) ||
                    isPixelInside(collidable, c.getRepresentation().getPicture().getX()+REDUCE, c.getRepresentation().getPicture().getY() + c.getRepresentation().getPicture().getHeight()-REDUCE) ||
                    isPixelInside(collidable, c.getRepresentation().getPicture().getX() + c.getRepresentation().getPicture().getWidth()-REDUCE, c.getRepresentation().getPicture().getY()+REDUCE) ||
                    isPixelInside(collidable, c.getRepresentation().getPicture().getX() + c.getRepresentation().getPicture().getWidth()-REDUCE, c.getRepresentation().getPicture().getY() + c.getRepresentation().getPicture().getHeight()-REDUCE)) {

                return c;

            }
        }

        return null;

    }

    /**
     *
     * @param collidable
     * @return
     */
    public boolean arrangeCollidables(Collidable collidable) {

        Collidable c = getCollided(collidable);

        if (c == null) {
            return false;
        }

        c.getRepresentation().setPicXY(Representation.getRandomX(), Representation.getRandomY());
        return arrangeCollidables(c);
    }

}
