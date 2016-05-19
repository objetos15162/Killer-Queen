import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DesertGround here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DesertGround extends Scrolleable
{
    /**
     * Act - do whatever the DesertGround wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public DesertGround() 
    {
        setImage("Desert_Tile_2.png");
    }
    
    public void act()
    {
        scrollObjects();
        removeGround(this);
    }
}

