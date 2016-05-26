import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa la decoración árbol.
 * 
 * @author (Evelyn Gomez) 
 * @version (Mayo 2016)
 */
public class Tree extends Decoration
{
    /**
     *  Ejecuta siempre los mpetodos que manda llamar.
     */
    public void act() 
    {
        setImage("tree2.png");
        scrollObjects();
        remove(this);
    }    
}
