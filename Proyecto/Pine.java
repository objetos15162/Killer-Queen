import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pine extends Decoration
{
    /**
     * Act - do whatever the Pine wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage("pine_tree.png");
        scrollObjects();
        remove(this);
    }    
}
