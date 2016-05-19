import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class GameOver here.
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
       setBackground("BGdesierto.png");
       this.getBackground().scale(850, 500);
       restart = new Play();
       exit = new Exit();
       addObject(restart,65,443);
       addObject(exit,800,443);
       label = new Label("GAME OVER",100);
       label.setFillColor(Color.RED);
       label.setLineColor(Color.RED);
       addObject(label,getWidth()/2, getHeight()/2);
       
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(restart))
        {
            restart.isClicked();
        }
        
        else if(Greenfoot.mouseClicked(exit))
        {
            exit.isClicked();
        }
        
        
    }
}
