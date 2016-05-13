import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class CoinNotMovable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CoinNotMovable extends Actor
{
    private SimpleTimer timerCoins;
    private ArrayList<GreenfootImage> coinTurning;
    public CoinNotMovable()
    {
      timerCoins = new SimpleTimer();
      coinTurning = new ArrayList();
      String img = "";
      for(int i = 0; i<6; i++)
      {
          img = "Coin" + i + ".png";
          coinTurning.add(new GreenfootImage(img));
      }
      this.setImage(coinTurning.get(0));
    }
    
    /**
     * Act - do whatever the CoinNotMovable wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        turn();
    }  
    
    public void turn()
    {
        if(timerCoins.millisElapsed() > 200)
        {
            if(this.getImage() == coinTurning.get(0))
                this.setImage(coinTurning.get(1));
            else if(this.getImage() == coinTurning.get(1))
                this.setImage(coinTurning.get(2));
            else if(this.getImage() == coinTurning.get(2))
                this.setImage(coinTurning.get(3));
            else if(this.getImage() == coinTurning.get(3))
                this.setImage(coinTurning.get(4));
            else if(this.getImage() == coinTurning.get(4))
                this.setImage(coinTurning.get(5));
            else if(this.getImage() == coinTurning.get(5))
                this.setImage(coinTurning.get(0));
            timerCoins.mark();   
        }
    }
}
