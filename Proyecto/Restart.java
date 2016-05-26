import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa el botón reiniciar del juego.
 * 
 * @author (Evelyn Gomez) 
 * @version (Mayo 2016)
 */
public class Restart extends Button
{
    private Level1 level1;
    /**
     * Ejecuta siempre los métodos que manda llamar.
     */
    public void act()
    {
    }
    
    /**
     * Asigna nuevamente el nivel 1.
     */
    public void isClicked() 
    {
        level1 = new Level1();
        Greenfoot.setWorld(level1);
    }    
}
