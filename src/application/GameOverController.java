package application;

import java.io.File;
import java.io.IOException;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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

public class GameOverController {

    @FXML
    private BorderPane borderPane;
    @FXML
    private Label messageLabel;
    @FXML
    private Canvas jupiterian1Canvas;
    @FXML
    private Canvas jupiterian2Canvas;
    @FXML
    private Button backButton;

    AudioClip gameOverAudio;
    GraphicsContext graphicsContext;

    // Create an instance of the Jupiterian class
    Jupiterian newJupiterian = new Jupiterian(3, 2, 1);

    /**
     * initialize() method
     * Method to be executed the first time this class is accessed
     */
    public void initialize() {

        // Audio
        gameOverAudio = new AudioClip(new File("src/GameOver.mp3").toURI().toString());
        gameOverAudio.play();

        // Get the GraphicsContext
        // Jupiterian 1
        graphicsContext = jupiterian1Canvas.getGraphicsContext2D();
        // Draw the jupiterian in the canvas
        newJupiterian.drawJupiterian(graphicsContext);
        // Jupiterian 2
        graphicsContext = jupiterian2Canvas.getGraphicsContext2D();
        // Draw the jupiterian in the canvas
        newJupiterian.drawJupiterian(graphicsContext);

        // Flashing the message label
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), evt -> messageLabel.setVisible(false)),
                new KeyFrame(Duration.seconds(1.0), evt -> messageLabel.setVisible(true)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        // Fade transition
        fadeIn(jupiterian1Canvas);
        fadeIn(jupiterian2Canvas);
    }

    /**
     * backButton_onClick() method
     * Method that handles events when a backButton is pressed
     * @param event
     */
    @FXML
    public void backButton_onClick(Event eve) {

        // Stop the audio
        gameOverAudio.stop();

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
     * fadeIn() method
     * Method that gradually projects Martians
     * @param canvas name
     */
    public void fadeIn(Canvas canvas) {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.millis(5000));
        fadeTransition.setFromValue(0.1);
        fadeTransition.setToValue(10);
        fadeTransition.setAutoReverse(true);
        fadeTransition.setNode(canvas);
        fadeTransition.play();
    }
}