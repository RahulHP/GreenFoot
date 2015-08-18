import greenfoot.*;

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends World
{
    public int score=0;
    int count=0;
    private static final GreenfootImage bgImage = new GreenfootImage("background.png");
    private static final int scrollSpeed = 1;
 
    private GreenfootImage scrollingImage;
    private int scrollPosition = 0;

     

    /**
     * Constructor for objects of class Background.
     * 
     */
    public Background()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 400, 1); 
        GreenfootImage background = new GreenfootImage(800, 400);
        scrollingImage = getScrollingImage(800, 400);
        background.drawImage(scrollingImage, 0, 0);
        setBackground(background);

        addObject(new Player(),100,300);
        
         
    }
    public void act()
    {
         if(scrollSpeed > 0 && scrollPosition <= 0) {
            scrollPosition = getWidth();
        }
        if(scrollSpeed < 0 && scrollPosition >= getWidth()) {
            scrollPosition = 0;
        }
        scrollPosition -= scrollSpeed;
        paint(scrollPosition);
        showText(""+score,600,100);
        count++;
        if (Greenfoot.getRandomNumber(30)==1)
        {
            if (count > 70)
            {
                addObject(new Enemy(),getWidth()-1,300);
                count=0;
            }
            
        }
    }
    /**
     * Paint scrolling image at given position and make sure the rest of
     * the background is also painted with the same image.
     */
    private void paint(int position)
    {
        GreenfootImage bg = getBackground();
        bg.drawImage(scrollingImage, position, 0);
        bg.drawImage(scrollingImage, position - scrollingImage.getWidth(), 0);
    }
 
    /**
     * Returns an image with the given dimensions.
     */
    private GreenfootImage getScrollingImage(int width, int height)
    {
        GreenfootImage image = new GreenfootImage(width, height);
        for(int x = 0; x < width; x += bgImage.getWidth()) {
            for(int y = 0; y < height; y += bgImage.getHeight()) {
                image.drawImage(bgImage, x, y);
            }
        }
        return image;
    } 
}
