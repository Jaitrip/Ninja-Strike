/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Bodies;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.Walker;
import city.cs.engine.World;

/**
 *
 * @author jaimik
 */
public class robotBoss extends Walker {
    
    /**
    * States the shape of the Boss body
    */    
    public static final Shape robotShape = new PolygonShape(-0.06f,4.26f, -1.7f,3.78f, -3.89f,-2.18f, -3.05f,-4.71f, 1.65f,-4.68f, 3.55f,1.35f);

    /**
    * States the image of the boss
    */
    private static final BodyImage imageRobot = new BodyImage("data/robot.gif", 10f);
    
    /**
    * States the health of the boss
    */
    private int health = 500;
    
    
    /**
    * adds robot to the world with the shape and image
     * <p>
     * 
     *
     * @param  Take world
     */
    public robotBoss(World world) {
        super(world, robotShape);
        addImage(imageRobot);
    }

    /**
    * Getter for health
     * <p>
     * returns the health
     *
     * @return health
     */
    public int getHealth() {
        return health;
    }

    /**
    * Setter for health.
     * <p>
     * Sets health
     *
     * @param  takes health
     */
    public void setHealth(int health) {
        this.health = health;
    }
    
    
    
    
}
    
