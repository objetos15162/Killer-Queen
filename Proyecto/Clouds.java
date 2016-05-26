import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa la decoración Nubes.
 * 
 * @author (Evelyn Gomez) 
 * @version (Mayo 2016)
 */
public class Clouds extends Decoration
{
    /**
     * Ejecuta siempre los métodos que manda llamar.
     */
    public void act() 
    {
        setImage("clouds.png");
        moveDecoration();
        remove(this);
    }    
}
