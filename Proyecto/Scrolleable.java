import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scrolleable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scrolleable extends Actor
{
    /**
     * Act - do whatever the Scrolleable wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }    
    
    public void scrollObjects()
    {
        move(-2);
    }
    
    public void remove(Actor actor)
    {
       if(actor.getX() <= 3)
           getWorld().removeObject(this);
    }
    
    public void removeGround(Actor actor)
    {
        
        if(actor.isAtEdge())
           getWorld().removeObject(this);
    }
}





