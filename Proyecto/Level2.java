import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends Levels
{
    private SimpleTimer timerZombie;//Agrega esqueletos aleatorios
    private Counter timerDisplay;//Muestra el tiempo.
    private SimpleTimer timerWin;//Determina cuando se supera el nivel.
    private DesertGround ground;
    private Zombie zombie;
    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2()
    {   
        setBackground("BGdesierto.png");
        this.getBackground().scale(850, 500);
        ground = new DesertGround();
        int xi = 0;
        
        for(int i=0; i<4; i++)
        {
            addObject(new DesertGround(),256 * i , yGround);
        }
        
        timerZombie = new SimpleTimer();
        timerZombie.mark();
        //Timer que determina cuando se ha superado el nivel 1
        timerWin = new SimpleTimer();
        timerWin.mark();
        timerDisplay = new Counter("Time: ");
        addObject(timerDisplay,764,24);
    }
    
    public void act()
    {
      if(timerWin.millisElapsed() > 1000)
        {
            timerDisplay.add(1);
            timerWin.mark();
        }
        
      if(Greenfoot.getRandomNumber(650) == 3)
       //if(timerSkel.millisElapsed() > Greenfoot.getRandomNumber(10000)+5000)
       {
           addZombie();
           timerZombie.mark();
       }
       
       levelComplete();
       updateTime();
       randomCoins();
    }
    
    private void addZombie()
    {
        addObject(new Zombie(),getWidth(),yGround - 84);
    }
    
    public void levelComplete()
    {
        Level3 level3 = new Level3();
        if(timerDisplay.getValue() >= 30)
        {
            Greenfoot.setWorld(level3);
            timerWin.mark();
        }  
     }
  
}
