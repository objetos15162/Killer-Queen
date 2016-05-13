import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;
/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends Levels
{
    private Skeleton skeleton;
    private VolcanGround ground;
    private boolean start;
    private SimpleTimer timerSkel;//Agrega esqueletos aleatorios
    private Counter timerDisplay;//Muestra el tiempo.
    private SimpleTimer timerWin;//Determina cuando se supera el nivel.
    private Label label;
   /**
     * Constructor for objects of class Level1.
     * 
     */
    public Level1()
    {    
        setBackground("volcan.png");
        start = false;
        ground = new VolcanGround();
        timerSkel = new SimpleTimer();
        timerSkel.mark();
        //Se agregan los objetos que simulan el suelo
        for(int i=0; i<4; i++)
        {
            addObject(new VolcanGround(),256 * i , yGround);
        }
        
        //Timer que determina cuando se ha superado el nivel 1
        timerWin = new SimpleTimer();
        timerWin.mark();
        timerDisplay = new Counter("Time: ");
        addObject(timerDisplay,764,24);
        label = new Label("Press enter to continue",80);
        //addObject(label, getWidth()/2,getHeight()/2); 
    }
 
  
    public void act()
    {
           
       if ( Greenfoot.isKeyDown("enter"))
            start = true;
            removeObject(label);
        
        if(start == true)
        {
           if(timerWin.millisElapsed() > 1000)
            {
                timerDisplay.add(1);
                timerWin.mark();
            }
            
            if(Greenfoot.getRandomNumber(650) == 1)
           //if(timerSkel.millisElapsed() > Greenfoot.getRandomNumber(10000)+5000)
           {
               addSkeleton();
               timerSkel.mark();
           } 
           genGround();
           updateTime();
           randomCoins();
           levelComplete();
        }
        else
        {
            genGround();
        }
    }
    
    private void genGround()
    {
        if (getObjects(VolcanGround.class).size() < 5)
        {
            VolcanGround g = new VolcanGround();
            addObject(g,getWidth(), getHeight() - g.getImage().getHeight()/2); 
        }
    }
    
    private void addSkeleton()
    {
        addObject(new Skeleton(), getWidth(), getHeight() - 148);
    }
    
    public void levelComplete()
    {
        if(timerDisplay.getValue() >= 30)
        {
            Level2 level2 = new Level2();
            Greenfoot.setWorld(level2);
            timerWin.mark();
        }  
    }
}  
   
    








