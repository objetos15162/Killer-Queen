import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa el obstáculo piedra,
 * 
 * @author (Evelyn Gómez) 
 * @version (Mayo 2016)
 */
public class Stone extends Obstacles
{
    /**
     * Ejecuta siempre los métodos que manda llamar.
     */
    public void act() 
    {
       setImage("Stone.png");
       scrollObjects();
       remove(this);
    }    
}
