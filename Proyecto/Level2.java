import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Es el segundo nivel. Aquí los enemigos que aparecen son zombies y el jugador tendrá que esquivar los obstáculos que son las rocas de arena
 * que aparecen aleatoriamente a lo largo del juego.
 * Para ganar debe completar los 50 segundos con al menos una vida.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends Level
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
    private GreenfootSound sound;
    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2(int distance)
    {   
        setBackground("BGdesierto.png");
        this.getBackground().scale(850, 500);
        ground = new Ground();
        clouds = new Clouds();
        addObject(clouds, getWidth(), 107);
        for(int i=0; i<4; i++)
        {
            addObject(new Ground(),256 * i , getYground());
        }
        setDistance(distance);
        timerZombie = new SimpleTimer();
        timerZombie.mark();
        timerDecoration = new SimpleTimer();
        timerWin = new SimpleTimer();
        timerWin.mark();
        timerDisplay = new Counter("Time: ");
        addObject(timerDisplay,764,24);
        sound = new GreenfootSound("sad.wav");
        sound.play();
    }
    
    /**
     * Ejecuta siempre los métodos que manda llamar.
     */
    public void act()
    {
       checkScore();
       updateClock();
       genGround();
       addRandomZombie();
       levelComplete();
       updateTime();
       randomCoins();
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
     *,Agrega Zombies a este nivel aleatoriamente.
    */
    private void addRandomZombie()
    {
        if(Greenfoot.getRandomNumber(350) == 10)
        {
            addObject(new Zombie(),getWidth(),getYground() - 84);
           
            timerZombie.mark();
        }
    }
    
    /**
     * Se encarga de agregar decoraciones aleatoriamente en este nivel.
     */
    private void addDecoration()
    {
        if(Greenfoot.getRandomNumber(500) == 10)
        { 
            addObject(new Stone(), getWidth(), getHeight() - 130);
            timerDecoration.mark();
        }
        
        if(Greenfoot.getRandomNumber(490) == 20)
        { 
            addObject(new Cactus(), getWidth(), 336);
            timerDecoration.mark();
        }
    }
    
    /**
     * Se encarga de verificar el tiempo necesario para terminar el nivel, crea un nuevo mundo Nivel 3 y lo asigna.
     */

    private void levelComplete()
    {
        if(timerDisplay.getValue() >= 50)
        {
            sound.stop();
            Level3 level3 = new Level3(getDistance());
            Greenfoot.setWorld(level3);
            timerWin.mark();
        }  
     }
    
    
  
}
