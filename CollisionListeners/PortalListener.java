package game.CollisionListeners;

import game.Bodies.Ninja;
import city.cs.engine.*;
import game.NinjaStrike;

/**
 * Listener for collision with a door.  When the player collides with a door,
 * if the current level is complete the game is advanced to the next level. 
 */
public class PortalListener implements CollisionListener {
    private NinjaStrike game;
    
    public PortalListener(NinjaStrike game) {
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        Ninja player = game.getPlayer();
        boolean levelDone = game.isCurrentLevelCompleted();
        System.out.println("level status is" + levelDone);
        System.out.println(game.getPlayer().getScore());
        if (e.getOtherBody() == player && game.isCurrentLevelCompleted()) {
            System.out.println("Going to next level...");
            game.goNextLevel();
        }
    }
}
