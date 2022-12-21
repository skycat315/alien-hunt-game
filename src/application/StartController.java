package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.animation.TranslateTransition;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

public class StartController {

    @FXML
    private BorderPane borderPane;
    @FXML
    private Label gameTitleLabel;
    @FXML
    private Label highestScoreLabel;
    @FXML
    private Button startButton;

    AudioClip startAudio;

    int highestScore;
    String highestScoreString = "";

    /**
     * initialize() method
     * Method to be executed the first time this class is accessed
     */
    public void initialize() {

        // Game title animation
        TranslateTransition gameTitleAnimation = new TranslateTransition(Duration.seconds(5), gameTitleLabel);
        gameTitleAnimation.setFromY(-50);
        gameTitleAnimation.setToY(100);
        gameTitleAnimation.setFromX(0);
        gameTitleAnimation.setToX(0);
        gameTitleAnimation.setCycleCount(TranslateTransition.INDEFINITE);
        gameTitleAnimation.setAutoReverse(true);
        gameTitleAnimation.play();

        // Audio
        startAudio = new AudioClip(new File("src/StartScreen.mp3").toURI().toString());
        // Set the audio volume and play it
        startAudio.play(0.5);

        // If the csv file does not exist (i.e., the use accesses this game for the first time), go to createCSVFile() method and create a new csv file
        File file = new File("c:\\temp\\Alien Hunt Game_High Score.csv");
        if (file.exists() == false) {
            createCSVFile(0);
        }

        // Read the created csv file
        readCSVFile();
        highestScoreLabel.setText("THE HIGHEST SCORE:  " + highestScore);

    }

    /**
     * createCSV() method
     * Method that creates a file in the c: \temp folder to store the highest scores of the game
     * @param column name(="High Score"), high score
     */
    public void createCSVFile(int score) {

        try {
            // Create a new file
            FileWriter highScoreFile = new FileWriter(
                    "c:\\temp\\Alien Hunt Game_High Score.csv");
            // Generate a new object of PrintWriter class
            PrintWriter highScorePrint = new PrintWriter(new BufferedWriter(highScoreFile));

            // Write the data
            highScorePrint.print("The Highest Score");
            highScorePrint.print(",");
            highScorePrint.print(score);
            highScorePrint.println();

            // Close the file
            highScorePrint.close();

            System.out.println("A new file (Alien Hunt Game_High Score.csv) has been created");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * readCSV() method
     * Method that reads the csv file
     * @return the previous highest score recorded in the CSV file as an int type
     */
    public int readCSVFile() {

        try {
            File highestScoreFile = new File("c:\\temp\\Alien Hunt Game_High Score.csv");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(highestScoreFile));

            // Read the csv file one line at a time
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Store the elements read into the highestScoreData array
                String[] highestScoreData = line.split(",", 0);
                // Assign the data stored in index number 1 of the highestScoreData array to the highestScore
                highestScoreString = highestScoreData[1];
            }
            // Close the BufferedReader
            bufferedReader.close();

            highestScore = Integer.parseInt(highestScoreString);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return highestScore;
    }

    /**
     * startButton_onClick() method
     * Method that handles events when the start button is pressed
     * @param event
     */
    @FXML
    public void startButton_onClick(Event event) {

        // Stop the audio
        startAudio.stop();

        // Close the start screen
        Scene currentScene = ((Node) event.getSource()).getScene();
        Window currentWindow = currentScene.getWindow();
        currentWindow.hide();

        // Generate a play screen
        try {
            // Move to the play screen
            Parent parent = FXMLLoader.load(getClass().getResource("PlayScene.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Alien Hunt Game");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
