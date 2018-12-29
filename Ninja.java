package game.Bodies;

import city.cs.engine.*;

/**
 * Ninja
 * @author Jaimik Tripathi Jaimik.Tripathi@city.ac.uk
 */
public class Ninja extends Walker {

    /**
    * States the shape of the ninja body
    */
    private static final Shape shape = new PolygonShape(
            -1.28f,2.45f, 0.87f,2.48f, 1.18f,1.11f, 1.31f,-2.47f, -1.25f,-2.5f);

    /**
    * States the image the body will have
    */
    private static final BodyImage image =
        new BodyImage("data/Idle.png", 5f);

    /**
    * The score of the player
    */
    private int score;
    
    /**
    * The health of the ninja
    */
    private int health;

    
    /**
    * Adds the Ninja to the world.
     * <p>
     * Used for when player is spawned, an image is put on the body,character given score 0 and health 100
     *

     */
    public Ninja(World world) {
        super(world, shape);
        addImage(image);
        score = 0;
        health = 100;
    }

    
    /**
    * Gets score.
     * <p>
     * getter method that returns score
     *
     * @return returns score
     */
    public int getScore() {
        return score;
    }

    /**
    * Sets score.
     * <p>
     * Setter method that sets score
     *

     */
    public void setScore(int score) {
        this.score = score;
    }
    
    
    /**
    * Increases Score.
     * <p>
     * Increments score by one
     *

     */
    public void increaseScore() {
        score++;
    }

    /**
    * Gets Health.
     * <p>
     * getter method that returns score
     *
     */
 
    public int getHealth() {
        return health;
    }

    /**
    * Sets health.
     * <p>
     * Setter method that sets health
     *

     */
    public void setHealth(int health) {
        this.health = health;
    }
    
    /**
    * Decrements health.
     * <p>
     * decreases health by 15 and prints the new health
     */
    //Decreases health
    public void decreaseHealth() {
        health = health - 15;
        System.out.println("health is" + health);
    }
    
    
}
