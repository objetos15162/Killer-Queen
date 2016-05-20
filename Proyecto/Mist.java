import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mist here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mist extends Decoration
{
    /**
     * Act - do whatever the Mist wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage("mist.png");
        moveDecoration();
        remove(this);
    }    
}
