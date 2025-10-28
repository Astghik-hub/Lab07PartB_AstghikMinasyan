/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab07b_astghikminasyan;

import javafx.util.Duration;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Git URL: https://github.com/Astghik-hub/Lab07PartB_AstghikMinasyan.git
 *
 * @author 2466920
 */
public class Lab07B_AstghikMinasyan extends Application {

    // An array of Images
    public static Image[] images = new Image[20];

    // Variable indicating the current index of the array
    public static int index = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Create BorderPane and scene
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("Java Games");

        // Create labels and center them 
        Label tLabel = new Label("Transition Game");
        Label lblImage = new Label();
        root.setTop(tLabel);
        BorderPane.setAlignment(tLabel, Pos.CENTER);
        VBox middle = new VBox(lblImage);
        root.setCenter(middle);
        middle.setAlignment(Pos.CENTER);

        // Create buttons and add them to the pane
        Button playPause = new Button("Play");
        Button increaseSpead = new Button("Speed+");
        Button decreaseSpead = new Button("Speed-");
        VBox buttons = new VBox(10, playPause, increaseSpead, decreaseSpead);
        root.setLeft(buttons);

        // Put images in the array
        for (int i = 0; i < 20; i++) {
            images[i] = new Image(getClass().getResource("/images/" + (100 + i + 1) + ".jpg").toExternalForm());
        }

        // Display the first image of the array on the screen
        ImageView view = new ImageView(images[index]);
        lblImage.setGraphic(view);

        // Create a fade transition
        FadeTransition fade = new FadeTransition(Duration.seconds(2), view);
        fade.setFromValue(1);
        fade.setToValue(0);

        // Start the animation and change the text to pause
        // Pause the animation and chnange the text to play
        playPause.setOnAction(e -> {
            if (playPause.getText().equals("Play")) {
                fade.play();
                playPause.setText("Pause");
            } else {
                fade.pause();
                playPause.setText("Play");
            }
        });

        // Increase the speed of the animation
        increaseSpead.setOnAction(e -> {
            fade.setDuration(fade.getDuration().multiply(0.5));
        });

        // Decrease the speed of the animation
        decreaseSpead.setOnAction(e -> {
            fade.setDuration(fade.getDuration().multiply(2));
        });

        // Dispplay the next image once the fade transition is done
        fade.setOnFinished(e -> {
            // Change the index
            changeIndex();

            // set the image view to the next image
            view.setImage(images[index]);
            fade.playFromStart();
        });

        // Show the scene
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Updates the index to the next one 
     * Resets the index to 0 if it has reached the end of the array
     */
    public void changeIndex() {
        if (index < images.length - 1) {
            index++;
        } else {
            index = 0;
        }
    }
}
