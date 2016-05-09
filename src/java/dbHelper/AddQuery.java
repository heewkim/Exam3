
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
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Players;


public class AddQuery {
    private Connection conn;
   
   public AddQuery()
   {
      Properties props = new Properties();
      InputStream instr = getClass().getResourceAsStream("dbConn.properties");
         try {
            props.load(instr);
         } catch (IOException ex) {
            Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
            instr.close();
         } catch (IOException ex) {
            Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
         }
      
      String driver = props.getProperty("driver.name");
      String url = props.getProperty("server.name");
      String username = props.getProperty("user.name");
      String passwd = props.getProperty("user.password");
      
      
      try {
         Class.forName(driver);
      } catch (ClassNotFoundException ex) {
         Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
      }
      try {
         conn = DriverManager.getConnection(url, username, passwd);
      } catch (SQLException ex) {
         Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
      }
   }
   public void doAdd (Players players)
   {
      try {
         String query = "INSERT INTO Players (PlayerName,PlayerPosition,PlayerAge,PlayerTeam,PlayerDraftYear,PlayerDraftRank) VALUES (?, ?, ?, ?,?,?)";
         
         PreparedStatement ps = conn.prepareStatement(query);
         
             ps.setString(1,players.getPlayerName());
             ps.setString(2,players.getPlayerPosition());
             ps.setInt(3,players.getPlayerAge());
             ps.setString(4,players.getPlayerTeam());
             ps.setInt(5,players.getPlayerDraftYear());
             ps.setString(6,players.getPlayerDraftRank());
         
         ps.executeUpdate();
         
      } catch (SQLException ex) {
         Logger.getLogger(AddQuery.class.getName()).log(Level.SEVERE, null, ex);
      }
   }
}
