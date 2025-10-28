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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author 2466920
 */
public class Lab07B_AstghikMinasyan extends Application {

    public static int index = 0;
    public static Image[] images = new Image[20];

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

        Button playPause = new Button("Play");
        Button increaseSpead = new Button("Speed+");
        Button decreaseSpead = new Button("Speed-");

        VBox middle = new VBox(lblImage);

        root.setCenter(middle);
        middle.setAlignment(Pos.CENTER);

        VBox buttons = new VBox(10, playPause, increaseSpead, decreaseSpead);
        root.setLeft(buttons);

        // Put images in the array
        for (int i = 0; i < 20; i++) {
            images[i] = new Image(getClass().getResource("/images/" + (100 + i + 1) + ".jpg").toExternalForm());
        }

        ImageView view = new ImageView(images[index]);
        lblImage.setGraphic(view);

        FadeTransition fade = new FadeTransition(Duration.seconds(2), view);
        fade.setFromValue(1);
        fade.setToValue(0);

        playPause.setOnAction(e -> {
            if (playPause.getText().equals("Play")) {
                fade.play();
                playPause.setText("Pause");
            } else {
                fade.pause();
                playPause.setText("Play");
            }
        });
        
        increaseSpead.setOnAction(e -> {
            fade.setDuration(fade.getDuration().multiply(0.5));
        });
        
        decreaseSpead.setOnAction(e -> {
            fade.setDuration(fade.getDuration().multiply(2));
        });
        
        fade.setOnFinished(e -> {
            changeImage();
            view.setImage(images[index]);
            fade.playFromStart();
        });

        // Show the scene
        stage.setScene(scene);
        stage.show();
    }

    public void changeImage() {
        if (index < images.length - 1) {
            index++;
        } else {
            index = 0;
        }
    }
}
