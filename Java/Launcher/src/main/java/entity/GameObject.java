/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import core.Size;
import core.Position;
import java.awt.*;

public abstract class GameObject {
    protected Position position;
    protected Size size;
    
    public GameObject() {
        position = new Position(50, 50);
        size = new Size(50, 50);
    }
    
    public abstract void update();
    public abstract Image getSprite();

    public Position getPosition() {
        return position;
    }

    public Size getSize() {
        return size;
    }
}
