import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa los pisos de los distintos escenarios.
 * @author (Evelyn Gomez) 
 * @version (Mayo 2016)
 */
public class Ground extends Scrolleable
{
    /**
     *Ejecuta siempre los métodos que manda llamar.
     */
    public void act() 
    {
        setGroundImages();
        scrollObjects();
        removeGround(this);
    } 
    
    
    /**
     * Verifica en que mundo se encuentra y dependiendo en cual se encuentre, asigna el piso correspondiente.
     */
    
    private void setGroundImages()
    {
        if(getWorld().getClass() == Level1.class)
        {
            setImage("volcan_ground.png");
        }
        else if(getWorld().getClass() == Level2.class)
        {
            setImage("desert_ground.png");
        }
        else if(getWorld().getClass() == Level3.class)
        {
            setImage("winter_ground.png");
        }
        else if(getWorld().getClass() == Level4.class)
        {
            setImage("forest_ground.png");
        }
    }
}
