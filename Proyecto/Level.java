import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;
import java.awt.image.*;
import java.awt.Graphics2D;

/**
 * Superclase Level. Se encarga de agregar todos los objetos iniciales de los mundos. Las vidas, monedas, enemidos y piso.
 * 
 * @author (Evelyn Gómez) 
 * @version (Mayo 2016)
 */
public class Level extends World
{
    private KillerQueen killer;
    private SimpleTimer timerCoins;//Agrega monedas aleatorias.
    private int yGround;
    private List<Life> lHearts;//Arreglo de vidas.
    private Coin coin;
    private Counter timerDisplay;//Muestra el tiempo.
    private Counter killedEnemies;
    private SimpleTimer timerWin;//Determina cuando se supera el nivel.
    private Counter trappedCoin;//Contador de monedas atrapadas.
    private Label labelCoin;//Muestra monedas atrapadas.
    private CoinNotMovable coinTrapped;
    private GameOver gameOver;
    private SimpleTimer timerDie;
    private boolean die;
    private Ground ground;
    private Fog fog;
    private Counter counterDistance;
    private SimpleTimer timerDistance;
    private int distance;
    private UserRecords records;
    /**
     * Constructor for objects of class Levels.
     * 
     */
    public Level()
    {    
        super(850, 500, 1);
        die = false;
        records = new UserRecords();
        yGround = getHeight() - 54;
        killer = new KillerQueen();
        addObject(killer, 90, yGround - killer.getImage().getHeight());
        timerCoins= new SimpleTimer();
        timerCoins.mark();
        timerDie =new SimpleTimer();
        DrawLifes(killer.getLifes());
        
        //Timer que determina cuando se ha superado el nivel.
        timerWin = new SimpleTimer();
        timerWin.mark();
        timerDisplay = new Counter("Time: ");
        addObject(timerDisplay,764,24);
        counterDistance = new Counter("Distance: ");
        timerDistance = new SimpleTimer();
        timerDistance.mark();
        addObject(counterDistance, 632, 24);
        
        //Label y contador que muestran las monedas que han sido atrapadas.
        labelCoin = new Label("",25);
        addObject(labelCoin, 80, 66);
        coinTrapped = new CoinNotMovable();
        addObject(coinTrapped,46,65);
        labelCoin.setValue(0);
        labelCoin.setFillColor(Color.RED);
        labelCoin.setLineColor(Color.RED);
        setPaintOrder(KillerQueen.class, Enemie.class, Counter.class, Obstacles.class, Life.class, Coin.class);
        ground = new Ground();
         for(int i=0; i<4; i++)
        {
            addObject(new Ground(),256 * i , yGround);
        }
        
    }
    
    /**
     * Actualiza la distancia recorrida.
     */
    public void checkScore()
    {
      if(timerDistance.millisElapsed() > 3000)
        {
            distance++;
            counterDistance.setValue(distance);
            timerDistance.mark();
            
        }
    }
    
    /**
     * Este método se encarga de ir aumentando el contador del tiempo.
     */
    public void updateTime()
    {
       if(timerWin.millisElapsed() > 1000)
        {
            timerDisplay.add(1);
            timerWin.mark();
        }
    }
  
    /**
     * Este método se encarga de agregar aleatoriamente monedas en los mundos.
     */
    public void randomCoins()
    {
         if(Greenfoot.getRandomNumber(320) == 1) 
           {
               DrawCoins(Greenfoot.getRandomNumber(4) + 1);
               timerCoins.mark();
           }
    }
    
    /**
     * Este método se encarga de dibujar las vidas de Killer Queen. Dependiendo si ha sido atacada, se actualiza el método desde el mundo,después obtiene los objetos 
     * de la clase Life, los elimina y con el parámetro lifes dibuja las vidas actuales de Killer Queen. Dibuja las vidas en la parte superior izquierda de la pantalla.
     * @param lifes vidas de Killer Queen.
     */
    public void DrawLifes(int lifes)
    {
        lHearts = getObjects(Life.class);
        removeObjects(lHearts);
        int x;
        x=20;
        for(int i=0; i<lifes; i ++)
         {
             addObject(new Life(), x ,20);
             x += 37; 
         }     
    }
    
    /**
     * Este método se encarga de agregar el número de monedas según el parámetro num.
     * @param num El número de monedas por agregar.
     */
    private void DrawCoins(int num)
    {
        int xi = getWidth();
        for(int i = 0; i<num ;i++){
             addObject(new Coin(),xi + 32,yGround -125);
             xi += 32;
        }
           
    }
    
    /**
     * Actualiza el número de comedas atrapadas.
     */
    public void updateCoins()
    {
        labelCoin.setValue(killer.getTrappedCoins());
    }
    
    /**
     * Este método se encarga de agregar piso en los niveles. Según el nivel en el que se encuentre, agrega distintos tipos de piso, dependiendo de los escenarios de cada nivel.
     */
    public void genGround()
    {
        if(getClass() == Level1.class )
        {
            if (getObjectsAt(getWidth(), getHeight() - 10, Ground.class).size() == 0)
            {
                Ground ground = new Ground();
                addObject(ground, getWidth() , yGround);
            }
        }
        else if(getClass() == Level2.class )
        {
            if (getObjectsAt(getWidth(), getHeight() - 10, Ground.class).size() == 0)
            {
                Ground ground = new Ground();
                addObject(ground, getWidth() , yGround);
            }
        }
        else if(getClass() == Level3.class )
        {
            if (getObjectsAt(getWidth(), getHeight() - 10, Ground.class).size() == 0)
            {
                Ground ground = new Ground();
                addObject(ground, getWidth() , yGround);
            }
        }
        else if(getClass() == Level4.class )
        {
            if (getObjectsAt(getWidth(), getHeight() - 10, Ground.class).size() == 0)
            {
                Ground ground = new Ground();
                addObject(ground, getWidth() , yGround);
            }
        }
        
    }
    
    /**
     * Se encarga de agregar decoraciones en los niveles. Según el nivel en que se encuentre, agrega distintos tipos de decoraciones, dependiendo de los escenarios de cada nivel.
     */
    public void genDecoration()
    {
        if(getClass() == Level1.class )
        {
            if (getObjectsAt(getWidth(), 165, Fog.class).size() == 0)
            {
                Fog fog = new Fog();
                addObject(fog, getWidth() , 165);
            }
        }else if(getClass() == Level2.class)
        {
            if(getObjectsAt(getWidth(), 165, Clouds.class).size() == 0)
            {
                Clouds clouds = new Clouds();
                addObject(clouds, getWidth(), 107);
            }
        }
        else if(getClass() == Level3.class)
        {
            if(getObjectsAt(getWidth(), 165, Mist.class).size() == 0)
            {
                Mist mist = new Mist();
                addObject(mist, getWidth(), 129);
            }
        }
        else if(getClass() == Level4.class)
        {
            if(getObjectsAt(getWidth(), 165, Clouds.class).size() == 0)
            {
                Clouds clouds = new Clouds();
                addObject(clouds, getWidth(), 74);
            }
        }
    }
    
    /**
     * Método de acceso a la variable yGround.
     */
    public int getYground()
    {
        return yGround;
    }
    
    /**
     *  Método de acceso a la variable distance.
     */
    public int getDistance()
    {
        return distance;
    }
    
    /**
     * 
     */
    public void setDistance(int distance)
    {
        this.distance = distance;
    }
}

