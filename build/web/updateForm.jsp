
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Players"%>
<% Players players = (Players) request.getAttribute("players"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./style.css" />
        <title>UPDATE A PLAYER</title>
        
    </head>
    <body>
        <div class="wrap">
      <%@ include file="includes/header.jsp" %>
      <%@ include file="includes/menu.jsp" %>
        <h1>UPDATE A RESTAURANT RECORD</h1>
         <form name="updateForm" action="updatePlayer" method="get">
             <table>
         <tbody>
             <tr>
                  <td> <label>ID:</label> </td>
           <td>  <input type="text" name="PlayerID" value="<%= players.getPlayerID() %>"readonly/></td>
            <br>
            </tr>
            <tr>
            <td> <label>Name:</label> </td>
           <td>  <input type="text" name="PlayerName" value="<%= players.getPlayerName() %>"/></td>
            <br>
         </tr>
          <tr>
           <td>  <label>Position:</label></td>
            <td> <input type="text" name="PlayerPosition" value="<%= players.getPlayerPosition() %>" /></td>
            <br>
         </tr>
          <tr>
           <td>  <label>Age:</label></td>
            <td> <input type="text" name="PlayerAge" value="<%= players.getPlayerAge() %>"/></td>
            <br>
        </tr>
         <tr>
           <td>  <label>NFL Team:</label></td>
           <td> <input type="text" name="PlayerTeam" value="<%= players.getPlayerTeam() %>"/></td>
            <br>
        </tr>
        <tr>
           <td>  <label>Drafted Year:</label></td>
           <td> <input type="text" name="PlayerDraftYear" value="<%= players.getPlayerDraftYear() %>"/></td>
            <br>
        </tr>
        <tr>
           <td>  <label>Draft Rank:</label></td>
           <td> <input type="text" name="PlayerDraftRank" value="<%= players.getPlayerDraftRank() %>"/></td>
            <br>
        </tr>
          <tr>
           <td> <input type="reset" name="reset" value="Clear" />
               <input type="submit" name="submit" value="Update" /></td>
           </tr>
     </tbody>
     </table>      

        </form>
      <%@ include file="includes/footer.jsp" %>
      </div>  
    </body>
</html>
