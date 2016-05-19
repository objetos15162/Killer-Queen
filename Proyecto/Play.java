import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class Jugar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends Button
{
    private Level1 level1;
    
    public Play()
    {
        level1 = new Level1();
    }
        
    /**
     * Act - do whatever the Jugar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
