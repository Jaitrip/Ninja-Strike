/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.CollisionListeners;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Bodies.Ninja;
import game.Bodies.Zombie;
import game.Bodies.robotBoss;

/**
 *
 * @author jaimik
 */
public class kunaiListener implements CollisionListener{
    
    /**
    * creates the ninja variable
    */
    private Ninja ninja;
    
    /**
    * Constructor for class
     * <p>
     * takes ninja for the constructor 
     *
     * @param  takes ninja as a parameter 
     */
    public kunaiListener(Ninja ninja) {
        this.ninja = ninja;

    }
    
    /**
    * Collision Listener
     * <p>
     * when a collision occurs, it its between the kunai and a zombie then both bodies are destroyed
     * If the kunai hits anything else then the kunai body is destroyed
     * If it hits the robot boss both the boss and kunai are destroyed
     * @param  takes a collision event e.
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Zombie) {
            e.getOtherBody().destroy();
            e.getReportingBody().destroy();
            ninja.increaseScore();
        } else if (e.getOtherBody() instanceof Ninja == false){
            e.getReportingBody().destroy();
        } else if (e.getOtherBody() instanceof robotBoss) {
            e.getOtherBody().destroy();
            e.getReportingBody().destroy();
        }
        
        
        
    }
}
