import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa el obstáculo Crystal.
 * 
 * @author (Evelyn Gomez) 
 * @version (Mayo 2016)
 */
public class Crystal extends Obstacles
{
    /**
     * Ejecuta siempre los métodos que manda llamar.
     */
    public void act() 
    {
        setImage("Crystal.png");
        scrollObjects();
        remove(this);
    }    
}
