/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orbit2.pkg0;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Ranjeth
 */
public class Orbit20 extends Application {

    public static Group root;
    public static Scene scene;

    int size = 3;
    public Planet child[] = new Planet[size+1], dots[] = new Planet[size+1];
    public Pathway lines[] = new Pathway[size+2];
    public ArrayList<Wave> waves = new ArrayList<>();
    public static double count = 0.5;

    @Override
    public void start(Stage primaryStage) {

        root = new Group();

        scene = new Scene(root, 1000, 800);
        scene.setFill(Color.BLACK);

        draw();

        update();

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void draw() {
        double prevX = 300;
        double prevY = scene.getHeight() / 2;
        
        double radius = 100;
        for (int i = 0; i < child.length; i++) {
            child[i] = new Planet(prevX, prevY, radius, 0, i);
            dots[i] = new Planet(prevX, prevY, 5, 1, i);
            lines[i] = new Pathway(prevX,prevY,prevX+radius,prevY);
            prevX += radius;
            radius *= 0.6;

        }
        lines[lines.length-1] = new Pathway(lines[lines.length - 2].x,lines[lines.length - 2].y,lines[lines.length - 2].ex+50,lines[lines.length - 2].ey);
        root.getChildren().remove(lines[0].line1);
            
    }

    public void update() {
        AnimationTimer animation = new AnimationTimer() {
            @Override
            public void handle(long now) {
                count += 0.5;
                moveAll();
            }

        };
        animation.start();

    }

    public void moveAll() {
        for (int i = 1; i < child.length; i++) {
            child[i].move(child[i - 1]);
            dots[i].move(child[i-1]);
            lines[i].move(child[i - 1],child[i]);
        }
        lines[lines.length-1].moveLine(dots[dots.length-1]);
        
        waves.add(new Wave(lines[lines.length-1].ex,lines[lines.length-1].y));
        for (int i = 0; i < waves.size(); i++) {
            waves.get(i).move();
            if (waves.get(i).x > scene.getWidth()-100) {
                root.getChildren().remove(waves.get(i).shape);
            }
        }
    }

}
