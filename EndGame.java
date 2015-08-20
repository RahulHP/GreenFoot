import greenfoot.*;

/**
 * Write a description of class EndGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndGame extends World
{
	public static GreenfootImage gameover = new GreenfootImage("gameover.png");
    /**
     * Constructor for objects of class EndGame.
     * 
     */
    public EndGame()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 400, 1); 
        drawImage (gameover,400,100);
        addObject (new Restart(),200,300);
        addObject (new Score_Counter(),400,300);
        
    }
}