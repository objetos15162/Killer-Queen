import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa la decoración pino.
 * 
 * @author (Evelyn Gomez) 
 * @version (Mayo 2016)
 */
public class Pine extends Decoration
{
    /**
     *  Ejecuta siempre los mpetodos que manda llamar.
     */
    public void act() 
    {
        setImage("pine_tree.png");
        scrollObjects();
        remove(this);
    }    
}
