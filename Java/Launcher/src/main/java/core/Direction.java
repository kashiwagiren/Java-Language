/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

public enum Direction {
    S(0),
    W(1),
    N(3),
    E(2);
    
    private int animationRow;
    
    Direction(int animationRow) {
        this.animationRow = animationRow;
    }
    
    public static Direction fromMotion(Motion motion) {
        double x = motion.getVector().getX();
        double y = motion.getVector().getY();

        if(x == 0 && y > 0) return S;
        if(x < 0 && y == 0) return W;
        if(x > 0 && y == 0) return E;
        if(x == 0 && y < 0) return N;

        return S;
    }
    
    public int getAnimationRow() {
        return animationRow;
    }
}
