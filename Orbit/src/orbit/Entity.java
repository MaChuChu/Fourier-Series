/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orbit;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

/**
 *
 * @author Ranjeth
 */
public class Entity {
    double x,y,radius;
    Circle shape;
    Line line;
    
    //Circle
    Entity(double x, double y, double radius, Color color){
        this.x = x;
        this.y = y;
        this.radius = radius;
        
        shape = new Circle(x,y,radius);
        shape.setFill(null);
        shape.setStroke(color);
        Orbit.root.getChildren().add(shape);
    }
    
    //Line
    Entity(double startX, double startY, double endX, double endY){
        line  =  new Line(startX,startY,endX,endY);
        line.setStroke(Color.WHITE);
        
        Orbit.root.getChildren().add(line);
    }
    
    //wave
    Entity(double x, double y, double radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
        
        shape = new Circle(x,y,radius,Color.WHITE);
        Orbit.root.getChildren().add(shape);
    }
    
    //Circle Movement
    public void move(Entity prev){
        
        double angleAlpha = Orbit.movingStep * ( Math.PI / 100 );
        
        x = prev.x + prev.radius * Math.sin(angleAlpha);
        y = prev.y - prev.radius * Math.cos(angleAlpha);
        
        shape.setCenterX(x);
        shape.setCenterY(y);
        
    }
    
    //Line Movement
    public void moveLine(Entity lastCircle){
        line.setStartX(lastCircle.x);
        line.setStartY(lastCircle.y);
        line.setEndY(lastCircle.y);
        
        
    }
    
}
