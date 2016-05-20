import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Skulls here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Skull extends Decoration
{
    /**
     * Act - do whatever the Skulls wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage("skull.png");
        scrollObjects();
        remove(this);
    }    
}
