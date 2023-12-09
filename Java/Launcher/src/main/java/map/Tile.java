/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package map;

import gfx.SpriteLibrary;

import java.awt.*;

public class Tile {
    private Image sprite;

    public Tile(SpriteLibrary spriteLibrary) {
        this.sprite = spriteLibrary.getTile("monsoongrass");
    }

    public Image getSprite() {
        return sprite;
    }
}
