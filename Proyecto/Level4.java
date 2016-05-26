import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Es el cuarto nivel. Aquí los enemigos que aparecen son zombies y v esqueletos. El jugador tendrá que esquivar los obstáculos que son los hongos venenosos
 * que aparecen aleatoriamente a lo largo del juego.
 * Para ganar debe completar los 70 segundos con al menos una vida.
 * 
 * @author (Evelyn Gómez) 
 * @version (Mayo 2016)
 */
public class Level4 extends Level
{
    private Counter timerDisplay;//Muestra el tiempo.
    private SimpleTimer timerWin;//Determina cuando se supera el nivel.
    private Zombie zombie;
    private SimpleTimer timerEnemies;
    private Skeleton skeleton;
    private Vampire vampire;
    private Ground ground;
    private Mushroom mushroom;
    private SimpleTimer timerDecoration;
    private Clouds clouds;
    private TreeForest tree;
   
    /**
     * Constructor for objects of class Level4.
     * 
     */
    public Level4(int distance)
    {
        setBackground("Forest.png");
        this.getBackground().scale(850, 500);
        
        for(int i=0; i<4; i++)
        {
            addObject(new Ground(),256 * i , getYground());
        }
        timerDecoration = new SimpleTimer();
        timerEnemies = new SimpleTimer();
        timerWin = new SimpleTimer();
        timerWin.mark();
        timerDisplay = new Counter("Time: ");
        addObject(timerDisplay,764,24);
        clouds = new Clouds();
        addObject(clouds, getWidth(), 74);
        setDistance(distance);
    }
    
    /**
     * Ejecuta siempre los métodos que manda llamar.
     */
    public void act()
    {
       genGround();
       levelComplete();
       updateTime();
       randomCoins();
       addRandomEnemies();
       addDecoration();
       updateClock();
       genDecoration();
    }
    
    /**
     * Agrega esqueletos y zombies aleatoririamente en este nivel.
     */
     private void addRandomEnemies()
    {
        if(Greenfoot.getRandomNumber(250) == 10)
      {
          addObject(new Skeleton(),getWidth(),getYground() - 84);
          timerEnemies.mark();
      }
      else if(Greenfoot.getRandomNumber(250) == 10)
      {
          addObject(new Zombie(),getWidth(),getYground() - 84);
          timerEnemies.mark();
      }
      
      else if(Greenfoot.getRandomNumber(250) == 10)
      {
          addObject(new Vampire(),getWidth(),getYground() - 84);
          timerEnemies.mark();
      }
        
    }
    
    /**
     * Se encarga de agregar decoraciones aleatoriamente en este nivel.
     */
    private void addDecoration()
    {
       if(Greenfoot.getRandomNumber(300) == 10)
       { 
           addObject(new Mushroom(), getWidth(), getHeight() - 128);
           timerDecoration.mark();
       }
        
       if(Greenfoot.getRandomNumber(490) == 20)
       { 
           addObject(new TreeForest(), getWidth(), 260);
           timerDecoration.mark();
       }
    }
    
    /**
     * Se encarga de actualizar el reloj.
     */
    private void updateClock()
    {
        if(timerWin.millisElapsed() > 1000)
        {
            timerDisplay.add(1);
            timerWin.mark();
        }
    }
    
    /**
     * Se encarga de verificar el tiempo necesario para terminar el nivel y vuelve nuevamente al menú principal.
     */
    private void levelComplete()
    {
        
        if(timerDisplay.getValue() >= 70)
        {
            StartMenu menu = new StartMenu();
            Greenfoot.setWorld(menu);
            timerWin.mark();
        }  
     }
}
