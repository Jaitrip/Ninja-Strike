/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.CollisionListeners;

import game.Bodies.robotBoss;
import game.Bodies.Ninja;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 *
 * @author jaimik
 */
public class robotBossListener implements CollisionListener {
    
    private Ninja character;
    private robotBoss boss;

    public robotBossListener(Ninja character, robotBoss boss) {
        this.character = character;
        this.boss = boss;
    }
    //Collision Listener
    @Override
    public void collide(CollisionEvent e) {
        
        //If the character collides with the reporting body it loses health
        if (e.getOtherBody() == character) {

                e.getOtherBody().destroy();
                System.out.println("Player Collision");

            
                    
        }

    }
    
}
