import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class KillerQueen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KillerQueen extends Actor
{
    private ArrayList<GreenfootImage> imgRunning; //Lista de imágenes que simulan movimiento de Killer 
    private SimpleTimer timerImagesRun; // Timer que actualiza las imágenes de Killer Queen
    private int lifes; //Vidas de Kiler Queen
    private boolean attacked; // Verifica si Killer Queen es atacada
    private boolean jumping;
    private SimpleTimer timerAttacked;//Timer que da el tiempo de recuperación a Kiler Queen
    private Counter counterCoin;
    private int trappedCoins;
    private SimpleTimer timerJump;
    private ArrayList<GreenfootImage> imgJumping;//Arreglo de imágenes que simula salto.
    private SimpleTimer timerJumped;
    private int jumpingTime;
    
    public KillerQueen()
    {
        jumpingTime = 600;
        timerImagesRun = new SimpleTimer();
        timerImagesRun.mark();
        timerAttacked = new SimpleTimer();
        lifes = 5;
        jumping = false;
        trappedCoins = 0;
        counterCoin = new Counter();
        attacked= false;
        timerJumped = new SimpleTimer();
        timerJumped.mark();
        //Se crea un ArrayList, y se recorre con un ciclo for para ir dando un nombre a cada imagen y posteriormente se va agregando cada elemento a la lista.
        imgRunning = new ArrayList();
        String img = "";
        for(int i = 0; i<9; i++)
        {
            img = "Run" + i + ".png";
            imgRunning.add(new GreenfootImage(img));
        }
        
        imgJumping = new ArrayList();
        img = "";
        for(int i = 0; i<9; i++)
        {
            img = "jump" + i + ".png";
            imgJumping.add(new GreenfootImage(img));
        }
        
        //Primer imagen de la lista que se asigna a Killer Queen.
        this.setImage(imgRunning.get(0));
        timerJump = new SimpleTimer();
        timerJump.mark();
        
    }
    
    /**
     * Se manda llamar a run(), donde se simula el movimiento de Killer Queen.
     * Se encarga de verificar cuando un enemigo ataca a Killer Queen, y por lo tanto actualiza las vidas, las cuales son dibujadas en el mundo, cuando se manda llamar 
     * al método DrawLifes().
     * El boleano attacked se inicializa en falso. Este nos ayuda a dar un tiempo de recuperación a Killer Queen cuando es atacada, para que durante ese pequeño lapso de
     * tiempo los enemigos no puedan atacarla. 
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("space"))
        {
            if( jumping == false)
            {
                 jumping = true;
                 timerJumped.mark();
            }
        }
        
        jump();
        if( jumping == true)
        {  
            jumpImages();
        }
        else
        {
            run();
        }
        
        if(attacked == false)
        {
            if(isTouching(Skeleton.class))
            {
                lifes -= 1;
                ((Level1)getWorld()).DrawLifes(lifes); 
                attacked = true;
                timerAttacked.mark();
                
            }
            if(isTouching(Zombie.class))
            {
                lifes -= 1;
                ((Level2)getWorld()).DrawLifes(lifes);
                attacked = true;
                timerAttacked.mark();
            }
            if(isTouching(Vampires.class))
            {
                lifes -= 1;
                ((Level3)getWorld()).DrawLifes(lifes);
                attacked = true;
                timerAttacked.mark();
            }
            
        }
        else
        {
          if(timerAttacked.millisElapsed()>4000)
            attacked = false;
          else
            attacked = true;  
            
        }
       
        if(isTouching(Coin.class))
        {
            trappedCoins++;
            removeTouching(Coin.class);
            ((Levels)getWorld()).updateCoins();
            counterCoin.setValue(trappedCoins);
        }
    }
    
  
    /**
     * Este método se encarga de asignar las imágenes a Killer Queen para simular el movimiento del jugador corriendo.
     * Se utiliza la clase SimpleTimer, cada que pasan 200 milisegundos, hay un condicional verifica que la imagen actual del objeto sea igual a la imagen de la lista 
     * de imágenes declarada en el constructor, iniciando en el índice 0. Si es verdadero entonces actualiza la imagen del índice siguiente y asi sucesivamente hasta llegar 
     * al índice 8, que es el número total de la lista, y posteriormente comienza en el índice 1 y se inicia el timer nuevamente. Esto se repite siempre.
     */
    public void run()
    {
       if(timerImagesRun.millisElapsed() > 200)
        {
          for (GreenfootImage img : imgJumping)
            if(this.getImage() == img)
                this.setImage(imgRunning.get(0));  
            
          if (this.getImage() == imgRunning.get(0))
               this.setImage(imgRunning.get(1));
          else if (this.getImage() == imgRunning.get(1))
               this.setImage(imgRunning.get(2));
          else if (this.getImage() == imgRunning.get(2))
               this.setImage(imgRunning.get(3));
          else if (this.getImage() == imgRunning.get(3))
               this.setImage(imgRunning.get(4));
          else if (this.getImage() == imgRunning.get(4))
               this.setImage(imgRunning.get(5));
          else if (this.getImage() == imgRunning.get(5))
               this.setImage(imgRunning.get(6));
          else if (this.getImage() == imgRunning.get(6))
               this.setImage(imgRunning.get(7));
          else if (this.getImage() == imgRunning.get(7))
               this.setImage(imgRunning.get(8));
          else if (this.getImage() == imgRunning.get(8))
               this.setImage(imgRunning.get(1));
          timerImagesRun.mark();
        }
    }
    
    private void jumpImages()
    {
        if(timerImagesRun.millisElapsed() > 200)
        {
          for (GreenfootImage img : imgRunning)
            if(this.getImage() == img)
                this.setImage(imgJumping.get(0));
            
          if (this.getImage() == imgJumping.get(0))
               this.setImage(imgJumping.get(1));
          else if (this.getImage() == imgJumping.get(1))
               this.setImage(imgJumping.get(2));
          else if (this.getImage() == imgJumping.get(2))
               this.setImage(imgJumping.get(3));
          else if (this.getImage() == imgJumping.get(3))
               this.setImage(imgJumping.get(4));
          else if (this.getImage() == imgJumping.get(4))
               this.setImage(imgJumping.get(5));
          else if (this.getImage() == imgJumping.get(5))
               this.setImage(imgJumping.get(6));
          else if (this.getImage() == imgJumping.get(6))
               this.setImage(imgJumping.get(7));
          else if (this.getImage() == imgJumping.get(7))
               this.setImage(imgJumping.get(8));
          else if (this.getImage() == imgJumping.get(8))
               this.setImage(imgJumping.get(1));
          timerImagesRun.mark();
        }
    }
    
    
    public void jump()
    {
        if (jumping == true && timerJumped.millisElapsed() < jumpingTime && getY() > getWorld().getHeight()/2)
        {
            this.setLocation(getX(), getY() - 3);
        }
        else if(timerJumped.millisElapsed() > jumpingTime && getY() < getWorld().getHeight() - 137)
        {
           this.setLocation(getX(), this.getY() + 3);
        }
       
  
        if( this.getY() >= getWorld().getHeight() - 137)
            jumping = false;
    }
    
     /**
     * Método de acceso a las monedas atrapadas.
     * @return trappedCoins El número total de monedas atrapadas.
     */
    public int getTrappedCoins()
    {
        return trappedCoins;
    }
    
}   













