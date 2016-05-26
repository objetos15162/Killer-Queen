import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
import java.util.ArrayList;
/**
 * Representa el botón comenzar del juego.
 * 
 * @author (Evelyn Gómez) 
 * @version (Mayo 2016)
 */
public class Play extends Button
{
    private Level1 level1;
   
    public Play()
    {
        level1 = new Level1();
        
    }
        
   
    public void act() 
    {
        
    }
    
    /**
     * Este método inicia el juego en el nivel 1.
     */
    public void isClicked()
    {
       Greenfoot.setWorld(level1); 
 
    }
 
}
