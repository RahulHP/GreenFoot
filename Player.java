import greenfoot.*;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage image1;
    private GreenfootImage image2;
    private GreenfootImage image3;
    int img_count = 0;
    int current = 0;
    int steps=0;
    boolean UP;
    boolean JUMP_FLAG ;
    /**
    private static GreenfootImage[] normal = new GreenfootImage[6];
    private static GreenfootImage[] heli = new GreenfootImage[6];;
    private static GreenfootImage[] skate = new GreenfootImage[6];;
    
    public static void initialiseImages(GreenfootImage[] array,String base_file)
    {
        array[0] = new GreenfootImage("Normal_1.png");
        array[1] = new GreenfootImage("Normal_2.png");
        array[2] = new GreenfootImage("Normal_3.png");        
        array[3] = new GreenfootImage("Normal_4.png");
        array[4] = new GreenfootImage("Normal_5.png");
        array[5] = new GreenfootImage("Normal_6.png");
    }
    *
    */
        public Player()
    {
        //initialiseImages(normal, "Normal");
        //initialiseImages(heli, "Heli");
        //initialiseImages(skate, "Skate");
        image1 = new GreenfootImage("Normal_1.png");
        image2 = new GreenfootImage("Normal_2.png");
        image3 = new GreenfootImage("Normal_3.png");
        setImage(image1);
    }
    
    public void changeImage()
    {
        if (img_count == 6)
        {
            setImage("Normal_1.png");
        }
        else
        {
            img_count++;
            setImage("Normal_3.png");
        }
        
    }
    public void act() 
    {   
        changeImage();
        if ( Greenfoot.isKeyDown("space")){
            JUMP_FLAG=true;
            
        }
        if (JUMP_FLAG){
            jump();
        }
        if ( isTouching(Enemy.class)){
              Greenfoot.setWorld(new EndGame());
        }
        
        
    
    
    
           img_count ++;
            if ( getImage() == image3 && img_count == 5 )
    {
    setImage(image1);
    img_count = 0;
    }
    else if (getImage() == image1 && img_count == 5)
    {
    setImage(image2);
    img_count = 0;
    }    
    else if (getImage() == image2 && img_count == 5)
    {
        setImage(image3);
        img_count = 0;
    }
     }
    
    
    
    public void jump(){
            
            if (getY()==164)
            {
                UP=false;
            }
            if (UP && getY() > 164 )
            {
                    setLocation(getX(),getY()-4);
                    steps++;
                }
            if (!UP && getY() < 300 )
            {
                setLocation(getX(),getY()+4);
                steps++;
            }
            if (getY()>=300)
            {
                JUMP_FLAG=false;
                UP=true;
            }
        }
}
