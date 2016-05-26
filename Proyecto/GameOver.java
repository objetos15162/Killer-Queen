import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Esta clase se muestra cuando se ha perdido el juego. Tiene la opción de reiniciar el juego, o bien, salir.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    private Play restart;
    private Level1 level1;
    private Exit exit;
    private Label label;
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
       super(850,500,1);
       setBackground("GO2.png");
       this.getBackground().scale(850, 500);
       restart = new Play();
       exit = new Exit();
       addObject(restart,65,443);
       addObject(exit,800,443);
    
       
    }
    
    /**
     * Comprueba si el boton restart y el botón exit han sido presionados.
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(restart))
        {
            restart.isClicked();
        }
        
        else if(Greenfoot.mouseClicked(exit))
        {
            exit.isClicked();
            setBackground("exit.png");
            removeObject(exit);
            removeObject(restart);
        }
        
        
    }
}
