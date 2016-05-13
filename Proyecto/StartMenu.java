import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartMenu extends World
{
    private Play play;
    //private Home home;
    private Exit exit;
    private HighScores scores;
    private Help help;
    private ArrayList<Boton> lBotones;
   
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
       //home = new Home();
       exit = new Exit();
       scores = new HighScores();
       help = new Help();
       lBotones.add(0, play);
       lBotones.add(1, help);
       lBotones.add(2, scores);
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
       
    }
    
    public void act()
    {
        //Comprueba que se haga click sobre los botones
        if(Greenfoot.mouseClicked(play))
        {
           play.isClicked(); 
        }
        else if(Greenfoot.mouseClicked(help))
        {
           help.isClicked();
        }
        else if(Greenfoot.mouseClicked(scores))
        {
           // scores.isClicked();
        }
        else if(Greenfoot.mouseClicked(exit))
        {
           exit.isClicked();
           Label label = new Label("Thanks for playing!!",90);
           label.setFillColor(Color.MAGENTA);
           label.setLineColor(Color.MAGENTA);
           addObject(label,getWidth()/2,getHeight()/2);
           removeObjects(lBotones);
        }
    }
}
