import greenfoot.*;

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{

    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Background bg = (Background) getWorld();
        // Add your action code here.

        move(-8);
        if (isAtEdge())
        {
            bg.score++;

            bg.removeObject(this);
        }
    }    
}
