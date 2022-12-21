package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

// Inherit the Alien class
public class Martian extends Alien {

    /**
     * Constructor with arguments
     * @param eyes, arms, heads
     */
    public Martian(int eyes, int arms, int heads) {
        // Call the constructor of the Alien class
        super(eyes, arms, heads);
    }

    /**
     * drawTwoMartians() method
     * Method that draws two Martians for display on the game success screen
     * @param graphocsContext
     */
    void drawTwoMartians(GraphicsContext gc) {

        // Top
        int x = 30;
        int y = 930;

        // Color
        gc.setStroke(Color.RED);
        gc.setFill(Color.RED);

        // Heads
        gc.strokeOval(x + 53, y - 665, 95, 95);
        gc.strokeOval(x + 53, y - 570, 95, 95);

        // Eyes
        gc.strokeOval(x + 83, y - 635, 37, 37);
        gc.fillOval(x + 83, y - 635, 37, 37);
        gc.strokeOval(x + 83, y - 540, 37, 37);
        gc.fillOval(x + 83, y - 540, 37, 37);

        // Body
        gc.strokeLine(x + 35, y - 420, x + 72, y - 482);
        gc.strokeLine(x + 167, y - 420, x + 130, y - 482);

        // Arms
        gc.strokeLine(x + 5, y - 490, x + 65, y - 470);
        gc.strokeLine(x - 12, y - 470, x + 52, y - 450);
        gc.strokeLine(x + 198, y - 490, x + 138, y - 470);
        gc.strokeLine(x + 208, y - 470, x + 148, y - 450);

        // A description that names the drawing
        gc.strokeText("Martian", x + 80, y - 440);

        // Bottom
        y -= 250;

        // Color
        gc.setStroke(Color.RED);
        gc.setFill(Color.RED);

        // Heads
        gc.strokeOval(x + 53, y - 665, 95, 95);
        gc.strokeOval(x + 53, y - 570, 95, 95);

        // Eyes
        gc.strokeOval(x + 83, y - 635, 37, 37);
        gc.fillOval(x + 83, y - 635, 37, 37);
        gc.strokeOval(x + 83, y - 540, 37, 37);
        gc.fillOval(x + 83, y - 540, 37, 37);

        // Body
        gc.strokeLine(x + 35, y - 420, x + 72, y - 482);
        gc.strokeLine(x + 167, y - 420, x + 130, y - 482);

        // Arms
        gc.strokeLine(x + 5, y - 490, x + 65, y - 470);
        gc.strokeLine(x - 12, y - 470, x + 52, y - 450);
        gc.strokeLine(x + 198, y - 490, x + 138, y - 470);
        gc.strokeLine(x + 208, y - 470, x + 148, y - 450);

        // A description that names the drawing
        gc.strokeText("Martian", x + 80, y - 440);

    }
}
