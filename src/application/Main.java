package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * start() method
     * Method that is executed on startup
     * @param this stage
     */
    @Override
    public void start(Stage primaryStage) {

        try {
            // Import scene graphs from FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("StartScene.fxml"));
            Parent root = loader.load();

            // Create a scene with a scene graph root node set
            Scene scene = new Scene(root, 1000, 750);

            // Add style sheet
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

            // Set the scene on the stage
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * * @param args the command line arguments
     * */
    public static void main(String[] args) {
        launch(args);
    }
}