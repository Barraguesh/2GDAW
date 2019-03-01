/**
 * @author Barraguesh
 * @version %I% %G%
 * @since v0.2 alpha
 */
package BDStuff;
import Classes.Icon;
import java.sql.*;

public class StatsDB {
    //static DBConnection conn;
    //private Statement stat;
    //private ResultSet resul;
    //private PreparedStatement prep;
    
    /**
     * Deletes everything in the Stats table
     * @throws Exception Generic SQL exception
     */
    public void  EmptyStatsTable() throws Exception{
        DBConnection conn = new DBConnection();
        Statement stat = conn.getConnection().createStatement();
        stat.executeUpdate("DELETE FROM STATS");
        conn.Disconnect();
        stat.close();
    }
    
    /**
     * Loads Hazard stats in the database
     * @param name The name of the Icon to load
     * @param attack The attack stat of the Icon
     * @param defense The defense stat of the Icon
     * @param lifepoints The life points stat of the icon
     * @throws Exception Generic SQL exception
     */
    public void LoadDB(String name, int attack, int defense, int lifepoints) throws Exception{
        DBConnection conn = new DBConnection();
        PreparedStatement prep = conn.getConnection().prepareStatement("INSERT INTO stats VALUES (?,?,?,?)");
        prep.setString(1, name);
        prep.setInt(2, attack);
        prep.setInt(3, defense);
        prep.setInt(4, lifepoints);
        prep.executeUpdate();
        conn.Disconnect();
        prep.close();
    }
    
    /**
     * Gets the given name icon stats of the DB
     * @param name The name of the icon for the query
     * @return The object with the stats of the DB
     * @throws Exception Generic SQL exception
     */
    public Icon GetStatsDB(String name) throws Exception{
        DBConnection conn = new DBConnection();        
        Statement stat = conn.getConnection().createStatement();        
        ResultSet resul = stat.executeQuery("SELECT * FROM STATS WHERE LOWER(NAME)='" +  name + "'");
        Icon i = null;
        while (resul.next()){
            i = new Icon();
            i.setAttack(resul.getInt("Attack"));
            i.setDefense(resul.getInt("Defense"));
            i.setLifePoints(resul.getInt("Life points"));
        }
        conn.Disconnect();
        stat.close();
        resul.close();
        return i;
    }
    
    /**
     * Updates the stats of the DB
     * @param name The name of the Icon
     * @param attack The new attack stat of the Icon
     * @param defense The new defense stat of the Icon
     * @param lifepoints The new life points stat of the Icon
     * @throws Exception Generic SQL exception
     */
    public void UpdateStatsDB(String name, int attack, int defense, int lifepoints) throws Exception{
        DBConnection conn = new DBConnection();
        Statement stat = conn.getConnection().createStatement();
        stat.executeUpdate("UPDATE STATS SET ATTACK=" + attack + " , DEFENSE=" + defense + " , `LIFE POINTS`=" + lifepoints + " WHERE NAME='" + name + "'");
        System.out.println("New stats for " + name + " loaded in DB: " + attack + "/"+ defense + "/" + lifepoints);
        conn.Disconnect();
        stat.close();
    }
}
