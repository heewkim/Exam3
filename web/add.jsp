
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADD A NEW RESTAURANT</title>
         <link rel="stylesheet" type="text/css" href="./style.css" />
    </head>
    <body>
         <div class="wrap">
         <%@ include file="includes/header.jsp" %>
         <%@ include file="includes/menu.jsp" %>
       
        <h1>ADD A NEW PLAYER</h1>
        <form name="Addform" action="addPlayer" method="get">
  
     <table>
         <tbody>
             <tr>
                 <td> <label>Name:</label> </td>
           <td>  <input type="text" name="PlayerName" value="" /></td>
            <br>
         </tr>
          <tr>
           <td>  <label>Position:</label></td>
            <td> <input type="text" name="PlayerPosition" value="" /></td>
            <br>
         </tr>
          <tr>
           <td>  <label>Age:</label></td>
            <td> <input type="text" name="PlayerAge" value="" /></td>
            <br>
        </tr>
         <tr>
           <td>  <label>NFL Team:</label></td>
           <td> <input type="text" name="PlayerTeam" value="" /></td>
            <br>
        </tr>
         <tr>
                 <td> <label>Drafted Year:</label> </td>
           <td>  <input type="text" name="PlayerDraftYear" value="" /></td>
            <br>
         </tr>
          <tr>
                 <td> <label>Draft Rank:</label> </td>
           <td>  <input type="text" name="PlayerDraftRank" value="" /></td>
            <br>
         </tr>
          <tr>
           <td>  <input type="submit" name="submit" value="Submit" /></td>
           </tr>
     </tbody>
     </table>      

        </form>
         <%@ include file="includes/footer.jsp" %>
        </div>
    </body>
</html>
