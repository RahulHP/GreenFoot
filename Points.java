import greenfoot.*;

/**
 * Write a description of class Points here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Points extends Actor
{   
    public boolean flag = true;
    public int count = 0;
    public int count1 = 0;
    public void act() 
    {
       if (count <= 10 && count1 < 70){
           setLocation(getX(), getY()+3);
           count ++;
           count1 = 0;
       }
       if (count >10 && count1 < 70 ){
           setLocation(getX(), getY()-3);
           count ++;
           count1 = 0;
           if ( count == 20 ){
               count = 0;
           }
       }
       count1 ++;
       move(-4);
       Background bg = (Background) getWorld();
       if ( isAtEdge()){
           bg.removeObject(this);
       }
    }    
}
