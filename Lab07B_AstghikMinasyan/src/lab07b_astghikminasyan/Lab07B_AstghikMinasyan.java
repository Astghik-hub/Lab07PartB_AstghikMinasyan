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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
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
        Label tLabel = new Label("Random Game");
        Label bLabel = new Label("Waiting...");
        Label lblImage = new Label();
        root.setTop(tLabel);
        BorderPane.setAlignment(tLabel, Pos.CENTER);
        root.setBottom(bLabel);

        VBox middle = new VBox(lblImage);
        root.setCenter(middle);
        middle.setAlignment(Pos.CENTER);

        // Put images in the array
        for (int i = 0; i < 20; i++) {
            images[i] = new Image(getClass().getResource("/images/" + (100 + i + 1) + ".jpg").toExternalForm());
        }

        ImageView view = new ImageView(images[index]);
        lblImage.setGraphic(view);
        FadeTransition fade = new FadeTransition(Duration.seconds(2), view);
        fade.setFromValue(1);
        fade.setToValue(0);

        fade.play();
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
