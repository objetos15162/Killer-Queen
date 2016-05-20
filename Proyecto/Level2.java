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
    private Ground ground;
    private Zombie zombie;
    private Stone stone;
    private SimpleTimer timerDecoration;
    private Cactus cactus;
    private Clouds clouds;
   
    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2()
    {   
        setBackground("BGdesierto.png");
        this.getBackground().scale(850, 500);
        ground = new Ground();
        
        for(int i=0; i<4; i++)
        {
            addObject(new Ground(),256 * i , yGround);
        }
        
        timerZombie = new SimpleTimer();
        timerZombie.mark();
        timerDecoration = new SimpleTimer();
        timerWin = new SimpleTimer();
        timerWin.mark();
        timerDisplay = new Counter("Time: ");
        addObject(timerDisplay,764,24);
    }
    
    public void act()
    {
       updateClock();
       genGround();
       addRandomZombie();
       levelComplete();
       updateTime();
       randomCoins();
       addDecoration();
    }
    
     private void updateClock()
    {
        if(timerWin.millisElapsed() > 1000)
        {
            timerDisplay.add(1);
            timerWin.mark();
        }
    }
    
    private void addRandomZombie()
    {
        if(Greenfoot.getRandomNumber(350) == 10)
        {
            addObject(new Zombie(),getWidth(),yGround - 84);
            timerZombie.mark();
        }
    }
    
    private void addDecoration()
    {
        if(Greenfoot.getRandomNumber(500) == 10)
        { 
            addObject(new Stone(), getWidth(), getHeight() - 130);
            timerDecoration.mark();
        }
        
        if(Greenfoot.getRandomNumber(350) == 10)
        {
            addObject(new Clouds(), getWidth() , 99);
        }
        
        if(Greenfoot.getRandomNumber(490) == 20)
        { 
            addObject(new Cactus(), getWidth(), 336);
            timerDecoration.mark();
        }
    }
    
    private void levelComplete()
    {
        
        if(timerDisplay.getValue() >= 60)
        {
            Level3 level3 = new Level3();
            Greenfoot.setWorld(level3);
            timerWin.mark();
        }  
     }
    
    
  
}
