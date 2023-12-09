/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import input.Input;
import display.Display;
import core.Size;
import game.state.GameState;
import game.state.State;

public class Game {
    
    public static int SPRITE_SIZE = 64;
    
    private Display thegame;    
    private Input input;
    private State state;
    
    
    public Game(int width, int height) {
        input = new Input();
        thegame = new Display(width, height, input);
        state = new GameState(new Size(width, height), input);
    }
    
    public void update() {
        state.update();
    }
    
    public void render() {
        thegame.render(state);
    }
}
