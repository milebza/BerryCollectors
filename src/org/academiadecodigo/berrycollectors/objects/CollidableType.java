package org.academiadecodigo.berrycollectors.objects;

/**
 * Created by milena on 03/02/16.
 */
public enum CollidableType {
    YELLOW(3),
    GREEN(5),
    ORANGE(5),
    BERRY(0);

    private int speed;

    CollidableType(int speed){
        this.speed = speed;
    }

    public String[] getPicsPath(CollidableType collidableType) {

        String [] picsPathYellow = {"sources/monster1.png", "sources/splash.png"};
        String [] picsPathGreen = {"sources/mymonster.png", "sources/splash.png"};
        String [] picsPathOrange = {"sources/mymonster2.png", "sources/splash.png"};
        String [] picsPathBerry = {"sources/berry.png", "sources/berry.png"};

        String[] picsPathNew = new String[2];

        switch (collidableType) {
            case YELLOW:
                picsPathNew = picsPathYellow;
                break;
            case GREEN:
                picsPathNew = picsPathGreen;
                break;
            case ORANGE:
                picsPathNew = picsPathOrange;
                break;
            case BERRY:
                picsPathNew = picsPathBerry;
                break;
        }

        return picsPathNew;
    }

    public int getSpeed() {
        return speed;
    }
}

