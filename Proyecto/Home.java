import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Home here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Home extends Boton
{
    private StartMenu menu;
    
    public Home()
    {
        
    }
    
    /**
     * Act - do whatever the Home wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }    
    
    public void isClicked()
    {
        menu = new StartMenu();
        Greenfoot.setWorld(menu);
    }
}
