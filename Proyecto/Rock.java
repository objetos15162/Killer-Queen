import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa el obstáculo roca.
 * 
 * @author (Evelyn Gómez) 
 * @version (Mayo 2016)
 */
public class Rock extends Obstacles
{
    /**
     * Ejecuta siempre los métodos que manda llamar.
     */
    public void act() 
    {
        setImage("VolcanRock.png");
        scrollObjects();
        remove(this);
    }    
}
