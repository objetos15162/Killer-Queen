import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa el botón inicio del juego.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Home extends Button
{
    private StartMenu menu;
    
    public Home()
    {
        
    }
    
    /**
     * Ejecuta siempre los métodos que manda llamar.
     */
    public void act() 
    {
        
    }    
    
    /**
     * Regresa al menú principal.
     */
    public void isClicked()
    {
        menu = new StartMenu();
        Greenfoot.setWorld(menu);
    }
}
