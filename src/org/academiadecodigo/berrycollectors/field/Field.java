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

    /** The margin of the SimpleGraphics canvas */
    public static final int MARGIN = 10;

    private static int width;
    private static int height;

    public static int getWidth() {
        return width;
    }
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

    /**
     * Displays a picture with instructions
     * @return the picture with instructions
     */
    public static Picture instructions() {

        int x = ((width-500)/2) + MARGIN;
        int y = ((height-400)/2) + MARGIN;

        Picture instructions = new Picture(x, y, "sources/instructions.jpg");
        instructions.draw();
        return instructions;
    }

    /**
     * Deletes a picture
     * @param picture the picture to be deleted
     */
    public static void delete(Picture picture) {
        picture.delete();
    }

    /**
     * Displays a placard showing the winner
     * @param green an instance of ControlledMonster
     * @param orange an instance of ControlledMonster
     */
    public static void placard(ControlledMonster green, ControlledMonster orange) {

        int widthRec = width/4+width/8;
        int heightRec = MARGIN;

        Rectangle rectangle = new Rectangle(widthRec, heightRec, width/4, MARGIN*5);
        rectangle.setColor(Color.PINK);
        rectangle.fill();

        String winnerOrange = "ORANGE is the winner!";
        Text winnerGreen = new Text(widthRec+2*MARGIN+5, heightRec+15, "GREEN is the winner!");

        if (green.isCrashed()) {
            winnerGreen.setText(winnerOrange);
        }

        if (green.isCrashed() && orange.isCrashed()) {
            winnerGreen.setText("Nobody wins!");
        }

        if (!green.isCrashed() && !orange.isCrashed()) {
            if (green.getCounter() == orange.getCounter()) {
                winnerGreen.setText("You both are winners!");
            }
            if (green.getCounter() < orange.getCounter()) {
                winnerGreen.setText(winnerOrange);
            }
        }

        winnerGreen.draw();
    }

}
