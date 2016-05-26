import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa el obstáculo Mushroom
 * 
 * @author (Evelyn Gómez) 
 * @version (Mayo 2016)
 */
public class Mushroom extends Obstacles
{
    /**
     * Ejecuta siempre los métodos que manda llamar.
     */
    public void act() 
    {
       setImage("Mushroom.png");
       scrollObjects();
       remove(this);
    }    
}
