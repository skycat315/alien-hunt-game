package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javafx.animation.TranslateTransition;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class JAlienHunt {

    @FXML
    private BorderPane borderPane;
    @FXML
    private Label messageLabel;
    @FXML
    private Label scoreLabel;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button resetButton;
    @FXML
    private Label button1Label;
    @FXML
    private Label button2Label;
    @FXML
    private Label button3Label;
    @FXML
    private Label button4Label;
    @FXML
    private Label button5Label;
    @FXML
    private Label button6Label;
    @FXML
    private Label button7Label;
    @FXML
    private Label button8Label;
    @FXML
    private Rectangle rectangle1;
    @FXML
    private Rectangle rectangle2;
    @FXML
    private Rectangle rectangle3;

    AudioClip backMusicAudio;
    AudioClip martianAudio;
    AudioClip jupiterianAudio;

    // Create an instance of Start class
    StartController scene1 = new StartController();

    // Each button can only be pressed once during play
    boolean button1Pressed = false;
    boolean button2Pressed = false;
    boolean button3Pressed = false;
    boolean button4Pressed = false;
    boolean button5Pressed = false;
    boolean button6Pressed = false;
    boolean button7Pressed = false;
    boolean button8Pressed = false;

    // Variables to manage the score
    int score;
    int newScore;

    // Number of times Martians have appeared
    int martianCount;
    // Number of times Jupiterians have appeared
    int jupiterianCount;

    // An array corresponding to the eight buttons as Integer
    int[] buttonArray = new int[8];
    // 0: Martian, 1: Jupiterian
    int alienType;

    /**
     * initialize() method
     * Method to be executed the first time this class is accessed
     */
    public void initialize() {

        // Rectangles animation
        // Rectangle 1
        TranslateTransition rectangle1Animation = new TranslateTransition(Duration.seconds(3), rectangle1);
        rectangle1Animation.setFromY(0);
        rectangle1Animation.setToY(250);
        rectangle1Animation.setFromX(0);
        rectangle1Animation.setToX(350);
        rectangle1Animation.setCycleCount(TranslateTransition.INDEFINITE);
        rectangle1Animation.setAutoReverse(true);
        rectangle1Animation.play();
        // Rectangle 2
        TranslateTransition rectangle2Animation = new TranslateTransition(Duration.seconds(4), rectangle2);
        rectangle2Animation.setFromY(0);
        rectangle2Animation.setToY(300);
        rectangle2Animation.setFromX(0);
        rectangle2Animation.setToX(200);
        rectangle2Animation.setCycleCount(TranslateTransition.INDEFINITE);
        rectangle2Animation.setAutoReverse(true);
        rectangle2Animation.play();
        // Rectangle 3
        TranslateTransition rectangle3Animation = new TranslateTransition(Duration.seconds(3.5), rectangle3);
        rectangle3Animation.setFromY(0);
        rectangle3Animation.setToY(-75);
        rectangle3Animation.setFromX(0);
        rectangle3Animation.setToX(500);
        rectangle3Animation.setCycleCount(TranslateTransition.INDEFINITE);
        rectangle3Animation.setAutoReverse(true);
        rectangle3Animation.play();

        // Audio
        backMusicAudio = new AudioClip(new File("src/PlayScreen.mp3").toURI().toString());
        // Set the audio volume and play it
        backMusicAudio.play(0.3);

        // Assign aliens randomly
        shuffleAlien();

    }

    /**
     * button1_onClick() method
     * Method that handles events when the button1 is pressed
     * @param event
     */
    @FXML
    public void button1_onClick(Event eve) {

        // Assign elements(0/1) of buttonArray to alienType
        alienType = buttonArray[0];

        if (button1Pressed == false) {
            // Martian
            if (alienType == 0) {
                showMartian(button1);
                score += 1;
                martianCount += 1;
                if (martianCount == 6) {
                    gameCompleted();
                }
            }
            // Jupiterian
            else {
                showJupiterian(button1);
                jupiterianCount += 1;
                if (jupiterianCount == 2) {
                    gameOver();
                }
            }
            updateScore(score);
        }

        button1Pressed = true;
    }

    /**
     * button2_onClick() method
     * Method that handles events when the button2 is pressed
     * @param event
     */
    @FXML
    public void button2_onClick(Event eve) {

        alienType = buttonArray[1];

        if (button2Pressed == false) {
            // Martian
            if (alienType == 0) {
                showMartian(button2);
                score += 1;
                martianCount += 1;
                if (martianCount == 6) {
                    gameCompleted();
                }
            }
            // Jupiterian
            else {
                showJupiterian(button2);
                jupiterianCount += 1;
                if (jupiterianCount == 2) {
                    gameOver();
                }
            }
            updateScore(score);
        }

        button2Pressed = true;
    }

    /**
     * button3_onClick() method
     * Method that handles events when the button3 is pressed
     * @param event
     */
    @FXML
    public void button3_onClick(Event eve) {

        alienType = buttonArray[2];

        if (button3Pressed == false) {
            // Martian
            if (alienType == 0) {
                showMartian(button3);
                score += 1;
                martianCount += 1;
                if (martianCount == 6) {
                    gameCompleted();
                }
            }
            // Jupiterian
            else {
                showJupiterian(button3);
                jupiterianCount += 1;
                if (jupiterianCount == 2) {
                    gameOver();
                }
            }
            updateScore(score);
        }

        button3Pressed = true;
    }

    /**
     * button4_onClick() method
     * Method that handles events when the button4 is pressed
     * @param event
     */
    @FXML
    public void button4_onClick(Event eve) {

        alienType = buttonArray[3];

        if (button4Pressed == false) {
            // Martian
            if (alienType == 0) {
                showMartian(button4);
                score += 1;
                martianCount += 1;
                if (martianCount == 6) {
                    gameCompleted();
                }
            }
            // Jupiterian
            else {
                showJupiterian(button4);
                jupiterianCount += 1;
                if (jupiterianCount == 2) {
                    gameOver();
                }
            }
            updateScore(score);
        }

        button4Pressed = true;
    }

    /**
     * button5_onClick() method
     * Method that handles events when the button5 is pressed
     * @param event
     */
    @FXML
    public void button5_onClick(Event eve) {

        alienType = buttonArray[4];

        if (button5Pressed == false) {
            // Martian
            if (alienType == 0) {
                showMartian(button5);
                score += 1;
                martianCount += 1;
                if (martianCount == 6) {
                    gameCompleted();
                }
            }
            // Jupiterian
            else {
                showJupiterian(button5);
                jupiterianCount += 1;
                if (jupiterianCount == 2) {
                    gameOver();
                }
            }
            updateScore(score);
        }

        button5Pressed = true;
    }

    /**
     * button6_onClick() method
     * Method that handles events when the button6 is pressed
     * @param event
     */
    @FXML
    public void button6_onClick(Event eve) {

        alienType = buttonArray[5];

        if (button6Pressed == false) {
            // Martian
            if (alienType == 0) {
                showMartian(button6);
                score += 1;
                martianCount += 1;
                if (martianCount == 6) {
                    gameCompleted();
                }
            }
            // Jupiterian
            else {
                showJupiterian(button6);
                jupiterianCount += 1;
                if (jupiterianCount == 2) {
                    gameOver();
                }
            }
            updateScore(score);
        }

        button6Pressed = true;
    }

    /**
     * button7_onClick() method
     * Method that handles events when the button7 is pressed
     * @param event
     */
    @FXML
    public void button7_onClick(Event eve) {

        alienType = buttonArray[6];

        if (button7Pressed == false) {
            // Martian
            if (alienType == 0) {
                showMartian(button7);
                score += 1;
                martianCount += 1;
                if (martianCount == 6) {
                    gameCompleted();
                }
            }
            // Jupiterian
            else {
                showJupiterian(button7);
                jupiterianCount += 1;
                if (jupiterianCount == 2) {
                    gameOver();
                }
            }
            updateScore(score);
        }

        button7Pressed = true;
    }

    /**
     * button8_onClick() method
     * Method that handles events when the button8 is pressed
     * @param event
     */
    @FXML
    public void button8_onClick(Event eve) {

        alienType = buttonArray[7];

        if (button8Pressed == false) {
            // Martian
            if (alienType == 0) {
                showMartian(button8);
                score += 1;
                martianCount += 1;
                if (martianCount == 6) {
                    gameCompleted();
                }
            }
            // Jupiterian
            else {
                showJupiterian(button8);
                jupiterianCount += 1;
                if (jupiterianCount == 2) {
                    gameOver();
                }
            }
            updateScore(score);
        }

        button8Pressed = true;
    }

    /**
     * resetButton_onClick() method
     * Method that handles events when the reset button is pressed
     * @param event
     */
    @FXML
    public void resetButton_onClick(Event eve) {
        resetGame();
    }

    /**
     * startGame() method
     * Method that assigns the aliens randomly again
     */
    public void startGame() {
        shuffleAlien();
    }

    /**
     * shuffleAlien() method
     * Shuffle the order of the six Martians and two Jupiters and assign them to buttons one through eight
     */
    public void shuffleAlien() {

        // An array that randomly contains 0 and 1, representing Martians and Jupiterians
        ArrayList<Integer> alienArray = new ArrayList<Integer>();

        // Stores 6 zeros and 2 ones in alienArray
        for (int i = 0; i < buttonArray.length; i++) {
            if (i < 6) {
                alienArray.add(0);
            } else {
                alienArray.add(1);
            }
        }
        // Shuffle the elements of alienArray and change the order
        Collections.shuffle(alienArray);

        System.out.println("The aliens were randomly assigned");

        // Allocate six Martians and two Jupiters randomly to the eight button
        for (int i = 1; i <= buttonArray.length; i++) {
            buttonArray[i - 1] = alienArray.get(i - 1);
            System.out.println("Button" + i + "=" + alienArray.get(i - 1));
        }
    }

    /**
     * showMartian() method
     * Method that draws a Martian and display in a label
     * @param selected button number
     */
    public void showMartian(Button selectedButton) {

        Image martianImage;

        //Creating an image
        try {
            martianImage = new Image(new FileInputStream("src/Martian.png"));
            //Setting the image view
            ImageView martianImageView = new ImageView(martianImage);
            // Set the image width to 150 to maintain aspect ratio
            martianImageView.setFitWidth(150);
            martianImageView.setPreserveRatio(true);
            // Replace the buttons and the labels
            selectedButton.setVisible(false);
            // Add the images to the labels
            if (selectedButton == button1) {
                button1Label.setGraphic(martianImageView);
                button1Label.setVisible(true);
            } else if (selectedButton == button2) {
                button2Label.setGraphic(martianImageView);
                button2Label.setVisible(true);
            } else if (selectedButton == button3) {
                button3Label.setGraphic(martianImageView);
                button3Label.setVisible(true);
            } else if (selectedButton == button4) {
                button4Label.setGraphic(martianImageView);
                button4Label.setVisible(true);
            } else if (selectedButton == button5) {
                button5Label.setGraphic(martianImageView);
                button5Label.setVisible(true);
            } else if (selectedButton == button6) {
                button6Label.setGraphic(martianImageView);
                button6Label.setVisible(true);
            } else if (selectedButton == button7) {
                button7Label.setGraphic(martianImageView);
                button7Label.setVisible(true);
            } else if (selectedButton == button8) {
                button8Label.setGraphic(martianImageView);
                button8Label.setVisible(true);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Audio
        if (martianCount < 5) {
            martianAudio = new AudioClip(new File("src/Martian.mp3").toURI().toString());
            martianAudio.play();
        }
    }

    /**
     * showJupiterian() method
     * Method that draws a jupiterian and display in a label
     * @param selected button number
     */
    public void showJupiterian(Button selectedButton) {

        Image jupiterianImage;

        //Creating an image
        try {
            jupiterianImage = new Image(new FileInputStream("src/Jupiterian.png"));
            //Setting the image view
            ImageView jupiterianImageView = new ImageView(jupiterianImage);
            // Set the image width to 150 to maintain aspect ratio
            jupiterianImageView.setFitWidth(150);
            jupiterianImageView.setPreserveRatio(true);
            // Replace the buttons and the labels
            selectedButton.setVisible(false);
            // Add the images to the labels
            if (selectedButton == button1) {
                button1Label.setGraphic(jupiterianImageView);
                button1Label.setVisible(true);
            } else if (selectedButton == button2) {
                button2Label.setGraphic(jupiterianImageView);
                button2Label.setVisible(true);
            } else if (selectedButton == button3) {
                button3Label.setGraphic(jupiterianImageView);
                button3Label.setVisible(true);
            } else if (selectedButton == button4) {
                button4Label.setGraphic(jupiterianImageView);
                button4Label.setVisible(true);
            } else if (selectedButton == button5) {
                button5Label.setGraphic(jupiterianImageView);
                button5Label.setVisible(true);
            } else if (selectedButton == button6) {
                button6Label.setGraphic(jupiterianImageView);
                button6Label.setVisible(true);
            } else if (selectedButton == button7) {
                button7Label.setGraphic(jupiterianImageView);
                button7Label.setVisible(true);
            } else if (selectedButton == button8) {
                button8Label.setGraphic(jupiterianImageView);
                button8Label.setVisible(true);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Audio
        if (jupiterianCount < 1) {
            martianAudio = new AudioClip(
                    new File("src/Jupiterian.mp3").toURI().toString());
            martianAudio.play();
        }

    }

    /**
     * showButtonsmethod
     * Method that hides alien labels and displays buttons
     * @param button number
     */
    public void showButtons(Button buttonNumber) {
        buttonNumber.setVisible(true);
    }

    /**
     * updateScore() method
     * Method that updates the score each time a button is pressed
     * @param current score
     */
    public void updateScore(int score) {
        // Display the current score
        scoreLabel.setText("SCORE: " + score);
        newScore = score;
    }

    /**
     * gameCompleted() method
     * Method for displaying a game achievement message if all Martians can be found before the Jupiterians appear twice
     */
    public void gameCompleted() {

        score = 10;
        updateScore(score);

        // If the user's score exceeds the previous highest score, update the csv file
        if (newScore > scene1.readCSVFile()) {
            scene1.createCSVFile(newScore);
        }

        // Stop the audio
        backMusicAudio.stop();

        // Generate a game success screen
        try {
            // Move to the game success screen
            Parent parent = FXMLLoader.load(getClass().getResource("GameSuccessScene.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Alien Hunt Game");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        resetGame();

        // Close current screen
        button1.getScene().getWindow().hide();
        button2.getScene().getWindow().hide();
        button3.getScene().getWindow().hide();
        button4.getScene().getWindow().hide();
        button5.getScene().getWindow().hide();
        button6.getScene().getWindow().hide();
        button7.getScene().getWindow().hide();
        button8.getScene().getWindow().hide();

    }

    /**
     * gameOver() method
     * Method that displays two Jupiterians and a message telling that the Earth has been destroyed
     */
    public void gameOver() {

        updateScore(score);

        // If the user's score exceeds the previous highest score, update the csv file
        if (newScore > scene1.readCSVFile()) {
            scene1.createCSVFile(newScore);
        }

        // Stop the audio
        backMusicAudio.stop();

        // Generate a gameover screen
        try {
            // Move to the game over screen
            Parent parent = FXMLLoader.load(getClass().getResource("GameOverScene.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Alien Hunt Game");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        resetGame();

        // Close current screen
        button1.getScene().getWindow().hide();
        button2.getScene().getWindow().hide();
        button3.getScene().getWindow().hide();
        button4.getScene().getWindow().hide();
        button5.getScene().getWindow().hide();
        button6.getScene().getWindow().hide();
        button7.getScene().getWindow().hide();
        button8.getScene().getWindow().hide();
    }

    /**
     * resetGame() method
     * Method that resets the game to its initial state
     */
    public void resetGame() {

        // Reset the score
        martianCount = 0;
        jupiterianCount = 0;
        score = 0;
        updateScore(score);

        // Replace the buttons and the labels
        button1.setVisible(true);
        button2.setVisible(true);
        button3.setVisible(true);
        button4.setVisible(true);
        button5.setVisible(true);
        button6.setVisible(true);
        button7.setVisible(true);
        button8.setVisible(true);

        button1Label.setVisible(false);
        button2Label.setVisible(false);
        button3Label.setVisible(false);
        button4Label.setVisible(false);
        button5Label.setVisible(false);
        button6Label.setVisible(false);
        button7Label.setVisible(false);
        button8Label.setVisible(false);

        // Reset the button press status
        button1Pressed = false;
        button2Pressed = false;
        button3Pressed = false;
        button4Pressed = false;
        button5Pressed = false;
        button6Pressed = false;
        button7Pressed = false;
        button8Pressed = false;
    }
}