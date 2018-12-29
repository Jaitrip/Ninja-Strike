package game.CollisionListeners;

import game.Bodies.Ninja;
import city.cs.engine.*;

/**
 * Collision listener that allows the character to collect things.
 */
public class Pickup implements CollisionListener {
    private Ninja character;
    
    public Pickup(Ninja bird) {
        this.character = bird;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == character) {
            character.setHealth(character.getHealth()+50);
            e.getReportingBody().destroy();
        }
    }
    
}
