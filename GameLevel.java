package game.Level;

import game.CollisionListeners.PortalListener;
import game.Bodies.Portal;
import game.Bodies.Ninja;
import city.cs.engine.*;
import game.NinjaStrike;
import game.Bodies.Zombie;
import org.jbox2d.common.Vec2;

/**
 * A level of the game.
 */
public abstract class GameLevel extends World {
    private Ninja player;
    private Zombie zombie;
    
    public Ninja getPlayer() {
        return player;
    }
    
    /**
     * Populate the world of this level.
     * Child classes should this method with additional bodies.
     */
    public void populate(NinjaStrike game) {
        player = new Ninja(this);
        player.setPosition(startPosition());
        Portal door = new Portal(this);
        door.setPosition(doorPosition());
        door.addCollisionListener(new PortalListener(game));
    }
    
    /** The initial position of the player. */
    public abstract Vec2 startPosition();
    
    /** The position of the exit door. */
    public abstract Vec2 doorPosition();
    
    /** Is this level complete? */
    public abstract boolean isCompleted();
    
}
