/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import controller.Controller;

public class Motion {
    private Vector2D vector;
    private double speed;

    public Motion(double speed) {
        this.speed = speed;
        this.vector = new Vector2D(0, 0);
    }
    
    public void update(Controller controller) {
        int deltaX = 0;
        int deltaY = 0;
        
        if(controller.isRequestingUp()) {
            deltaY--;
        }
        else if(controller.isRequestingDown()) {
            deltaY++;
        }
        else if(controller.isRequestingLeft()) {
            deltaX--;
        }
        else if(controller.isRequestingRight()) {
            deltaX++;
        }
        
        vector = new Vector2D(deltaX, deltaY);
        vector.normalize();
        vector.multiply(speed);
    }

    public Vector2D getVector() {
        return vector;
    }

    public boolean isMoving() {
        return vector.length() > 0;
    }
    
}
