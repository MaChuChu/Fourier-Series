/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orbit;

import java.util.ArrayList;
import java.util.Timer;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 *
 * @author Ranjeth
 */
public class Orbit extends Application {

    public static Group root;
    Scene scene;

    public static int SCREEN_WIDTH = 1000;
    public static int SCREEN_HEIGHT = 800;

    public static double movingStep, tempX, x, y;
    public static Entity mainCircle, secondCircle, line;
    public static Circle circle;
    public static ArrayList<Entity> Circles;
    public static ArrayList<Entity> wave;

    Timer gameTimer;

    @Override
    public void start(Stage stage) {

        root = new Group();

        scene = new Scene(root, SCREEN_WIDTH, SCREEN_HEIGHT);
        scene.setFill(Color.BLACK);
        
        x = 200;
        y = SCREEN_HEIGHT / 2;

        mainCircle = new Entity(x, y, 100, Color.WHITE);
        //secondCircle = new Entity(mainCircle.x + mainCircle.radius, mainCircle.y, 10, Color.WHITE);
        
        Circles  =  new ArrayList<>();
        makeAllCircles();
        
        line = new Entity(Circles.get(Circles.size() - 1).x, Circles.get(Circles.size() - 1).y, 200 + Circles.get(Circles.size() - 1).x, 200 + Circles.get(Circles.size() - 1).y);
                
        tempX = line.line.getEndX();
        wave = new ArrayList<>();
        
        
        update();

        stage.setTitle("Orbits!");
        stage.setScene(scene);
        stage.show();
    }

    public void update() {
        AnimationTimer animation = new AnimationTimer() {
            @Override
            public void handle(long now) {
                drawLine();
                movingStep--;
                //secondCircle.move(mainCircle);
                moveAllCircles();
                line.moveLine(Circles.get(Circles.size() - 1));
                
            }

        };
        animation.start();

    }

    public void drawLine() {
        wave.add(new Entity(tempX, line.line.getEndY(), 1));
        for (Entity wave1 : wave) {
            wave1.shape.setCenterX(wave1.shape.getCenterX()+1);
        }
    }
    
    public void makeAllCircles(){
        for (int i = 0; i < 1; i++) {
            movingStep  = i * 2 + 1;
            double radius = 20 *  (4/ (movingStep  * Math.PI)); 
            Circles.add(new Entity(mainCircle.x, mainCircle.y, radius, Color.WHITE));
        }
    }
    
    public void moveAllCircles(){
        Circles.get(0).move(mainCircle);

    }
            /**
             * @param args the command line arguments
             */
    public static void main(String[] args) {
        launch(args);
    }
}
