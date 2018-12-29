/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Bodies;

import city.cs.engine.*;
import game.FSMstates.StandStillState;
import game.NinjaStrike;
import game.Level.GameLevel;
import game.FSM.FSM;

/**
 *
 * @author jaimik
 */
public class Zombie extends Walker implements StepListener {
    
    /**
    * States the shape of the zombie body
    */
    public static final Shape zombieShape = new PolygonShape(-1.18f,1.29f, -0.45f,1.97f, 1.3f,1.55f, 1.05f,-0.21f, 0.12f,-2.43f, -1.52f,-2.41f);
    
    /**
    * States the image of the zombie body
    */
    private static final BodyImage imageZombie = new BodyImage("data/Idlez.png", 5f);
    
    /**
    * States the range for the finite state machine
    */
    public static final float RANGE = 50;
    
    /**
    * Creates an fsm for the zombie
    */
    private FSM<Zombie> fsm;
    
    /**
    * Declares the game level world
    */
    GameLevel world;
    
    /**
    * Initalises the zombie
     * <p>
     * Initialises the zombie, adds the image and adds the fsm
     *
     * @param  World 
     */
    public Zombie(World world) {
        super(world, zombieShape);
        addImage(imageZombie);
        this.world = (GameLevel)world;
        fsm = new FSM<Zombie>(this, new StandStillState());
        
        world.addStepListener(this);

        
        
    }
     
    /**
    * detects if in range left
     * <p>
     * gets player and identifies if the zombie is in range with the player.
     *
     * @return returns gap
     */
    public boolean inRangeLeft() {
        Body a = world.getPlayer();
        float gap = getPosition().x - a.getPosition().x;
        return gap < RANGE && gap > 0;
    }
    
    /**
    * detects if in range right
     * <p>
     * gets player and identifies if the zombie is in range with the player.

     * @return returns gap
     */
    public boolean inRangeRight() {
        Body a = world.getPlayer();
        float gap = getPosition().x - a.getPosition().x;
        return gap > -RANGE && gap < 0;
    }
    
    /**
    * returns if in range or in range right
     * <p>
     * returns if in range or in range right
     *
     * @return returns gap
     */
    public boolean inRange() {
        return inRangeLeft() || inRangeRight();
    }
    
    /**
    * updates the fsm
     * <p>
     * updates the fsm
     *
     * @param  step event e 
     */
    public void preStep(StepEvent e) {
        fsm.update();
    }
    
    public void postStep(StepEvent e) {}
}

    
  