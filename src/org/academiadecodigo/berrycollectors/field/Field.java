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

    /** @return the width of the field*/
    public static int getWidth() {
        return width;
    }

    /** @return the height of the field*/
    public static int getHeight() {
        return height;
    }

    /**
     * Creates a field
     * @param width the width of the field
     * @param height the height of the field
     */
    public static void init(int width, int height) {
        Field.width = width;
        Field.height = height;
        Picture background = new Picture(MARGIN, MARGIN, "sources/background1.jpg");
        background.draw();

    }

    public static Picture instructions() {

        int x = ((width-500)/2) + MARGIN;
        int y = ((height-400)/2) + MARGIN;

        Picture instructions = new Picture(x, y, "sources/instructions.jpg");
        instructions.draw();
        return instructions;
    }

    public static void delete(Picture picture) {
        picture.delete();
    }

    /**
     * Creates a placard showing the winner
     * @param green
     * @param orange
     */
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
