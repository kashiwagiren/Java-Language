/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gfx;

import java.awt.*;
import java.util.*;

public class SpriteSet {
    private Map<String, Image>animationSheets;
    
    public SpriteSet() {
        this.animationSheets = new HashMap<>();
    }
    
    public void addSheet(String name, Image animationSheet) {
        animationSheets.put(name, animationSheet);
    }
    
    public Image get(String name) {
        return animationSheets.get(name);
    }
}
