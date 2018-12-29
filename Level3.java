/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Level;

import game.Bodies.Ninja;
import city.cs.engine.*;
import game.CollisionListeners.zombieCollision;
import game.NinjaStrike;
import game.Bodies.Kunai;
import game.Bodies.Zombie;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import org.jbox2d.common.Vec2;

/**
 * Level 1 of the game
 */
public class Level3 extends GameLevel implements ActionListener {
    

    private Ninja character;
    private Zombie zombie;
    private Timer timer;
    private Kunai kunai;


    /**
     * Populate the world.
     */
    @Override
    public void populate(NinjaStrike game) {
        super.populate(game);

        //Creates the ground and sets the fill to black
        Shape groundShape = new BoxShape(40, 2.5f);
        Body ground = new StaticBody(this, groundShape);
        SolidFixture fixture = new SolidFixture(ground, groundShape);
        ground.setPosition(new Vec2(0, -17f));
        ground.setFillColor(new Color(0,0,0,100));
        ground.setLineColor(new Color(0,0,0,0));
        fixture.setFriction(10);

        
        //Creates 2 walls
        Shape wallShape = new BoxShape(0.5f, 24f);
        Body wall1 = new StaticBody(this, wallShape);
        Body wall2 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-32, -5));
        wall1.setFillColor(new Color(0,0,0,100));
        wall1.setLineColor(new Color(0,0,0,0));
        
        wall2.setPosition(new Vec2(32, 5));
        wall2.setFillColor(new Color(0,0,0,100));
        wall2.setLineColor(new Color(0,0,0,0));
        
       timer = new Timer(1000, this);
       timer.setInitialDelay(200); 
       timer.start();

        

       
       
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(8, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-20, -4);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getScore() >=80;
    }
    

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (getPlayer().getScore() <= 80) {
            zombie = new Zombie(this);
            zombie.setPosition(new Vec2(-30, 10));
            zombie.addCollisionListener(new zombieCollision(getPlayer(), kunai));
            
            zombie = new Zombie(this);
            zombie.setPosition(new Vec2(30, 10));
            zombie.addCollisionListener(new zombieCollision(getPlayer(), kunai));
            
        }
               
         
    }

}