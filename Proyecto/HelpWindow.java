import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase se encarga de mostrar la ventana de auyuda del juego.
 * 
 * @author (Evelyn Gómez) 
 * @version (Mayo 2016)
 */
public class HelpWindow extends World
{
    private Home home;
    /**
     * Constructor for objects of class HelpWindow.
     * 
     */
    public HelpWindow()
    {    
         super(850, 500, 1); 
         setBackground("ayuda.png");
         this.getBackground().scale(850, 500);
         home = new Home();
         addObject(home,773,444);
    }
    
    /**
     * Comprueba si el botón Home ha sido presionado.
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(home))
        {
            home.isClicked();
        }
    }
}
