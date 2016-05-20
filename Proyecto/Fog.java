import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mountain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fog extends Decoration
{
    /**
     * Act - do whatever the Mountain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage("fog.png");
        moveDecoration();
        remove(this);
    }    
}
