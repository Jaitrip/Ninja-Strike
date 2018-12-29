/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Level;

import game.CollisionListeners.robotBossListener;
import game.Bodies.robotBoss;
import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.StaticBody;
import game.NinjaStrike;
import java.awt.Color;
import org.jbox2d.common.Vec2;

/**
 *
 * @author jaimik
 */
public class Level4 extends GameLevel {

    private robotBoss boss;
    /**
     * Populate the world.
     */
    @Override
    public void populate(NinjaStrike game) {
        super.populate(game);

        // make the ground
        Shape groundShape = new BoxShape(40, 3.3f);
        Body ground = new StaticBody(this, groundShape);
        SolidFixture fixture = new SolidFixture(ground, groundShape);
        ground.setPosition(new Vec2(0, -17f));
        ground.setFillColor(new Color(0,0,0,0));
        ground.setLineColor(new Color(0,0,0,0));
        fixture.setFriction(10);
        
        Shape wallShape = new BoxShape(0.5f, 24f);
        Body wall1 = new StaticBody(this, wallShape);
        Body wall2 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-32, -5));
        wall1.setFillColor(new Color(0,0,0,0));
        wall1.setLineColor(new Color(0,0,0,0));
        
        wall2.setPosition(new Vec2(32, 5));
        wall2.setFillColor(new Color(0,0,0,0));
        wall2.setLineColor(new Color(0,0,0,0));
        
        boss = new robotBoss(this);
        boss.setPosition(new Vec2(-28, -6));
        boss.addCollisionListener(new robotBossListener(getPlayer(), boss));
        boss.startWalking(15);

        

      
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(2, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(10, -3);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getScore() >= 81;
    }

}