/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.FSMstates;

import game.Bodies.Zombie;
import game.FSM.FSMState;
import org.jbox2d.common.Vec2;

/**
 *
 * @author jaimik
 */
public class MoveLeftState extends FSMState<Zombie> {
    
    /**
    * Updates the finite state machine
     * <p>
     * if the zombie is in range right it will move to move right state
     * if not in range then if will stand still
     * else the zombie moves towards the player
     */
    protected void update() {
        Zombie zombie = getContext();
        if (zombie.inRangeRight()) {
            gotoState(new MoveRightState());
            
        } else if (!zombie.inRange()) {
            gotoState(new StandStillState());
        } else {
            zombie.setAngularVelocity(4);
        
        }
    }

    /**
    * enters the finite state machine
     * <p>
     * zombie moves with angular velocity 2
     * else the zombie moves towards the player
     */
    protected void enter() {
        Zombie zombie = getContext();

        zombie.setAngularVelocity(2);
        
    }
    
    protected void exit() {}
}

    
