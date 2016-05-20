import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Esta clase se encarga de darle todas las habilidades a Killer Queen, brincar, correr y disparar.
 * A
 * 
 * @author (Evelyn Gómez) 
 * @version Mayo 2016)
 */
public class KillerQueen extends Actor
{
    private ArrayList<GreenfootImage> imgRunning; //Lista de imágenes que simulan movimiento de Killer 
    private ArrayList<GreenfootImage> imgDying;
    private ArrayList<GreenfootImage> imgShooting;
    private SimpleTimer timerImages; // Timer que actualiza las imágenes de Killer 
    private int lifes; //Vidas de Kiler Queen
    private boolean attacked; // Verifica si Killer Queen es atacada
    private boolean jumping;
    private SimpleTimer timerAttacked;//Timer que da el tiempo de recuperación a Kiler Queen
    private Counter counterCoin;
    private int trappedCoins;
    private SimpleTimer timerJump;
    private SimpleTimer timerDied;
    private SimpleTimer timerShoot;
    private ArrayList<GreenfootImage> imgJumping;//Arreglo de imágenes que simula salto.
    private SimpleTimer timerJumped;
    private int jumpingTime;
    private boolean died;
    private boolean shoot;
    
    public KillerQueen()
    {
        jumpingTime = 600;
        timerImages = new SimpleTimer();
        timerImages.mark();
        timerAttacked = new SimpleTimer();
        timerDied = new SimpleTimer();
        timerShoot = new SimpleTimer();
        lifes = 5;
        jumping = false;
        trappedCoins = 0;
        counterCoin = new Counter();
        attacked= false;
        died = false;
        shoot = false;
        timerJumped = new SimpleTimer();
        timerJumped.mark();
        //Se crea un ArrayList, y se recorre con un ciclo for para ir dando un nombre a cada imagen y posteriormente se va agregando cada elemento a la lista.
        imgRunning = createImagesArray(9, "Run");
        imgJumping = createImagesArray(9, "jump");
        imgDying = createImagesArray(9, "dead");
       
        this.setImage(imgRunning.get(0));
        timerJump = new SimpleTimer();
        timerJump.mark();
        
    }
    
    private ArrayList createImagesArray(int imgNumber, String imgName)
    {
        ArrayList<GreenfootImage> imgArray = new ArrayList();
        String img = "";
        for(int i = 0; i<imgNumber; i++)
        {
            img = imgName + i + ".png";
            imgArray.add(new GreenfootImage(img));
        }
        
        return imgArray;
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
        die();
        if(!died)
        {
            verifyJump();
            verifyAttack();
            verifyTrappedCoins();
            verifyShoot();
        }  
    }     
           
     /**
     * Este método se encarga de asignar las imágenes a Killer Queen para simular el movimiento del jugador corriendo.
     * Se utiliza la clase SimpleTimer, cada que pasan 200 milisegundos, hay un condicional verifica que la imagen actual del objeto sea igual a la imagen de la lista 
     * de imágenes declarada en el constructor, iniciando en el índice 0. Si es verdadero entonces actualiza la imagen del índice siguiente y asi sucesivamente hasta llegar 
     * al índice 8, que es el número total de la lista, y posteriormente comienza en el índice 1 y se inicia el timer nuevamente. Esto se repite siempre.
     */
    private void run()
    {
       if(timerImages.millisElapsed() > 200)
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
          timerImages.mark();
        }
    }
    
    private void jumpImages()
    {
        if(timerImages.millisElapsed() > 200)
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
          timerImages.mark();
        }
    }
    
    private void jump()
    {
        if(jumping == true && timerJumped.millisElapsed() < jumpingTime && getY() > getWorld().getHeight()/2)
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
    
    private void verifyJump()
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
    }
    
    private void dieImages()
    {
       if(timerImages.millisElapsed() > 200)
       {
          for(GreenfootImage img : imgRunning)
            if(this.getImage() == img)
                this.setImage(imgDying.get(0));
          for(GreenfootImage img : imgJumping)
            if(this.getImage() == img)
                this.setImage(imgDying.get(0));
                
          if (this.getImage() == imgDying.get(0))
               this.setImage(imgDying.get(1));
          else if (this.getImage() == imgDying.get(1))
               this.setImage(imgDying.get(2));
          else if (this.getImage() == imgDying.get(2))
               this.setImage(imgDying.get(3));
          else if (this.getImage() == imgDying.get(3))
               this.setImage(imgDying.get(4));
          else if (this.getImage() == imgDying.get(4))
               this.setImage(imgDying.get(5));
          else if (this.getImage() == imgDying.get(5))
               this.setImage(imgDying.get(6));
          else if (this.getImage() == imgDying.get(6))
               this.setImage(imgDying.get(7));
          else if (this.getImage() == imgDying.get(7))
               this.setImage(imgDying.get(8));
          else if (this.getImage() == imgDying.get(8))
               this.setImage(imgDying.get(1));
          timerImages.mark();
       }
    }
    
    private void die()
    {
        if(died)
            dieImages();
        
        if(lifes == 0 && !died)
        {
            died = true;
            timerDied.mark();
        }
        
        if(died && timerDied.millisElapsed() > 1600)
        {
            GameOver worldGameOver = new GameOver();
            Greenfoot.setWorld(worldGameOver);
        }
    }
    
    private void shootImages()
    {
       if(timerImages.millisElapsed() > 200)
       {
          for(GreenfootImage img : imgRunning)
            if(this.getImage() == img)
                this.setImage(imgShooting.get(0)); 
       
          if (this.getImage() == imgShooting.get(0))
               this.setImage(imgShooting.get(1));
          else if (this.getImage() == imgShooting.get(1))
               this.setImage(imgShooting.get(2));
          else if (this.getImage() == imgShooting.get(2))
               this.setImage(imgShooting.get(0));   
       }         
    }
    
    private void verifyShoot()
    {
        if(Greenfoot.isKeyDown("shift") && !shoot && !jumping)
        {
             shoot = true;
             timerShoot.mark();
             Bullet bullet = new Bullet();
             getWorld().addObject(bullet, 95, 368);
        }
        if(timerShoot.millisElapsed() > 300 && shoot)
        {
            shoot = false;
        }
    }
    
    private void verifyAttack()
    {
         if(attacked == false)
         {
           if(isTouching(Enemies.class) || isTouching(Obstacles.class))
           {
             lifes -= 1;
             ((Levels)getWorld()).DrawLifes(lifes); 
             attacked = true;
             timerAttacked.mark();
            }
         }
    }
    
    private void verifyTrappedCoins()
    {
         if(isTouching(Coin.class))
            {
                trappedCoins++;
                removeTouching(Coin.class);
                ((Levels)getWorld()).updateCoins();
                counterCoin.setValue(trappedCoins);
            } 
    }
    
     /**
     * Método de acceso a las monedas atrapadas.
     * @return trappedCoins El número total de monedas atrapadas.
     */
    public int getTrappedCoins()
    {
        return trappedCoins;
    }
    
    /**
     * Método de acceso a las vidas de Killer Queen.
     * @return lifes Vidas de KillerQueen.
     */
    public int getLifes()
    {
        return lifes;
    }
    
    public void setLifes(int lifes)
    {
        this.lifes = lifes;
    }
    
    
}   













