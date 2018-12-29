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
public class MoveRightState extends FSMState<Zombie> {
        protected void update() {
        Zombie zombie= getContext();
        if (zombie.inRangeLeft()) {
            gotoState(new MoveLeftState());
            
           
        } else if (!zombie.inRange()) {
            gotoState(new StandStillState());
        
        } else {
            zombie.setAngularVelocity(-4);
  
             
        }
    }

    protected void enter() {
        Zombie zombie = getContext();
        zombie.setAngularVelocity(-2);

    }
    
    protected void exit() {}
}
    

