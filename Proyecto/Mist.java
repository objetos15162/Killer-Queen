import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa la decoración neblina.
 * 
 * @author (Evelyn Gomez) 
 * @version (Mayo 2016)
 */
public class Mist extends Decoration
{
    /**
     * Ejecuta siempre los mpetodos que manda llamar.
     */
    public void act() 
    {
        setImage("mist.png");
        moveDecoration();
        remove(this);
    }    
}
