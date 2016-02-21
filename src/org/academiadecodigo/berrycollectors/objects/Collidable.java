package org.academiadecodigo.berrycollectors.objects;

import org.academiadecodigo.berrycollectors.field.Representation;

/**
 * Created by milena on 11/02/16.
 */
public interface Collidable {

    Representation getRepresentation();

    boolean setCollision(boolean collided);

    boolean isCrashed();

    void collided();

}
