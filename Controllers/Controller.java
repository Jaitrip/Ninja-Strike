package game.Controllers;

import game.Bodies.Ninja;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Key handler to control an Walker.
 */
public class Controller extends KeyAdapter {
    //initialises jumping speed
    private static final float JUMPING_SPEED = 10;
    //initialises walking speed  m
    private static final float WALKING_SPEED = 7;
    private static final BodyImage imageR = new BodyImage("data/running2.gif", 5f);
    private static final BodyImage imageI = new BodyImage("data/Idle.png", 5f);
    private static final BodyImage imageL = new BodyImage("data/runningL.gif", 5f);
    private static final BodyImage imageJ = new BodyImage("data/jump.gif", 5f);
    private Ninja body;
    private SoundClip jump;

    public Controller(Ninja body) {
        this.body = body;
    }
    
    /**
     * Handle key press events for walking and jumping.
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_UP) { // SPACE = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
                body.removeAllImages();
                body.addImage(imageJ);
                
                    try {
                    jump = new SoundClip("data/jump.wav");   // Open an audio input stream
                    jump.play();
                } catch (UnsupportedAudioFileException|IOException|LineUnavailableException f) {
                    System.out.println(f);
                }
      
            }

        } else if (code == KeyEvent.VK_LEFT) {
            body.startWalking(- WALKING_SPEED); // LEFT ARROW = walk left
            body.removeAllImages();
            body.addImage(imageL);

                
        } else if (code == KeyEvent.VK_RIGHT) {
            body.startWalking(WALKING_SPEED); // RIGHT ARROW = walk right
            body.removeAllImages();
            body.addImage(imageR);

        } 
    }
    
    /**
     * Handle key release events (stop walking).
     * @param e description of the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            body.stopWalking();
            body.removeAllImages();
            body.addImage(imageI);
        } else if (code == KeyEvent.VK_RIGHT) {
            body.stopWalking();
            body.removeAllImages();
            body.addImage(imageI);
        }
    }
    
    public void setBody(Ninja body) {
        this.body = body;
    }
}
