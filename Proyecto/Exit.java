import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;
import java.awt.Font;
/**
 * Representa el botón salir del juego.
 * 
 * @author (Evelyn Gomez) 
 * @version (Mayo 2016)
 */
public class Exit extends Button
{
    public Label label;
    /**
     * Ejecuta siempre los métodos que manda llamar.
     */
    public void act() 
    {
        
    } 
    
    /**
     * Detiene el juego.
     */
    public void isClicked()
    {
      Greenfoot.stop();
    }
}
