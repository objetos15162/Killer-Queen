import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.image.*;
import java.awt.Graphics2D;
import java.util.List;

/**
 * Write a description of class Scrolleable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Scrolleable extends Actor
{    
 
    /**
     * Act - do whatever the Scrolleable wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }    
    
    public void scrollObjects()
    {
        move(-3);
    }
    
     public void moveDecoration()
    {
        move(-1);
    }
    
    public void remove(Actor actor)
    {
        /*
       if (actor.getClass() == Clouds.class || actor.getClass() == Fog.class || actor.getClass() == Mist.class)
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
                actor.setLocation(actor.getImage().getWidth()/2 , 165);
            }
            
            if(actor.getImage().getWidth() == 2)
            getWorld().removeObject(this);  
        } */
        
       if(actor.getX() <= 3 && actor.getClass() != Clouds.class && actor.getClass() != Fog.class && actor.getClass() != Mist.class )
           getWorld().removeObject(this);
    }
    
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





