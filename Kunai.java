/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Bodies;

import city.cs.engine.*;

/**
 * Kunai
 * @author Jaimik Tripathi Jaimik.Tripathi@city.ac.uk
 */
public class Kunai extends DynamicBody {
    
    /**
    * States the shape of the kunai body
    */
    public static final Shape kunaiShape = new PolygonShape(-0.012f,0.995f, -0.175f,-0.08f, -0.137f,-0.935f, -0.005f,-0.992f, 0.138f,-0.93f, 0.19f,-0.085f);
    
    /**
    * States the image the body will have
    */
    private static final BodyImage kunaiImage = new BodyImage("data/Kunai.png", 2f);
    
    /**
    * Adds the kunai to the world.
     * <p>
     * Used for when a kunai is spawned during shooting, an image is put on the body
     *
     * @param  A description of all the method's variables.
     * @return Description of what the method returns.
     */
    public Kunai(World world) {
        super(world, kunaiShape);
        addImage(kunaiImage);

        
       
    }
}
