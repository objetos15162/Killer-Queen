import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level4 extends Levels
{
    private Counter timerDisplay;//Muestra el tiempo.
    private SimpleTimer timerWin;//Determina cuando se supera el nivel.
    private Zombie zombie;
    private SimpleTimer timerEnemies;
    private Skeleton skeleton;
    private Ground ground;
    private Mushroom mushroom;
    private SimpleTimer timerDecoration;
    private Clouds clouds;
    private TreeForest tree;
    /**
     * Constructor for objects of class Level4.
     * 
     */
    public Level4()
    {
        setBackground("Forest.png");
        this.getBackground().scale(850, 500);
        
        for(int i=0; i<4; i++)
        {
            addObject(new Ground(),256 * i , yGround);
        }
        timerDecoration = new SimpleTimer();
        timerEnemies = new SimpleTimer();
        timerWin = new SimpleTimer();
        timerWin.mark();
        timerDisplay = new Counter("Time: ");
        addObject(timerDisplay,764,24);
    }
    
    public void act()
    {
       genGround();
       levelComplete();
       updateTime();
       randomCoins();
       addRandomEnemies();
       addDecoration();
       updateClock();
    }
    
     private void addRandomEnemies()
    {
        if(Greenfoot.getRandomNumber(250) == 10)
      {
          addObject(new Skeleton(),getWidth(),yGround - 84);
          timerEnemies.mark();
      }
      else if(Greenfoot.getRandomNumber(250) == 10)
      {
          addObject(new Zombie(),getWidth(),yGround - 84);
          timerEnemies.mark();
      }
        
    }
    
    private void addDecoration()
    {
       if(Greenfoot.getRandomNumber(300) == 10)
       { 
           addObject(new Mushroom(), getWidth(), getHeight() - 128);
           timerDecoration.mark();
       }
        
       if(Greenfoot.getRandomNumber(650) == 10)
       {
            addObject(new Clouds(), getWidth() , 99);
       }
        
       if(Greenfoot.getRandomNumber(490) == 20)
       { 
           addObject(new TreeForest(), getWidth(), 260);
           timerDecoration.mark();
       }
    }
    
    private void updateClock()
    {
        if(timerWin.millisElapsed() > 1000)
        {
            timerDisplay.add(1);
            timerWin.mark();
        }
    }
    
    private void levelComplete()
    {
        
        if(timerDisplay.getValue() >= 50)
        {
            StartMenu menu = new StartMenu();
            Greenfoot.setWorld(menu);
            timerWin.mark();
        }  
     }
}
