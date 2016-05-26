import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa la decoración cráneo.
 * 
 * @author (Evelyn Gomez) 
 * @version (Mayo 2016)
 */
public class Skull extends Decoration
{
    /**
     * Ejecuta siempre los métodos que manda llamar.
     */
    public void act() 
    {
        setImage("skull.png");
        scrollObjects();
        remove(this);
    }    
}
