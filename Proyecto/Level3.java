import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Es el tercer nivel. Aquí los enemigos que aparecen son vampiros y el jugador tendrá que esquivar los obstáculos que son los cristales de hielo
 * que aparecen aleatoriamente a lo largo del juego.
 * Para ganar debe completar los 60 segundos con al menos una vida.
 * 
 * @author (Evelyn Gómez) 
 * @version (Mayo 2016)
 */
public class Level3 extends Level
{
    private SimpleTimer timerVampire;//Agrega esqueletos aleatorios
    private Counter timerDisplay;//Muestra el tiempo.
    private SimpleTimer timerWin;//Determina cuando se supera el nivel.
    private Ground ground;
    private Vampire vampire;
    private Crystal crystal;
    private SimpleTimer timerDecoration;
    private Pine pine;
    private Mist mist;
    private GreenfootSound sound;
    /**
     * Constructor for objects of class Level3.
     * 
     */
    public Level3(int distance)
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
        setDistance(distance);
        sound = new GreenfootSound("racers.wav");
        sound.play();
        
        
        for(int i=0; i<4; i++)
        {
            addObject(new Ground(),256 * i , getYground());
        }
        
    }
    
    /**
     * Ejecuta siempre los métodos que manda llamar.
     */
     public void act()
    {
      addRandomVampire();
      genGround();
      levelComplete();
      updateTime();
      randomCoins();
      updateClock();
      addDecoration();
      genDecoration();
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
     * Agrega vampiros a este nivel aleatoriamente.
     */
    private void addRandomVampire()
    {
        if(Greenfoot.getRandomNumber(200) == 10)
       {
           addObject(new Vampire(),getWidth(),getYground() - 86);
           timerVampire.mark();
       }
        
    }
    
    /**
     * Se encarga de agregar decoraciones aleatoriamente en este nivel.
     */
    private void addDecoration()
    {
       if(Greenfoot.getRandomNumber(300) == 10)
       { 
           addObject(new Crystal(), getWidth(), getHeight() - 140);
           timerDecoration.mark();
        }
        
       if(Greenfoot.getRandomNumber(490) == 20)
       { 
           addObject(new Pine(), getWidth(), 317);
           timerDecoration.mark();
       }
    }
    
    /**
     * Se encarga de verificar el tiempo necesario para terminar el nivel, crea un nuevo mundo Nivel 4 y lo asigna.
     */
    private void levelComplete()
    {
       if(timerDisplay.getValue() >= 60)
        {
            sound.stop();
            Level4 level4 = new Level4(getDistance());
            Greenfoot.setWorld(level4);
            timerWin.mark();
        }  
     }
}
