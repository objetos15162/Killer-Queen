import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.*;


/**
 * Esta clase se encarga de mostrar el menú principal del juego.
 * 
 * @author (Evelyn Gómez) 
 * @version (Mayo 2016)
 */
public class StartMenu extends World
{
    private Play play;
    private Exit exit;
    private Help help;
    private Records records;
    private ArrayList<Button> lBotones;
    private ArrayList<String> players;
    private GreenfootSound sound;
  
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public StartMenu()
    {    
       super(850, 500, 1); 
       setBackground("StartMenu.png");
       lBotones = new ArrayList();
       play = new Play();
       exit = new Exit();
       help = new Help();
       records = new Records();
       lBotones.add(0, play);
       lBotones.add(1, help);
       lBotones.add(2, records);
       lBotones.add(3, exit);
       int x,y;
       x = 10;
       y = 10;
       //Se crea una lista de botones y con un ciclo se van agregando al escenario
       for(int i=0; i<lBotones.size(); i++)
       {
           addObject(lBotones.get(i),lBotones.get(i).getImage().getWidth()+ x ,getHeight()- lBotones.get(i).getImage().getHeight()- y);
           x += lBotones.get(i).getImage().getWidth() + 10;
       }
       sound = new GreenfootSound("sad.wav");
       sound.playLoop();
    }
    
    /**
     * Comprueba que se haga click sobre los botones.
     */
    public void act()
    {
        
        if(Greenfoot.mouseClicked(play))
        {
           play.isClicked();
          
        }
        else if(Greenfoot.mouseClicked(help))
        {
           help.isClicked();
        }
        else if(Greenfoot.mouseClicked(records))
        {
           records.isClicked();
        }
        else if(Greenfoot.mouseClicked(exit))
        {
           removeObjects(lBotones);
           exit.isClicked();
           setBackground("exit.png");
           getBackground().scale(850, 500);
           //sound.stop();
        }
    }
}
