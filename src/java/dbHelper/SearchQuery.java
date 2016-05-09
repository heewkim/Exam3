
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

/**
 *
 * @author Kim
 */
public class SearchQuery {
     private Connection conn;
     private ResultSet results;
public SearchQuery(){
      
      Properties props = new Properties();
      InputStream instr = getClass().getResourceAsStream("dbConn.properties");
         try {
            props.load(instr);
         } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
            instr.close();
         } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
         }
      
      String driver = props.getProperty("driver.name");
      String url = props.getProperty("server.name");
      String username = props.getProperty("user.name");
      String passwd = props.getProperty("user.password");
      try {
         Class.forName(driver);
      } catch (ClassNotFoundException ex) {
         Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
      }
      try {
         conn = DriverManager.getConnection(url, username, passwd);
      } catch (SQLException ex) {
         Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
      }
      
   }
public void doSearch(String PlayerName){
      
      try {
         String query = "SELECT * FROM Players WHERE UPPER(PlayerName) LIKE ? ORDER BY PlayerID ASC";
         
         PreparedStatement ps = conn.prepareStatement(query);
         ps.setString(1, "%" +PlayerName.toUpperCase() + "%");
         this.results = ps.executeQuery();
      } catch (SQLException ex) {
         Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
      }
      
   }
  public String getHTMLtable(){
        String table ="";
        table += "<table>";
        
        try {
            table += "<tr>";
         
            table += "<th>";
            table += "PlayerID";
            table += "</th>";
            
            table += "<th>";
            table += "PlayerName";
            table += "</th>";
            
            table += "<th>";
            table += "PlayerPosition";
            table += "</th>";
            
            table += "<th>";
            table += "PlayerAge";
            table += "</th>";
            
            table += "<th>";
            table += "PlayerTeam";
            table += "</th>";
            
            table += "<th>";
            table += "PlayerDraftYear";
            table += "</th>";
            
            table += "<th>";
            table += "PlayerDraftRank";
            table += "</th>";
           
            table += "</tr>";
            while (this.results.next()){
                
                Players players = new Players();
                players.setPlayerID(this.results.getInt("PlayerID"));
                players.setPlayerName(this.results.getString("PlayerName"));
                players.setPlayerPosition(this.results.getString("PlayerPosition"));
                players.setPlayerAge(this.results.getInt("PlayerAge"));
                players.setPlayerTeam(this.results.getString("PlayerTeam"));
                players.setPlayerDraftYear(this.results.getInt("PlayerDraftYear"));
                players.setPlayerDraftRank(this.results.getString("PlayerDraftRank"));
                
              table +="<tr>";
                 table +="<td>";
                    table += players.getPlayerID();
                 table +="</td>";
                
                 table +="<td>";
                    table += players.getPlayerName();
                 table +="</td>";
                
                 table +="<td>";
                    table += players.getPlayerPosition();
                 table +="</td>";
                
                 table +="<td>";
                    table += players.getPlayerAge();
                 table +="</td>";
                
                 table +="<td>";
                    table += players.getPlayerTeam();
                 table +="</td>";
                
                 table +="<td>";
                    table += players.getPlayerDraftYear();
                 table +="</td>";
                 
                 table +="<td>";
                    table += players.getPlayerDraftRank();
                 table +="</td>";
                 
                 table += "<td>";
                    table +=  "<a href=update?PlayerID=" + players.getPlayerID() + "> Update </a>"+"<a href=delete?PlayerID=" + players.getPlayerID() + "> Delete </a>";
                 table += "</td>";
            
               table +="</tr>";
                
            }   } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        table +="</table>";
        
                return table;
     
        
        
    }
    
}
