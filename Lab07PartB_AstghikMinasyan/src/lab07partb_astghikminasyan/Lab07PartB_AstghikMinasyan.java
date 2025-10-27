/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab07partb_astghikminasyan;

import java.util.Arrays;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author 2466920
 */
public abstract class Lab07PartB_AstghikMinasyan extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Create BorderPane and scene
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 250, 300);
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

        // Create array of images
        Image[] images = new Image[20];

        FadeTransition[] fades = new FadeTransition[20];
        
        SequentialTransition sequence  = new SequentialTransition();
        // Put images in the array
        for (int i = 0; i < 20; i++) {
            images[i] = new Image("file:" + System.getProperty("user.dir") + "//images//" + (100 + i++) + ".jpg");
        }
        
        for (int i  = 0; i < 20; i++) {
            ImageView view = new ImageView(images[i]);
            fades[i] = new FadeTransition(Duration.seconds(2), view);
        }
        
        sequence.getChildren().addAll(Arrays.asList(fades));
        sequence.play();

        
//        for (Image image : images) {
//            ImageView view = new ImageView(image);
//           sequence.getChildren().add(view);
//        }
        // Show the scene
        stage.setScene(scene);
        stage.show();
    }
}
