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
    private WinterGround ground;
    private Vampires vampire;
    /**
     * Constructor for objects of class Level3.
     * 
     */
    public Level3()
    {    
        setBackground("Winter.png");
        this.getBackground().scale(850, 500);
        timerVampire = new SimpleTimer();
        timerDisplay = new Counter();
        timerWin = new SimpleTimer();
        timerDisplay = new Counter("Time: ");
        addObject(timerDisplay,764,24);
        int xi = 0;
        
        for(int i=0; i<4; i++)
        {
            addObject(new WinterGround(),256 * i , yGround);
        }
        
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
           addVampire();
           timerVampire.mark();
       }
       
       levelComplete();
       updateTime();
       randomCoins();
    }
    
    private void addVampire()
    {
        addObject(new Vampires(),getWidth(),yGround - 84);
    }
    
    public void levelComplete()
    {
        Level4 level4 = new Level4();
        if(timerDisplay.getValue() >= 30)
        {
            Greenfoot.setWorld(level4);
            timerWin.mark();
        }  
     }
}
