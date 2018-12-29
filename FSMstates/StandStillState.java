/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.FSMstates;

import game.Bodies.Zombie;
import game.FSM.FSMState;
import static java.security.AccessController.getContext;
import org.jbox2d.common.Vec2;

/**
 *
 * @author jaimik
 */
public class StandStillState extends FSMState<Zombie> {
    protected void update() {
        Zombie zombie = getContext();
        if (zombie.inRangeLeft()) {
            gotoState(new MoveLeftState());
        } else if (zombie.inRangeRight()) {
            gotoState(new MoveRightState());
        }
    }

    protected void enter() {
        Zombie zombie = getContext();
        zombie.setAngularVelocity(0);
        zombie.setLinearVelocity(new Vec2());

    }

    protected void exit() {
    }
    
}
