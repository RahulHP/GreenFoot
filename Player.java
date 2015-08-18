import greenfoot.*;

public class Player extends Actor
{
    private GreenfootImage image1;
    private GreenfootImage image2;
    private GreenfootImage image3;
    int img_count = 0;
    int current = 0;
    int steps=0;
    int base_y_location = 300;
    boolean UP;
    boolean JUMP_FLAG ;
    Background bg = (Background) getWorld();
    
    public Player()
    {
        image1 = new GreenfootImage("Normal_1.png");
        image2 = new GreenfootImage("Normal_2.png");
        image3 = new GreenfootImage("Normal_3.png");
        setImage(image1);
    }
    
      
   public void act(){
        if ( Greenfoot.isKeyDown("space")){
            JUMP_FLAG=true;
        }
        if (JUMP_FLAG){
            jump();
        }
        moving_image();
        bonus();
        is_chance();
        eat();
   }
   
   public void eat(){
       Background bg = (Background) getWorld();
       if ( isTouching(Points.class)){
           removeTouching(Points.class);
           bg.score ++;
       }
   }
   
   public void is_chance(){
       Background bg = (Background) getWorld();
       if ( isTouching(Enemy.class)){
           if ( bg.lifes == 0){
               Greenfoot.stop(); 
           }
           else{
               removeTouching(Enemy.class); 
               bg.lifes --;
           }    
        }
    }
   
   public void bonus(){
       Background bg = (Background) getWorld();
       if ( isTouching(Life.class)){
           bg.lifes ++;
           removeTouching(Life.class);
       }
  }

   public void moving_image(){
                img_count ++;
                if ( getImage() == image3 && img_count == 5 && !JUMP_FLAG)
                {
                       setImage(image1);
                       img_count = 0;
                }
                else if (getImage() == image1 && img_count == 5 && !JUMP_FLAG)
                {
                       setImage(image2);
                       img_count = 0;
                }    
                else if (getImage() == image2 && img_count == 5 && !JUMP_FLAG)
                {
                       setImage(image3);
                       img_count = 0;
                }
   }
    
    
    
   public void jump(){         
      
            if (getY()==160)
            {
                UP=false;
            }
            if (UP && getY() > 160 )
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
                setLocation(getX(), base_y_location);
                JUMP_FLAG=false;
                UP=true;
            }
     
   }
}
