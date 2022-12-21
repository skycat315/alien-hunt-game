package application;

import java.io.File;
import java.io.IOException;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

public class GameSuccessController {

    @FXML
    private BorderPane borderPane;
    @FXML
    private Label messageLabel;
    @FXML
    private Canvas martians1Canvas;
    @FXML
    private Canvas martians2Canvas;
    @FXML
    private Canvas martians3Canvas;
    @FXML
    private Button backButton;

    AudioClip gameSuccessAudio;
    GraphicsContext graphicsContext;

    // Create an instance of the Martian class
    Martian newMartians = new Martian(2, 4, 2);

    /**
     * initialize() method
     * Method to be executed the first time this class is accessed
     */
    public void initialize() {

        // Audio
        gameSuccessAudio = new AudioClip(
                new File("src/GameSuccess.mp3").toURI().toString());
        gameSuccessAudio.play();

        // Get the GraphicsContext
        // Martian 1 and 2
        graphicsContext = martians1Canvas.getGraphicsContext2D();
        // Draw the martians in the canvas
        newMartians.drawTwoMartians(graphicsContext);
        // Martian 3 and 4
        graphicsContext = martians2Canvas.getGraphicsContext2D();
        newMartians.drawTwoMartians(graphicsContext);
        // Martian 5 and 6
        graphicsContext = martians3Canvas.getGraphicsContext2D();
        newMartians.drawTwoMartians(graphicsContext);

        // Jump animation
        animation(martians1Canvas);
        animation(martians2Canvas);
        animation(martians3Canvas);
    }

    /**
     * backButton_onClick() method
     * Method that handles events when a backButton is pressed
     * @param event
     */
    @FXML
    public void backButton_onClick(Event eve) {

        // Stop the audio
        gameSuccessAudio.stop();

        // Close the currently displayed screen
        Scene currentScene = ((Node) eve.getSource()).getScene();
        Window currentWindow = currentScene.getWindow();
        currentWindow.hide();

        // Generate a new screen
        try {
            // Move to the start screen
            Parent parent = FXMLLoader.load(getClass().getResource("StartScene.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Alien Hunt Game");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * animation() method
     * Method that animates the Martians up and down
     * @param canvas name
     */
    public void animation(Canvas canvas) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(1_000), canvas);
        translateTransition.setToY(40.0);
        translateTransition.setInterpolator(Interpolator.LINEAR);
        translateTransition.setCycleCount(Animation.INDEFINITE);
        translateTransition.play();
    }
}