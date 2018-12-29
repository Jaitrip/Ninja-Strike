package game.Bodies;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.Color;

/**
 * @author      Jaimik, Tripathi, Jaimik.Tripathi@city.ac.uk
*/

public class HealthPack extends DynamicBody {
    
    /**
    * States the shape of the body as a new circle shape
    */
    private static final Shape shape = new CircleShape(0.2f);
    
    /**
    * Creates health pack and adds it to the world.
    * <p>
    * Typical use for this method is: spawned into the world and gives a player more health
    *
    * @param
    * 
    */
    
    public HealthPack(World world) {
        super(world, shape);
        setFillColor(Color.green);
    }
}
