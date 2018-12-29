/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.CollisionListeners;


import game.Bodies.Ninja;
import city.cs.engine.*;
import game.Bodies.Kunai;

/**
 *
 * @author jaimik
 */
public class zombieCollision implements CollisionListener{
    private Ninja character;
    private Kunai kunai;

    public zombieCollision(Ninja character, Kunai kunai) {
        this.character = character;
        this.kunai = kunai;
    }
    //Collision Listener
    @Override
    public void collide(CollisionEvent e) {
        
        //If the character collides with the reporting body it loses health
        if (e.getOtherBody() == character) {


                character.decreaseHealth();
                System.out.println("Player Collision");
                
            
            
            //If the character has 0 health then it will be destroyed 
            if (character.getHealth() <= 0) {
                e.getOtherBody().destroy();
            }
        
        }

        
    }

    
    
    
}
