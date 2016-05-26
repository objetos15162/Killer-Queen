import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Esta clase se encarga de darle todas las habilidades a Killer Queen, brincar, correr y disparar.
 * Asigna imágenes que simulan todos los tipos de movimientos de este objeto.
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
    private UserRecords records;
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
        records = new UserRecords();
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
     * Está ejecutando siempre los métodos que manda llamar. Si ha muerto solo ejecuta el método die().
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
    
    /**
     * Este método se encarga de asignar las imágenes a Killer Queen para simular el movimiento del jugador saltando.
     * Se utiliza la clase SimpleTimer, cada que pasan 200 milisegundos, hay un condicional verifica que la imagen actual del objeto sea igual a la imagen de la lista 
     * de imágenes declarada en el constructor, iniciando en el índice 0. Si es verdadero entonces actualiza la imagen del índice siguiente y asi sucesivamente hasta llegar 
     * al índice 8, que es el número total de la lista, y posteriormente comienza en el índice 1 y se inicia el timer nuevamente. Esto se repite siempre.
     */
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
    
    /**
     * En este método, se le da la habilidad a Killer Queen de saltar. Cuando se cumplen los condicionales, se le da una nueva posición a Killer hacia arriba, y al concluir el
     * tiempo dado, regresa a su posición inicial , lo que hace la simulación del salto.
     */
    private void jump()
    {
        if(jumping == true && timerJumped.millisElapsed() < jumpingTime && getY() > getWorld().getHeight()/2)
        {
            this.setLocation(getX(), getY() - 4);
        }
        else if(timerJumped.millisElapsed() > jumpingTime && getY() < getWorld().getHeight() - 137)
        {
           this.setLocation(getX(), this.getY() + 3);
        }
       
  
        if( this.getY() >= getWorld().getHeight() - 137)
            jumping = false;
    }
    
    /**
     * Este método verifica con un booleano si la tecla "space" ha sido presionada. Si es así, se ejecuta el método jump, así como el método jumpImages(), donde se asignan las 
     * imágenes que simulan el movimiento de salto de Killer Queen. De lo contrario se ejecuta el método run(), donde se simula el movimiento de Killer Queen corriendo.
     */
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
    
   /**
    * Este método se encarga de asignar las imágenes a Killer Queen para simular el movimiento del jugador muriendo.
    * Se utiliza la clase SimpleTimer, cada que pasan 200 milisegundos, hay un condicional verifica que la imagen actual del objeto sea igual a la imagen de la lista 
    * de imágenes declarada en el constructor, iniciando en el índice 0. Si es verdadero entonces actualiza la imagen del índice siguiente y asi sucesivamente hasta llegar 
    * al índice 8, que es el número total de la lista, y posteriormente comienza en el índice 1 y se inicia el timer nuevamente. Esto se repite siempre.
    */ 
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
   
   /**
    * Este método se encarga de verificar con un boleeano si el jugador ha perdido todas sus vidas. Si es verdadero, ejecuta el método dieImages(), que simula el movimiento del 
    * jugador muriendo. Después del tiempo especificado, crea un mundo GameOver y lo asigna.
    */
   private void die()
   {
        if(died)
        { dieImages();
          records.saveRecords(((Level)getWorld()).getDistance()); 
        }
        
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
   
   /**
    * Este método se encarga de asignar las imágenes a Killer Queen para simular el movimiento del jugador disparando.
    * Se utiliza la clase SimpleTimer, cada que pasan 200 milisegundos, hay un condicional verifica que la imagen actual del objeto sea igual a la imagen de la lista 
    * de imágenes declarada en el constructor, iniciando en el índice 0. Si es verdadero entonces actualiza la imagen del índice siguiente y asi sucesivamente hasta llegar 
    * al índice 2, que es el número total de la lista, y posteriormente comienza en el índice 1 y se inicia el timer nuevamente. Esto se repite siempre.
    */
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
   
   /**
    * Este método verifica si la tecla "shift" hasido presionada. Si es así, y el jugador no esta brincando, agrega un objeto Bullet al mundo, lo que simula que esta disparando.
    * Utiliza un timer el cual verifica que solo se agregue el objeto Bullet después de cierto tiempo, para evitar que el jugador dispare y aparezcan muchas balas al mismo tiempo.
    */
   private void verifyShoot()
   {
        if(Greenfoot.isKeyDown("shift") && !shoot && !jumping)
        {
             shoot = true;
             timerShoot.mark();
             Bullet bullet = new Bullet();
             getWorld().addObject(bullet, 95, 363);
        }
        if(timerShoot.millisElapsed() > 300 && shoot)
        {
            shoot = false;
        }
   }
   
   /**
    * Este método se encarga de dar un tiempo de recuperación a Killer Queen cuando ha sido atacada.
    */
   private void verifyAttack()
   {
         
        if(attacked == false)
         {
            
           if(isTouching(Enemie.class) || isTouching(Obstacles.class))
           {
             lifes -= 1;
             ((Level)getWorld()).DrawLifes(lifes); 
             attacked = true;
             timerAttacked.mark();
             
            }
           
         }
         
        if(timerAttacked.millisElapsed() > 4000)
            attacked = false;
        
   }
   
   /**
    * Este método se encarga de llevar la cuenta de monedas que han sido atrapadas. Si Killer Queen toca al objeto Coin, se incrememta la variable trappedCoins, y se actualiza el 
    * contador de monedas atrapadas.
    */
   private void verifyTrappedCoins()
   {
         if(isTouching(Coin.class))
         {
            trappedCoins++;
            removeTouching(Coin.class);
            ((Level)getWorld()).updateCoins();
            counterCoin.setValue(trappedCoins);
            if(trappedCoins == 50)
            {
                lifes++;
                ((Level)getWorld()).DrawLifes(lifes);
                trappedCoins = 0;
            }
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
    
   /**
     * Método de modificación a las vidas de Killer Queen.
   */
   public void setLifes(int lifes)
   {
       this.lifes = lifes;
   }
    
}   













