import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.awt.Color;
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
    private Counter timerDisplay;//Muestra el tiempo.
    private SimpleTimer timerWin;//Determina cuando se supera el nivel.
    private Counter trappedCoin;//Contador de monedas atrapadas.
    private Label labelCoin;//Muestra monedas atrapadas.
    private CoinNotMovable coinTrapped;
    
    /**
     * Constructor for objects of class Levels.
     * 
     */
    public Levels()
    {    
        super(850, 500, 1);
        yGround = getHeight() - 54;
        killer = new KillerQueen();
        addObject(killer, 90, yGround - killer.getImage().getHeight());
        timerCoins= new SimpleTimer();
        timerCoins.mark();
        DrawLifes(5);
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
        labelCoin.setFillColor(Color.WHITE);
        labelCoin.setLineColor(Color.WHITE);
        setPaintOrder(KillerQueen.class);
    }
    
    public void act()
    {
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
           //if(timerCoins.millisElapsed() > Greenfoot.getRandomNumber(20000)+1000)
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
}
