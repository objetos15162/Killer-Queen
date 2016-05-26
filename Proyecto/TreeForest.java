import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa la decoración árbol de bosque.
 * 
 * @author (Evelyn Gomez) 
 * @version (Mayo 2016)
 */
public class TreeForest extends Decoration
{
    /**
     *  Ejecuta siempre los mpetodos que manda llamar.
     */
    public void act() 
    {
        setImage("treeForest.png");
        scrollObjects();
        remove(this);
    }    
}
