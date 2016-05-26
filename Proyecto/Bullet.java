import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa las balas del arma de Killer Queen
 * 
 * @author (Evelyn Gómez) 
 * @version (Mayo 2016)
 */
public class Bullet extends Actor
{
    private boolean active;
    private SimpleTimer timerDie;
    private int enemiesKilled;
    public Bullet()
    {
       enemiesKilled = 0;
    }
    
    /**
     * Ejecuta siempre los métodos que manda llamar.
     */
    public void act() 
    {
        active = true;
        setImage("bullet_1.png");
        //updateEnemies();
        move(5);
        removeEnemies();
           
        if(this.isAtEdge())
        {
            getWorld().removeObject(this);
            
        }
        
    }    
    
    /**
     * Verifica si esta tocando la clase enemigos y los elimina.
     */
    private void removeEnemies()
    {
        if(isTouching(Enemie.class) && active == true)
        {
            removeTouching(Enemie.class);
            active = false;
            this.setLocation(getWorld().getWidth(), 0);
        }
        
    }

    
    public void setEnemiesKilled()
    {
        this.enemiesKilled = enemiesKilled;
    }
    
    public int getEnemiesKilled()
    {
        return enemiesKilled;
    }
   
}