import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Esta clase representa al enemigo Zombie y sus habilidades de caminar y atacar.
 * 
 * @author (Evelyn Gomez) 
 * @version (Mayo 2016)
 */
public class Zombie extends Enemie
{
    private ArrayList<GreenfootImage> imgWalking;
    private ArrayList<GreenfootImage> imgAttacking;
    private SimpleTimer timerZombie;
    private SimpleTimer timerImages;
    private boolean hit;
    public Zombie()
    {
        timerImages = new SimpleTimer();
        timerImages.mark();
        timerZombie = new SimpleTimer();
        timerZombie.mark();
        hit = false;
        //Se crea un ArrayList, y se recorre con un ciclo for para ir dando un nombre a cada imagen y posteriormente se va agregando cada elemento a la lista.
        String img = "";
        imgWalking = new ArrayList();
        for(int i = 0; i<9; i++)
        {
            img = "zombie" + i + ".png";
            imgWalking.add(new GreenfootImage(img));
        }
        
        this.setImage(imgWalking.get(0));
        
        imgAttacking = new ArrayList();
        img = "";
        for(int i = 0; i<=6; i++)
        {
            img = "hitZomb" + i + ".png";
            imgAttacking.add(new GreenfootImage(img));
        
        }
    }
    
    /**
     * Ejecuta siempre los métodos que manda llamar.
     */
    public void act() 
    {
        scrollObjects();
        if(getOneObjectAtOffset(0, 0, KillerQueen.class) != null)
        {
            attackImages();
            hit = true;
        }
        else 
        {
           walk();
           hit = false;
        }
        remove(this);
    }    
    
     /**
     * Este método se encarga de asignar las imágenes a Zombie para simular el movimiento del enemigo caminando.
     * Se utiliza la clase SimpleTimer, cada que pasan 200 milisegundos, hay un condicional verifica que la imagen actual del objeto sea igual a la imagen de la lista 
     * de imágenes declarada en el constructor, iniciando en el índice 0. Si es verdadero entonces actualiza la imagen del índice siguiente y asi sucesivamente hasta llegar 
     * al índice 8, que es el número total de la lista, y posteriormente comienza en el índice 1 y se inicia el timer nuevamente. Esto se repite siempre.
     */
    private void walk()
    {
        if(timerImages.millisElapsed() > 200)
        {
            for(GreenfootImage img : imgAttacking)
            if (this.getImage() == img)
                 this.setImage(imgWalking.get(0));
                
            if (this.getImage() == imgWalking.get(0))
                this.setImage(imgWalking.get(1));
            else if (this.getImage() == imgWalking.get(1))
                this.setImage(imgWalking.get(2));
            else if (this.getImage() == imgWalking.get(2))
                this.setImage(imgWalking.get(3));
            else if (this.getImage() == imgWalking.get(3))
                this.setImage(imgWalking.get(4));
            else if (this.getImage() == imgWalking.get(4))
                this.setImage(imgWalking.get(5));
            else if (this.getImage() == imgWalking.get(5))
                this.setImage(imgWalking.get(6));
            else if (this.getImage() == imgWalking.get(6))
                this.setImage(imgWalking.get(7));
            else if (this.getImage() == imgWalking.get(7))
                this.setImage(imgWalking.get(8));
             else if (this.getImage() == imgWalking.get(8))
                this.setImage(imgWalking.get(1));    
            timerImages.mark();
        }
    }
    
    /**
     * Este método se encarga de asignar las imágenes a Zombie para simular el movimiento del enemigo atacando.
     * Se utiliza la clase SimpleTimer, cada que pasan 200 milisegundos, hay un condicional verifica que la imagen actual del objeto sea igual a la imagen de la lista 
     * de imágenes declarada en el constructor, iniciando en el índice 0. Si es verdadero entonces actualiza la imagen del índice siguiente y asi sucesivamente hasta llegar 
     * al índice 12, que es el número total de la lista, y posteriormente comienza en el índice 1 y se inicia el timer nuevamente. Esto se repite siempre.
     */
    private void attackImages()
    {
        if(timerImages.millisElapsed() > 100)
        {
          for (GreenfootImage img : imgWalking)
            if(this.getImage() == img)
                this.setImage(imgAttacking.get(0));
            
          if (this.getImage() == imgAttacking.get(0))
               this.setImage(imgAttacking.get(1));
          else if (this.getImage() == imgAttacking.get(1))
               this.setImage(imgAttacking.get(2));
          else if (this.getImage() == imgAttacking.get(2))
               this.setImage(imgAttacking.get(3));
          else if (this.getImage() == imgAttacking.get(3))
               this.setImage(imgAttacking.get(4));
          else if (this.getImage() == imgAttacking.get(4))
               this.setImage(imgAttacking.get(5));
          else if (this.getImage() == imgAttacking.get(5))
               this.setImage(imgAttacking.get(6));
          else if (this.getImage() == imgAttacking.get(6))
               this.setImage(imgAttacking.get(1));
          timerImages.mark();
        }
    }
    
    /**
     * Verifica si el objeto Killer Queen está cerca de este objeto y llama al método attackImages(), para simluar el movimiento de ataque.
     */
    private void attack()
    {
       if(getOneObjectAtOffset(0, 0, KillerQueen.class) != null)
        {
            attackImages();
            hit = true;
        }
        else 
        {
           walk();
           hit = false;
        } 
    }
}
