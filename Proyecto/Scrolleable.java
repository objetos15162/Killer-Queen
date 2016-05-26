import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.image.*;
import java.awt.Graphics2D;
import java.util.List;

/**
 * Superclase Scrolleable. Se encarga de realizar el scroll de los objetos.
 * 
 * @author (Evelyn Gomez) 
 * @version (Mayo 2016)
 */
public abstract class Scrolleable extends Actor
{    
 
    /**
     * 
     */
    public void act() 
    {
        
    }    
    
    /**
     * Hace que los objetos se muevan hacia la izquierda.
     */
    public void scrollObjects()
    {
        move(-3);
    }
    
    /**
     * Hace que las decoraciones se muevan a la izquierda un poco más lento.
     */
     public void moveDecoration()
    {
        move(-1);
    }
    
    /**
     * Verifica cuando un actor ha llegado al borde de la pantalla y lo elimina.
     */
    public void remove(Actor actor)
    {
       if(actor.getX() <= 3  )
           getWorld().removeObject(this);
    }
    
    /**
     * Se encarga de simular que el piso se mueve hacia la izquierda y desaparece. A partir de la imagen original, crea una nueva, la recorta a la mitad, y la va posicionando en
     * el borde izquierdo de la pantalla, lo que simula el scroll del suelo.
     */
    public void removeGround(Actor actor)
    {  
        if(actor.isAtEdge() && actor.getImage().getWidth() != 2)
        {
            int width = actor.getImage().getWidth();
            int height = actor.getImage().getHeight();
            BufferedImage imgAnt = actor.getImage().getAwtImage();
            BufferedImage imgNueva = imgAnt.getSubimage(width/2, 0, width/2, height);
            GreenfootImage gImage = new GreenfootImage(imgNueva.getWidth(), imgNueva.getHeight());
            BufferedImage gBufImg = gImage.getAwtImage();
            Graphics2D graphics = (Graphics2D)gBufImg.getGraphics();
            graphics.drawImage(imgNueva, null, 0, 0);
            actor.setImage(gImage);
            actor.setLocation(0 + actor.getImage().getWidth()/2, getWorld().getHeight() - actor.getImage().getHeight()/2);
        }
        
        if(actor.getImage().getWidth() == 2)
            getWorld().removeObject(this);  
            
        
    }
    
}





