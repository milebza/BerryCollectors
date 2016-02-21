package org.academiadecodigo.berrycollectors.field;

import org.academiadecodigo.berrycollectors.objects.ControlledMonster;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by Milena on 08/02/2016.
 */
public class Field {

    public static final int MARGIN = 10;
    private static int width;
    private static int height;

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    public static void init(int width, int height) {
        Field.width = width;
        Field.height = height;
        Picture background = new Picture(MARGIN, MARGIN, "sources/background1.jpg");
        background.draw();

    }

    public static void instructions() {

        int x = ((width-width/2)/2) + MARGIN;
        int y = ((height-height/2)/2) + MARGIN;

        Rectangle rectangle = new Rectangle(x, y, width/2, height/2 );
        rectangle.setColor(Color.PINK);
        rectangle.fill();

        Text phrase1 = new Text(x, y+MARGIN, "GREEN changes direction with WASD keys");
        Text phrase2 = new Text(x, y+3*MARGIN, "ORANGE changes direction with the ARROW keys");
        Text phrase3 = new Text(x, y+9*MARGIN, "Collect as many berries as tou can! If you touch the YELLOW monsters you'll die!");
        Text phrase4 = new Text(x, y+12*MARGIN, "[PRESS THE SPACE BAR TO START MOVING]");
        phrase1.draw();
        phrase2.draw();
        phrase3.draw();
        phrase4.draw();
    }

    public static void placard(ControlledMonster green, ControlledMonster orange) {

        int widthRec = width/4+width/8;
        int heightRec = MARGIN;

        Rectangle rectangle = new Rectangle(widthRec, heightRec, width/4, MARGIN*5);
        rectangle.setColor(Color.PINK);
        rectangle.fill();

        Text winnerGreen = new Text(widthRec+2*MARGIN+5, heightRec+15, "GREEN is the winner!");
        Text winnerOrange = new Text(widthRec+2*MARGIN+5, heightRec+15, "ORANGE is the winner!");

        if (green.isCrashed()) {
            winnerOrange.draw();
        }

        if (orange.isCrashed()) {
            winnerGreen.draw();
        }

        if (green.isCrashed() && orange.isCrashed()) {
            winnerGreen.setText("Nobody wins!");
        }

        if (!green.isCrashed() && !orange.isCrashed()) {
            if (green.getCounter() == orange.getCounter()) {
                winnerOrange.setText("You both are winners!");
                winnerOrange.draw();
            }
            if (green.getCounter() > orange.getCounter()) {
                winnerGreen.draw();
            } else {
                winnerOrange.draw();
            }
        }
    }

}
