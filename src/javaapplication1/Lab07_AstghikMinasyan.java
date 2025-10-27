/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Git URL: https://github.com/Astghik-hub/Lab07_AstghikMinasyan.git
 *
 * @author Astghik Minasyan
 */
public class Lab07_AstghikMinasyan extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Create pane and scene
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 700, 700);

        // Create object A
        Circle circle = new Circle(80, 80, 50);

        // Create path so that object B will go clockwise
        Path path = new Path();
        path.getElements().add(new MoveTo(80, 80));
        path.getElements().add(new LineTo(80 + 470, 80));
        path.getElements().add(new LineTo(80 + 470, 80 + 470));
        path.getElements().add(new LineTo(80, 80 + 470));
        path.getElements().add(new LineTo(80, 80));

        // Create object A
        Ellipse oval = new Ellipse();
        oval.setRadiusX(40);
        oval.setRadiusY(25);
        oval.setCenterX(355);
        oval.setCenterY(285);
        oval.setFill(Color.BLUE);

        // Create start, reset and exit buttons
        Button start = new Button("Start");
        start.setLayoutX(60);
        start.setLayoutY(610);
        Button reset = new Button("Reset");
        reset.setLayoutX(120);
        reset.setLayoutY(610);
        Button exit = new Button("Exit");
        exit.setLayoutX(180);
        exit.setLayoutY(610);

        // Add the elements on the pane
        pane.getChildren().add(circle);
        pane.getChildren().add(oval);
        pane.getChildren().add(start);
        pane.getChildren().add(reset);
        pane.getChildren().add(exit);

        // Create a path transition
        PathTransition pt = new PathTransition(Duration.millis(5000), path, circle);
        pt.setCycleCount(Timeline.INDEFINITE);

        // Create a fade transition
        FadeTransition fade = new FadeTransition(Duration.millis(1400), oval);
        fade.setFromValue(1.0);
        fade.setToValue(0.3);

        // Create a scale transition
        ScaleTransition scale = new ScaleTransition(Duration.millis(1100), oval);
        scale.setToX(2);
        scale.setToY(2);

        // Create a rotate transition
        RotateTransition rotate = new RotateTransition(Duration.millis(1000), oval);
        rotate.setFromAngle(0);
        rotate.setToAngle(90);

        // Create a translate transtion
        TranslateTransition translate = new TranslateTransition(Duration.millis(1500), oval);
        translate.setToX(290);

        // Create sequential transition
        // Add fade, scale, rotate and translate to sequential transition
        SequentialTransition sequence = new SequentialTransition(fade, scale, rotate, translate);
        sequence.setCycleCount(Animation.INDEFINITE);

        // Create parallel transtition
        // Add pt and sequence to it
        ParallelTransition both = new ParallelTransition(pt, sequence);

        // Play both when clicking start
        start.setOnMouseClicked(e -> both.play());

        // Reset animation to original form when clicking reset
        reset.setOnMouseClicked(e -> {
            both.playFrom(Duration.ZERO);
            both.pause();
        });

        // Exit the animation when clicking exit
        exit.setOnMouseClicked(e -> stage.close());

        // Set the scene of the stage and show it
        stage.setScene(scene);
        stage.show();
    }

}
