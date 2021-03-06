import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;
import java.awt.Font;
/**
 * Es el primer y el más fácil de los niveles. Aquí los enemigos que aparecen son esqueletos y el jugador tendrá que esquivar los obstáculos que son las rocas cafés
 * que aparecen aleatoriamente a lo largo del juego.
 * Para ganar debe completar los 40 segundos con al menos una vida.
 * 
 * @author (Evelyn Gómez) 
 * @version (Mayo 2016)
 */
public class Level1 extends Level
{
    private Skeleton skeleton;
    private Ground ground;
    private boolean start;
    private SimpleTimer timerSkel;//Agrega esqueletos aleatorios
    private Counter timerDisplay;//Muestra el tiempo
    private SimpleTimer timerWin;//Determina cuando se supera el nivel.
    private SimpleTimer timerObstacle;
    private SimpleTimer timerDecoration;
    private Label label;
    private Skull skull;
    private Rock rock;
    private Fog fog;
    private Tree tree;
   /**
     * Constructor for objects of class Level1.
     * 
     */
    public Level1()
    {    
       setBackground("volcan.png");
       start = false;
       ground = new Ground();
       timerSkel = new SimpleTimer();
       timerSkel.mark();
       timerObstacle = new SimpleTimer();
       timerDecoration = new SimpleTimer();
       fog =  new Fog();
       addObject(fog, 411, 165);
       //Timer que determina cuando se ha superado el nivel 1
       timerWin = new SimpleTimer();
       timerWin.mark();
       timerDisplay = new Counter("Time: ");
       addObject(timerDisplay,764,24);
        if(start == false)
       {
           label = new Label("Press enter to start",90);
           label.setFillColor(Color.RED);
           label.setLineColor(Color.RED);
           Font.decode("TAHOMA");
           addObject(label, getWidth()/2,getHeight()/2); 
  
       }
    }
 
  
    /**
     * Ejecuta siempre los métodos que manda llamar.
     */
    public void act()
    {
       
       if ( Greenfoot.isKeyDown("enter")&& start == false)
       {   
           start = true;
           removeObject(label);
       }
        
       if(start == true)
       {
           checkScore();
           updateClock();
           addRandomSkeleton();
           genGround();
           updateTime();
           randomCoins();
           levelComplete();
           addObstacles();
           addDecoration();
           genDecoration();
       }
       else
       {
           genGround();
       }
    }
    
   /**
    * Agrega obstáculos en el mundo aleatoriamente.
    */
    private void addObstacles()
    {
        if(Greenfoot.getRandomNumber(550) == 5)
        {
            addObject(new Rock(), getWidth(), getHeight() - 133);
            timerObstacle.mark();
        }
    }
    
    /**
     * Actualiza el reloj del mundo.
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
     * Agrega esqueletos al mundo aleatoriamnente.
     */
    private void addRandomSkeleton()
    {
       if(Greenfoot.getRandomNumber(300) == 20)
       {
           addObject(new Skeleton(), getWidth(), getHeight() - 148);
           timerSkel.mark();
       } 
    }
    
    /**
     * Agrega decoraciones al mundo aleatoriamente.
     */
    private void addDecoration()
    {
        if(Greenfoot.getRandomNumber(500) == 10)
        { 
            addObject(new Skull(), getWidth(), getHeight() - 128);
            timerDecoration.mark();
        }
        
        if(Greenfoot.getRandomNumber(490) == 20)
        { 
            addObject(new Tree(), getWidth(), 187);
            timerDecoration.mark();
        }
    }
    
    /**
     * Se encarga de verificar el tiempo necesario para terminar el nivel, crea un nuevo mundo Nivel 2 y lo asigna.
     */
    private void levelComplete()
    {
        if(timerDisplay.getValue() >= 40)
        {
            Level2 level2 = new Level2(getDistance());
            Greenfoot.setWorld(level2);
            timerWin.mark();
        }  
    }
}
   
    








