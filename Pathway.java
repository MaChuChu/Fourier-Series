/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orbit2.pkg0;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 *
 * @author Ranjeth
 */
public class Pathway {
    double x, y, ex, ey;
    int position;
    Line line1;
    
    Pathway(double x, double y, double ex, double ey){
        this.x = x;
        this.y = y;
        this.ex = ex;
        this.ey = ey;
        
        this.line1 = new Line(x,y,ex,ey);
        this.line1.setStroke(Color.WHITE);
        Orbit20.root.getChildren().add(this.line1);
    }
    
    public void move(Planet prev, Planet curr) {
        x = prev.x;
        y = prev.y;
        ex = curr.x;
        ey = curr.y;
        
        line1.setStartX(x);
        line1.setStartY(y);
        line1.setEndX(ex);
        line1.setEndY(ey);
    }
    
    public void moveLine(Planet last){
        x = last.x;
        y = last.y;
        
        line1.setStartX(x);
        line1.setStartY(y);
        line1.setEndY(y);
    }
}
