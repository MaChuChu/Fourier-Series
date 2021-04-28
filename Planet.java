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
public class Planet {

    double x, y, radius, position;
    Circle shape;

    Planet(double x, double y, double radius, int type, int position) {

        this.x = x;
        this.y = y;
        this.radius = radius;
        this.position = position;

        switch (type) {
            case 0:
                shape = new Circle(x, y, radius, null);
                shape.setStroke(Color.WHITE);
                Orbit20.root.getChildren().add(shape);
                break;
            case 1:
                shape = new Circle(x, y, radius, Color.WHITE);
                Orbit20.root.getChildren().add(shape);
                break;
        }

    }

    public void move(Planet prev) {
        double angleAlpha = Orbit20.count * ( Math.PI / 200 );
        
        double n =  position * 2 + 1;
        //double radius2 = prev.radius * (n / (position * Math.PI));
        
        x = prev.x + (prev.radius * Math.sin(n * angleAlpha));
        y = prev.y + (prev.radius * Math.cos(n * angleAlpha));


        shape.setCenterX(x);
        shape.setCenterY(y);
    }
}
