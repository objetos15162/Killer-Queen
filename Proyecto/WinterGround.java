import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinterGround here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinterGround extends Scrolleable
{
    /**
     * Act - do whatever the WinterGround wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public WinterGround() 
    {
        setImage("Winter_Tile.png");
    } 
    
    public void act()
    {
       scrollObjects();
       removeGround(this); 
    }
}
