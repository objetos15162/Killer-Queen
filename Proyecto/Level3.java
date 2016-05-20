import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends Levels
{
    private SimpleTimer timerVampire;//Agrega esqueletos aleatorios
    private Counter timerDisplay;//Muestra el tiempo.
    private SimpleTimer timerWin;//Determina cuando se supera el nivel.
    private Ground ground;
    private Vampires vampire;
    private Crystal crystal;
    private SimpleTimer timerDecoration;
    private Pine pine;
    private Mist mist;
    /**
     * Constructor for objects of class Level3.
     * 
     */
    public Level3()
    {    
        setBackground("Winter.png");
        this.getBackground().scale(850, 500);
        timerVampire = new SimpleTimer();
        timerDecoration = new SimpleTimer();
        timerDisplay = new Counter();
        timerWin = new SimpleTimer();
        timerDisplay = new Counter("Time: ");
        addObject(timerDisplay,764,24);
        mist = new Mist();
        addObject(mist, 456, 123);
        int xi = 0;
        
        for(int i=0; i<4; i++)
        {
            addObject(new Ground(),256 * i , yGround);
        }
        
    }
    
     public void act()
    {
      addRandomVampire();
      genGround();
      levelComplete();
      updateTime();
      randomCoins();
      updateClock();
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
    
    private void addRandomVampire()
    {
        if(Greenfoot.getRandomNumber(200) == 10)
       {
           addObject(new Vampires(),getWidth(),yGround - 86);
           timerVampire.mark();
       }
        
    }
    
    private void addDecoration()
    {
       if(Greenfoot.getRandomNumber(300) == 10)
       { 
           addObject(new Crystal(), getWidth(), getHeight() - 140);
           timerDecoration.mark();
       }
        
       if(Greenfoot.getRandomNumber(250) == 5)
       {
            addObject(new Mist(), getWidth() , 99);
       }
        
       if(Greenfoot.getRandomNumber(490) == 20)
       { 
           addObject(new Pine(), getWidth(), 317);
           timerDecoration.mark();
       }
    }
    
    private void levelComplete()
    {
       if(timerDisplay.getValue() >= 80)
        {
            Level4 level4 = new Level4();
            Greenfoot.setWorld(level4);
            timerWin.mark();
        }  
     }
}
