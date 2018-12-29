package game.Controllers;


import city.cs.engine.DynamicBody;
import city.cs.engine.World;
import city.cs.engine.WorldView;
import game.CollisionListeners.kunaiListener;
import game.Bodies.Kunai;
import game.Bodies.Ninja;
import game.Bodies.Zombie;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Timer;
import org.jbox2d.common.Vec2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jaimik
 */
public class throwKunai extends MouseAdapter{
    
    /**
    * creates a variable view of type world view
    */
    private WorldView view;
    /**
    * creates a variable ninja of type Ninja
    */
    private Ninja ninja;
    
    /**
    * creates a variable world of type World
    */
    private World world;
    /**
    * creates a variable mousePosition of type vec2
    */
    private Vec2 mousePosition;
    /**
    * creates a variable ninjaPosition of type vec2
    */
    private Vec2 ninjaPosition;
    /**
    * creates a variable arc of type vec2
    */
    private Vec2 arc;


    /**
    * Constructor for throw kunai
     * <p>
     * Constructor for throw kunai
     *
     * @param  takes world, view and ninja
     */
    public throwKunai(World world, WorldView view, Ninja ninja) {
        this.world = world;
        this.view = view;
        this.ninja = ninja;

    }
    
    /**
    * Sets variables
     * <p>
     * changes variables of world, view and ninja 
     *
     * @param  takes world, view and ninja
     */
    public void changeKunai(World world, WorldView view, Ninja ninja) {
        this.world = world;
        this.view = view;
        this.ninja = ninja;
    }
    
            

    
    
    
    
    /**
    * Shoots a kunai
     * <p>
     * when the mouse is pressed a new kunai is spawned and shot to the mouse
     * position from the player with an arc and a collision listener is added to it
     * @param  takes mouse event e
     */
    @Override
    public void mousePressed(MouseEvent e) {
            DynamicBody kunai = new Kunai(view.getWorld());
            mousePosition = view.viewToWorld(e.getPoint());
            ninjaPosition = new Vec2(ninja.getPosition().x, ninja.getPosition().y+1);
            arc = mousePosition.sub(ninjaPosition);
            arc.normalize();
            kunai.setPosition(new Vec2(ninja.getPosition().add(arc).mul(1)));
            kunai.applyImpulse(arc.mul(15));
            kunai.setAngleDegrees(-90);
            kunai.addCollisionListener(new kunaiListener(ninja));


    }

}
