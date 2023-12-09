/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import controller.Controller;
import core.Direction;
import core.Motion;
import gfx.AnimationManager;
import gfx.SpriteLibrary;
import java.awt.Image;

public abstract class MovingEntity extends GameObject {
    
    private Controller controller;
    private Motion motion;
    private AnimationManager animationManager;
    private Direction direction;
    
    public MovingEntity(Controller controller, SpriteLibrary spriteLibrary) {
        super();
        this.controller = controller;
        this.motion = new Motion(2);
        this.direction = Direction.S;
        this.animationManager = new AnimationManager(spriteLibrary.getUnit("player"));
    }
    
    @Override
    public void update() {
        motion.update(controller);
        position.apply(motion);
        manageDirection();
        decideAnimation();
        animationManager.update(direction);
    }
    
    private void decideAnimation() {
        if(motion.isMoving()) {
            animationManager.playAnimation("walking");
        } else {
            animationManager.playAnimation("idle");
        }
    }
    
    private void manageDirection() {
        if(motion.isMoving()) {
            this.direction = Direction.fromMotion(motion);
        }
    }
    
    @Override
    public Image getSprite() {
        return animationManager.getSprite();
    }
}
