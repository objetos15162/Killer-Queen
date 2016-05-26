import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UserRecords here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UserRecords extends Actor
{
   private UserInfo jugador;
    
   public UserRecords()
    {
        if(UserInfo.isStorageAvailable() && UserInfo.getMyInfo() != null)
            this.jugador = UserInfo.getMyInfo();
            
    }
   
    /**
     * Guarda un nuevo registro en los records.
     */
   public void saveRecords(int points)
    {
         if((UserInfo.isStorageAvailable()) && (this.jugador != null) && ((points > this.jugador.getScore()) || (this.jugador.getInt(0) == 0))){ 
            this.jugador.setScore(points);
            this.jugador.setInt(0,1); 
            this.jugador.store();
        }
        
        if((UserInfo.isStorageAvailable()) && (this.jugador != null) && (points > this.jugador.getScore()))
        {
            this.jugador.setScore(points);
            this.jugador.setInt(0,1); 
            this.jugador.store();
        }
    }
}
