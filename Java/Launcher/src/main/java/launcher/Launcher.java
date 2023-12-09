/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package launcher;

import game.GameLoop;
import game.Game;

public class Launcher {

    public static void main(String[] args) {
        new Thread(new GameLoop(new Game(800, 600))).start();
    }
}
