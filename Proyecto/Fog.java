import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa la decoración Niebla.
 * 
 * @author (Evelyn Gomez) 
 * @version (Mayo 2016)
 */
public class Fog extends Decoration
{
    /**
     * Ejecuta siempre los mpetodos que manda llamar.
     */
    public void act() 
    {
        setImage("fog.png");
        moveDecoration();
        remove(this);
    }    
}
