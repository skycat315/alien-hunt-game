package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

// Inherit the Alien class
public class Jupiterian extends Alien {

    /**
     * Constructor with arguments
     * @param eyes, arms, heads
     */
    public Jupiterian(int eyes, int arms, int heads) {
        // Call the constructor of the Alien class
        super(eyes, arms, heads);
    }

    /**
     * drawJupiterian() method
     * Method that draws a Jupiterian for display on the game over screen
     * @param graphocsContext
     */
    void drawJupiterian(GraphicsContext gc) {

        int x = 0;
        int y = 650;

        // Color
        gc.setStroke(Color.BLUE);
        gc.setFill(Color.YELLOW);

        // Head
        gc.strokePolygon(new double[] { x + 200, x + 350, x + 50 }, new double[] { y - 575, y - 325, y - 325 }, 3);

        // Eyes
        gc.strokeOval(x + 170, y - 500, 50, 50);
        gc.fillOval(x + 170, y - 500, 50, 50);
        gc.strokeOval(x + 125, y - 425, 50, 50);
        gc.fillOval(x + 125, y - 425, 50, 50);
        gc.strokeOval(x + 210, y - 425, 50, 50);
        gc.fillOval(x + 210, y - 425, 50, 50);

        // Body
        gc.strokeLine(x + 75, y - 200, x + 130, y - 325);
        gc.strokeLine(x + 325, y - 200, x + 270, y - 325);

        // Arms
        gc.strokeLine(x + 25, y - 300, x + 105, y - 265);
        gc.strokeLine(x + 377, y - 300, x + 297, y - 265);

        // A description that names the drawing
        gc.strokeText("Jupiterian", x + 175, y - 250);
    }
}
