
package dbHelper;

/**
 *
 * @author Kim
 */
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Players;


  


public class ReadRecord {
   
   private Connection conn;
   private ResultSet results;
   private Players players = new Players();
   private int PlayerID;
   
     public ReadRecord(int PlayerID){
 Properties props = new Properties();
      InputStream instr = getClass().getResourceAsStream("dbConn.properties"); 
      try {
         props.load(instr);
      } catch (IOException ex) {
         Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
      }
      try {
         instr.close();
      } catch (IOException ex) {
         Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      String driver = props.getProperty("driver.name");
      String url = props.getProperty("server.name");
      String username = props.getProperty("user.name");
      String passwd = props.getProperty("user.password");
      
      this.PlayerID = PlayerID; 
      
      try {
         Class.forName(driver);
      } catch (ClassNotFoundException ex) {
         Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
      }
      try {
         conn = DriverManager.getConnection(url, username, passwd);
      } catch (SQLException ex) {
         Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
      }
}
     public void doRead(){
        
        try {
            String query = "Select * from Players WHERE PlayerID=?";
            
            PreparedStatement ps = conn.prepareStatement(query);
             
            ps.setInt(1, PlayerID);
             
            this.results = ps.executeQuery();
            this.results.next();
                players.setPlayerID(this.results.getInt("PlayerID"));
                players.setPlayerName(this.results.getString("PlayerName"));
                players.setPlayerPosition(this.results.getString("PlayerPosition"));
                players.setPlayerAge(this.results.getInt("PlayerAge"));
                players.setPlayerTeam(this.results.getString("PlayerTeam"));
                players.setPlayerDraftYear(this.results.getInt("PlayerDraftYear"));
                players.setPlayerDraftRank(this.results.getString("PlayerDraftRank"));
                
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
}
public Players getPlayers(){
      return this.players;
   }
}