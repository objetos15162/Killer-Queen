import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;
import java.awt.image.*;
import java.awt.Graphics2D;

/**
 * Write a description of class Levels here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Levels extends World
{
    private KillerQueen killer;
    private SimpleTimer timerCoins;//Agrega monedas aleatorias.
    public int yGround;
    private List<Life> lHearts;//Arreglo de vidas.
    private Coin coin;
    public Counter timerDisplay;//Muestra el tiempo.
    private SimpleTimer timerWin;//Determina cuando se supera el nivel.
    private Counter trappedCoin;//Contador de monedas atrapadas.
    private Label labelCoin;//Muestra monedas atrapadas.
    private CoinNotMovable coinTrapped;
    private GameOver gameOver;
    private SimpleTimer timerDie;
    //private int number;
    private boolean die;
    private Ground ground;
    /**
     * Constructor for objects of class Levels.
     * 
     */
    public Levels()
    {    
        super(850, 500, 1);
        die = false;
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
        //Label y contador que muestran las monedas que han sido atrapadas.
        labelCoin = new Label("",25);
        addObject(labelCoin, 80, 66);
        coinTrapped = new CoinNotMovable();
        addObject(coinTrapped,46,65);
        labelCoin.setValue(0);
        labelCoin.setFillColor(Color.RED);
        labelCoin.setLineColor(Color.RED);
        setPaintOrder(KillerQueen.class, Enemies.class, Obstacles.class, Life.class, Coin.class);
        ground = new Ground();
         for(int i=0; i<4; i++)
        {
            addObject(new Ground(),256 * i , yGround);
        }
    }
    
    public void updateTime()
    {
       if(timerWin.millisElapsed() > 1000)
        {
            timerDisplay.add(1);
            timerWin.mark();
        }
    }
    
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
     * de la clase Life, los elimina y con el parámetro lifes dibuja las vidas actuales de Killer Queen.
     * @param lifes vidas de Killer Queen.
     */
    public void DrawLifes(int lifes)
    {
        lHearts = getObjects(Life.class);
        removeObjects(lHearts);
        //Dibuja las vidas en la parte superior izquierda de la pantalla.
        int x,y;
        x=20;
        for(int i=0; i<lifes; i ++)
         {
             addObject(new Life(), x ,20);
             x += 37; 
         }     
    }
    
    private void DrawCoins(int num)
    {
        int xi = getWidth();
        for(int i = 0; i<num ;i++){
             addObject(new Coin(),xi + 32,yGround -125);
             xi += 32;
        }
           
    }
    
    public void updateCoins()
    {
        labelCoin.setValue(killer.getTrappedCoins());
    }
    
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
   
}
 

