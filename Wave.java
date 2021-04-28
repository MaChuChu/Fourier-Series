/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orbit2.pkg0;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Ranjeth
 */
public class Wave {
    double x, y;
    Circle shape;
    
    Wave(double x, double y){
        this.x = x;
        this.y = y;
        
        shape = new Circle(x,y,2,Color.WHITE);
        Orbit20.root.getChildren().add(this.shape);
    }
    
    public void move(){
        x++;
        
        shape.setCenterX(x);
    }
}
