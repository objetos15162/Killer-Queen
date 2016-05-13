import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HelpWindow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpWindow extends World
{
    private Home home;
    /**
     * Constructor for objects of class HelpWindow.
     * 
     */
    public HelpWindow()
    {    
         super(850, 500, 1); 
         setBackground("ayuda.png");
         this.getBackground().scale(850, 500);
         home = new Home();
         addObject(home,773,444);
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(home))
        {
            home.isClicked();
        }
    }
}
