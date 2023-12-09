/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.state;

import display.Camera;
import entity.GameObject;
import gfx.SpriteLibrary;
import input.Input;
import java.util.*;
import map.GameMap;
import core.Size;

public abstract class State {
    
    protected GameMap gameMap;
    protected List<GameObject>gameObjects;
    protected SpriteLibrary spriteLibrary;
    protected Input input;
    protected Camera camera;

    public State(Size windowSize, Input input) {
        this.input = input;
        gameObjects = new ArrayList<>();
        spriteLibrary = new SpriteLibrary();
        camera = new Camera(windowSize);
    }
    
    public void update() {
        gameObjects.forEach(gameObject -> gameObject.update());
        camera.update(this);
    }
    
    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public Camera getCamera() {
        return camera;
    }
}
