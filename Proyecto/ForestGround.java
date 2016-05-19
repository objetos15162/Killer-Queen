import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ForestGround here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ForestGround extends Scrolleable
{
    /**
     * Act - do whatever the ForestGround wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ForestGround() 
    {
        setImage("Bosque.png");
    }  
    
    public void act()
    {
        scrollObjects();
        removeGround(this);
    }
}
