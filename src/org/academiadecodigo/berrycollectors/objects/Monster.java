package org.academiadecodigo.berrycollectors.objects;

import org.academiadecodigo.berrycollectors.RandomGenerator;
import org.academiadecodigo.berrycollectors.field.Direction;
import org.academiadecodigo.berrycollectors.field.Representation;

abstract public class Monster implements Collidable {

    private static final int THRESHOLD = 5;

    Representation representation;
    CollidableType collidableType;

    private Direction direction;
    private int speed;
    private boolean crashed;
    private CollisionDetector detector;

    /**
     * Constructs a Monster with a random direction
     * @param representation the representation
     * @param collidableType the collidable type
     */
    public Monster(Representation representation, CollidableType collidableType) {

        direction = chooseDirection();

        this.representation = representation;
        this.collidableType = collidableType;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public Representation getRepresentation() {
        return representation;
    }

    public CollisionDetector getDetector() {
        return detector;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isCrashed() {
        return crashed;
    }

    public boolean setCollision(boolean crashed) {

        return this.crashed = crashed;
    }

    public void collided() {
        setCollision(true);
        representation.getPicture().load(representation.getPicsPath()[1]);
    }

    /**
     * Creates a collision detector
     * @param collidables the array of collidables to check if there are collisions
     */
    public void createCollisionDetector(Collidable[] collidables) {
        detector = new CollisionDetector(collidables);
    }

    /** Moves the monster */
    public void move() {

        if (isCrashed()) {
            return;
        }

        int randomNumber = RandomGenerator.getRandomByRange(0, 100);

        Direction newDirection = direction;

        if (representation.checkPos(direction)) {
            newDirection = newDirection.opposite();
        } else if (randomNumber < THRESHOLD) {
            newDirection = Direction.choose();
        }

        direction = newDirection;

        for (int i = 0; i < speed; i++) {

            representation.moveInDirection(direction, 1);

            Collidable c = getDetector().getCollided(this);
            if (c != null) {
                direction = direction.opposite();
            }
        }

    }

    /**
     * Chooses a direction
     * @return a direction
     */
    public Direction chooseDirection() {

        direction = Direction.choose();

        return direction;

    }
}
