import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Skeleton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Skeleton extends Enemies
{
    private ArrayList<GreenfootImage> imgRunning;
    private SimpleTimer timerImages;
    private SimpleTimer timerSkel;
    
    public Skeleton()
    {
        timerImages = new SimpleTimer();
        timerImages.mark();
        timerSkel = new SimpleTimer();
        timerSkel.mark();
        //Se crea un ArrayList, y se recorre con un ciclo for para ir dando un nombre a cada imagen y posteriormente se va agregando cada elemento a la lista.
        String img = "";
        imgRunning = new ArrayList();
        for(int i = 0; i<9; i++)
        {
            img = "SqueletonWalking" + i + ".png";
            imgRunning.add(new GreenfootImage(img));
        }
        //Primer imagen de la lista que se asigna a Skeleton.
        this.setImage(imgRunning.get(0));
        
    }
    
    
    /**
     * Se manda llamar al método run(), que simula el movimiento de Skeleton.
     * Se llama al método move y se le pasa como parámetro un número entero negativo, para que Skeleton se mueva hacia la izquierda, y camine hacia Killer Queen.
     */
    public void act() 
    {
        run();
        scrollObjects();
        remove(this);
    }   
    
        
    /**
     * Este método se encarga de asignar las imágenes a Skeleton para simular el movimiento del enemigo caminando.
     * Se utiliza la clase SimpleTimer, cada que pasan 200 milisegundos, hay un condicional verifica que la imagen actual del objeto sea igual a la imagen de la lista 
     * de imágenes declarada en el constructor, iniciando en el índice 0. Si es verdadero entonces actualiza la imagen del índice siguiente y asi sucesivamente hasta llegar 
     * al índice 8, que es el número total de la lista, y posteriormente comienza en el índice 1 y se inicia el timer nuevamente. Esto se repite siempre.
     */
    public void run()
    {
        if(timerImages.millisElapsed() > 200)
        {
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
}
