package game;

import game.Background;
import game.Controllers.throwKunai;
import game.Controllers.GiveFocus;
import game.Controllers.Controller;
import game.Level.GameLevel;
import game.Level.Level4;
import game.Level.Level3;
import game.Level.Level2;
import game.Level.Level1;
import game.Bodies.Ninja;
import city.cs.engine.*;
import game.Bodies.Zombie;
import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.JFrame;

/**
 * A world with some bodies.
 */
public class NinjaStrike {

    /** The World in which the bodies move and interact. */
    private GameLevel world;

    /** A graphical display of the world (a specialised JPanel). */
    private UserView view;
    
    private int level;
    
    private Controller controller;
    
    private Ninja ninja;
    
    private Zombie zombie;
    
    private throwKunai kunaiThrow;
    
    private SoundClip gameMusic;
    
    


    
    /** Initialise a new Game. */
    public NinjaStrike() {
        // make the world
        level = 1;
        world = new Level1();
        world.populate(this);
        // make a view
        view = new Background(world, 1280, 720, world.getPlayer(), this);

        // uncomment this to draw a 1-metre grid over the view
        //view.setGridResolution(1);

        // display the view in a frame
        JFrame frame = new JFrame("Ninja Strike");

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));
        //JFrame debugView = new DebugViewer(world, 1280, 720);
        kunaiThrow = new throwKunai(world, view, getPlayer());
        view.addMouseListener(kunaiThrow);
        controller = new Controller(world.getPlayer());
        frame.addKeyListener(controller);
        
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container control = new gameGUI(this);
        frame.add(control, BorderLayout.WEST);
        
        frame.pack();
        frame.setVisible(true);
            
            try {
            gameMusic = new SoundClip("data/backgroundMusic.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
            }
  
        
    
        // start!
        world.start();
    }
    
    public void pause() {
        world.stop();
    }
    
    public void play() {
        world.start();
    }
    
    /** The player in the current level. */
    public Ninja getPlayer() {
        return world.getPlayer();
    }
    
    /** Is the current level of the game finished? */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }
    
    /** Advance to the next level of the game. */
    public void goNextLevel() {
        world.stop();
        Ninja oldNinja = world.getPlayer();
        if (level == 4) {
            System.exit(0);
        } else if (level == 1) {
            gameMusic.stop();
            level++;
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
            view.setWorld(world);
            world.getPlayer().setScore(oldNinja.getScore());
            world.getPlayer().setHealth(oldNinja.getHealth());
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            kunaiThrow.changeKunai(world, view, world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            
            try {
                gameMusic = new SoundClip("data/level2music.wav");   // Open an audio input stream
                gameMusic.loop();  // Set it to continous playback (looping)
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                System.out.println(e);
            }

            world.start();
        } else if (level == 2) {
            gameMusic.stop();
            level++;
            // get a new world
            world = new Level3();
            // fill it with bodies
            world.populate(this);
            view.setWorld(world);
            world.getPlayer().setScore(oldNinja.getScore());
            world.getPlayer().setHealth(oldNinja.getHealth());
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            kunaiThrow.changeKunai(world, view, world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            try {
                gameMusic = new SoundClip("data/level3music.wav");   // Open an audio input stream
                gameMusic.loop();  // Set it to continous playback (looping)
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                System.out.println(e);
            }
            
            world.start();
        } else if (level == 3) {
            gameMusic.stop();
            level++;
            // get a new world
            world = new Level4();
            // fill it with bodies
            world.populate(this);
            view.setWorld(world);
            world.getPlayer().setScore(oldNinja.getScore());
            world.getPlayer().setHealth(oldNinja.getHealth());
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            kunaiThrow.changeKunai(world, view, world.getPlayer());
            // show the new world in the view
            try {
                gameMusic = new SoundClip("data/level4music.wav");   // Open an audio input stream
                gameMusic.loop();  // Set it to continous playback (looping)
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
                System.out.println(e);
            }
            world.start();
        }
            
    }

    public GameLevel getWorld() {
        return world;
    }
    
    

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    

    /** Run the game. */
    public static void main(String[] args) {
        new NinjaStrike();
    }
}
