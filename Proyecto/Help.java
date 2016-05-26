import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa el botón de ayuda.
 * 
 * @author (Evelyn Gómez) 
 * @version (Mayo 2016)
 */
public class Help extends Button
{
    private HelpWindow help;
    
    public Help()
    {
       help = new HelpWindow(); 
    }
    
    /**
     *  Ejecuta siempre los métodos que manda llamar.
     */
    public void act() 
    {
       
    }   
    
    /**
     * Verifica que el botón ha sido presionado.
     */
    public void isClicked()
    {
        Greenfoot.setWorld(help);
    }
}
