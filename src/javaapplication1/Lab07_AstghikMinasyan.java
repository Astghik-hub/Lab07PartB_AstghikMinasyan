/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;

import java.util.Timer;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Git URL: https://github.com/Astghik-hub/Lab07_AstghikMinasyan.git
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
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 700,700);
        
        Rectangle path = new Rectangle(80, 80, 550, 450);
        
        Circle circle = new Circle(80, 80, 50);
        
        Ellipse oval = new Ellipse();
        oval.setRadiusX(40);
        oval.setRadiusY(25);
        oval.setCenterX(355);
        oval.setCenterY(285);
        oval.setFill(Color.BLUE);
        
        Button start = new Button("Start");
        start.setLayoutX(60);
        start.setLayoutY(600);
        Button reset = new Button("Reset");
        reset.setLayoutX(120);
        reset.setLayoutY(600);
        Button exit = new Button("Exit");
        exit.setLayoutX(180);
        exit.setLayoutY(600);
       
        pane.getChildren().add(circle);
        pane.getChildren().add(oval);
        pane.getChildren().add(start);
        pane.getChildren().add(reset);
        pane.getChildren().add(exit);
        
        PathTransition pt  = new PathTransition(Duration.millis(5000), path, circle);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setRate(-1);
        
        FadeTransition fade = new FadeTransition(Duration.millis(1280), oval);
        fade.setCycleCount(Timeline.INDEFINITE);
        fade.setFromValue(1.0);
        fade.setToValue(0.3);
        
        ScaleTransition scale = new ScaleTransition(Duration.millis(1300), oval);
        scale.setCycleCount(Timeline.INDEFINITE);
        
        SequentialTransition sequence = new SequentialTransition(fade);
        ParallelTransition both = new ParallelTransition(pt, sequence);
        
        start.setOnMouseClicked(e ->  both.play());
        reset.setOnMouseClicked(e -> {
            both.playFrom(Duration.ZERO);
            both.pause();
                });
        exit.setOnMouseClicked(e -> stage.close());
        
        stage.setScene(scene);
        stage.show();
    }
    
}
