import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ground extends Scrolleable
{
    /**
     * Act - do whatever the Ground wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setGroundImages();
        scrollObjects();
        removeGround(this);
    } 
    
    private void setGroundImages()
    {
        if(getWorld().getClass() == Level1.class)
        {
            setImage("volcan_ground.png");
        }
        else if(getWorld().getClass() == Level2.class)
        {
            setImage("desert_ground.png");
        }
        else if(getWorld().getClass() == Level3.class)
        {
            setImage("winter_ground.png");
        }
        else if(getWorld().getClass() == Level4.class)
        {
            setImage("forest_ground.png");
        }
    }
}
