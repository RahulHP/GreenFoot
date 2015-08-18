import greenfoot.*;
public class Background extends World
{
    public int score = 0;
    public int lifes = 0; 
    int count = 0;
    private static final GreenfootImage bgImage = new GreenfootImage("background.png");
    private static final int scrollSpeed = 1;
    private int count1 = 0;
    private GreenfootImage scrollingImage;
    private int scrollPosition = 0;

    public Background()
    {    
        
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
        showText("Score:"+score,600,100);
        showText("Lifes:"+lifes,600,120);
        count ++;
        add_objects();
        add_flies();
    }
    
    public void add_objects(){
        if (Greenfoot.getRandomNumber(30)==1)
        {
            if (count > 70)
            {
                addObject(new Enemy(),getWidth()-1,300);
                count=0;
                count1 ++;
            }
            if ( count1 == 3 )
            {
                addObject(new Life(),getWidth()-50,150);
                count1 = 0;
            }   
        }
    }
    
    public void add_flies(){
        if (Greenfoot.getRandomNumber(150)==1){
            addObject(new Points(),getWidth()-1,100);
        }
        if (Greenfoot.getRandomNumber(150)==2){
            addObject(new Points(),getWidth()-1,200);
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
