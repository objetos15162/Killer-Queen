import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TreeForest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TreeForest extends Decoration
{
    /**
     * Act - do whatever the TreeForest wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage("treeForest.png");
        scrollObjects();
        remove(this);
    }    
}
