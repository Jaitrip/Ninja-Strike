/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.Bodies.Ninja;
import city.cs.engine.UserView;
import city.cs.engine.World;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author jaimik
 */
public class Background extends UserView {

    private final Image background1, background2, background3, background4;
    private NinjaStrike game;
    private Ninja ninja;
    
    public Background(World world, int width, int height, Ninja ninja, NinjaStrike game) {
        super(world, width, height);
        this.game = game;
        this.background1 = new ImageIcon("data/background.jpg").getImage();
        this.background2 = new ImageIcon("data/back2.jpg").getImage();
        this.background3 = new ImageIcon("data/back3.jpg").getImage();
        this.background4 = new ImageIcon("data/back4.jpg").getImage();
        this.ninja = ninja;
    }
    
    @Override
    protected void paintBackground(Graphics2D g) {
        if (game.getLevel() == 1) {
            g.drawImage(background1, 0, 0, this);
        } else if (game.getLevel() == 2) {
            g.drawImage(background2, 0, 0, this);
        } else if (game.getLevel() == 3) {
            g.drawImage(background3, 0, 0, this);
        } else if (game.getLevel() == 4) {
            g.drawImage(background4, 0, 0, this);
        }
        
        
    }
    
    @Override
    protected void paintForeground(Graphics2D g) {
       
        if (game.getLevel() == 1) {
            g.setColor(Color.black);
            g.drawString("Health" + "  " + game.getPlayer().getHealth(), 0, 10);
            g.drawString("Score" + "  " + game.getPlayer().getScore(), 1200, 10);
        } else if (game.getLevel() == 2) {
            g.setColor(Color.white);
            g.drawString("Health" + " " + game.getPlayer().getHealth(), 0, 10);
            g.drawString("Score" + " " + game.getPlayer().getScore(), 1200, 10);
        } else if (game.getLevel() == 3) {
            g.setColor(Color.black);
            g.drawString("Health" + " " + game.getPlayer().getHealth(), 10, 10);
            g.drawString("Score" + " " + game.getPlayer().getScore(), 1200, 10);
        } else if (game.getLevel() == 4) {
            g.setColor(Color.white);
            g.drawString("Health" + " " + game.getPlayer().getHealth(), 10, 10);
            g.drawString("Score" + " " + game.getPlayer().getScore(), 1200, 10);
        }
        
    }
}
