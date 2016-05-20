import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    private boolean active;
    
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        active = true;
        setImage("bullet_1.png");
        move(2);
        removeEnemies();
        if(this.isAtEdge())
        {
            getWorld().removeObject(this);
            
        }
        
    }    
    
    
    private void removeEnemies()
    {
        if(isTouching(Enemies.class) && active == true)
        {
            removeTouching(Enemies.class);
            active = false;
            this.setLocation(getWorld().getWidth(), 0);
        }
            
    }
}