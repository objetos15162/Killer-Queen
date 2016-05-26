import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Records here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Records extends Button
{
    private Home home;
    
    public Records()
    {
        home = new Home();
    }
    
    /**
     * Ejecuta siempre los métodos que manda llamar.
     */
    public void act() 
    {
        setImage("records.png");
 
        if(Greenfoot.mouseClicked(home))
        {
            home.isClicked();
        }
    }    
    
    /**
     * Al ser presionado agrega el tablero de records que muestra las mejores puntaciones.
     */
    public void isClicked()
    {
      ScoreBoard records = new ScoreBoard(getWorld().getWidth(), getWorld().getHeight());
      getWorld().addObject(records , getWorld().getWidth()/2, getWorld().getHeight()/2);
      getWorld().addObject(home,783,436);
     }
    
}
