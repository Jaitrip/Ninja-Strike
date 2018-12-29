package game.Level;

import game.CollisionListeners.zombieCollision;
import game.Bodies.Zombie;
import game.Bodies.HealthPack;
import game.Bodies.Ninja;
import city.cs.engine.*;
import game.CollisionListeners.kunaiListener;
import game.NinjaStrike;
import game.Bodies.Kunai;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Timer;
import org.jbox2d.common.Vec2;

/**
 * Level 1 of the game
 */
public class Level1 extends GameLevel implements ActionListener {
    
    private static final int NUM_KILLS = 10;
    private Zombie zombie;
    private SoundClip zombieSound;
    private Ninja character;
    private HealthPack healthP;
    private Timer timer;
    private Kunai kunai;
    private SoundClip level1music;
    
    
    

    /**
     * Populate the world.
     */
            
    @Override
    public void populate(NinjaStrike game) {
        super.populate(game);
        
        
        
        //Creates the ground and sets the fill to black
        Shape groundShape = new BoxShape(40, 3.3f);
        Body ground = new StaticBody(this, groundShape);
        SolidFixture fixture = new SolidFixture(ground, groundShape);
        ground.setPosition(new Vec2(0, -17f));
        ground.setFillColor(new Color(0,0,0,0));
        ground.setLineColor(new Color(0,0,0,0));
        fixture.setFriction(10);
        
        
        //Creates two platforms
        Shape platformShape = new BoxShape(10.5f, 0.5f);
        Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-21, 3f));
        platform1.setFillColor(new Color(0,0,0,0));
        platform1.setLineColor(new Color(0,0,0,0));
        Body platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(21, 3f));
        platform2.setFillColor(new Color(0,0,0,0));
        platform2.setLineColor(new Color(0,0,0,0));
        
        //Creates 2 walls
        Shape wallShape = new BoxShape(0.5f, 24f);
        Body wall1 = new StaticBody(this, wallShape);
        Body wall2 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-32, -5));
        wall1.setFillColor(new Color(0,0,0,0));
        wall1.setLineColor(new Color(0,0,0,0));
        
   
        
        wall2.setPosition(new Vec2(32, 5));
        wall2.setFillColor(new Color(0,0,0,0));
        wall2.setLineColor(new Color(0,0,0,0));

       
       timer = new Timer(2000, this);
       timer.setInitialDelay(100); 
       timer.start();
      
     
       
           
       
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(2, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-20, -3);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getScore() >= 20;
    }
    

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (getPlayer().getScore() <= 20) {
            
        
            zombie = new Zombie(this);
            zombie.setPosition(new Vec2(-30, 10));
            zombie.addCollisionListener(new zombieCollision(getPlayer(), kunai));
            
            zombie = new Zombie(this);
            zombie.setPosition(new Vec2(30, 10));
            zombie.addCollisionListener(new zombieCollision(getPlayer(), kunai));
        }
         
    }
}
