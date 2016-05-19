import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level4 extends Levels
{
    private SimpleTimer timerZombie;//Agrega esqueletos aleatorios
    private Counter timerDisplay;//Muestra el tiempo.
    private SimpleTimer timerWin;//Determina cuando se supera el nivel.
    private ForestGround ground;
    private Zombie zombie;
    private SimpleTimer timerSkeleton;
    private Skeleton skeleton;
    
    /**
     * Constructor for objects of class Level4.
     * 
     */
    public Level4()
    {
        setBackground("Forest.png");
        this.getBackground().scale(850, 500);
        
        ground = new ForestGround();
        int xi = 0;
        
        for(int i=0; i<4; i++)
        {
            addObject(new ForestGround(),256 * i , yGround);
        }
        
        timerZombie = new SimpleTimer();
        timerZombie.mark();
        timerSkeleton = new SimpleTimer();
        timerSkeleton.mark();
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
        
      if(Greenfoot.getRandomNumber(250) == 10)
       //if(timerSkel.millisElapsed() > Greenfoot.getRandomNumber(10000)+5000)
       {
           addZombie();
           timerZombie.mark();
       }
       
      if(Greenfoot.getRandomNumber(250) == 10)
      {
          addSkeleton();
          timerSkeleton.mark();
      }
      
       genGround();
       levelComplete();
       updateTime();
       randomCoins();
    }
    
    private void addZombie()
    {
        addObject(new Zombie(),getWidth(),yGround - 84);
    }
    
     private void addSkeleton()
    {
        addObject(new Skeleton(),getWidth(),yGround - 84);
    }
    
    public void levelComplete()
    {
        Level5 level5 = new Level5();
        if(timerDisplay.getValue() >= 20)
        {
            Greenfoot.setWorld(level5);
            timerWin.mark();
        }  
     }
}
