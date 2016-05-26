import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa la decoración cactus.
 * 
 * @author (Evelyn Gomez) 
 * @version (Mayo 2016)
 */
public class Cactus extends Decoration
{
    /**
     * Ejecuta siempre los mpetodos que manda llamar.
     */
    public void act() 
    {
        setImage("cactus.png");
        scrollObjects();
        remove(this);
    }    
}
