
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hawkeye Footboll</title>
         <link rel="stylesheet" type="text/css" href="./style.css" />
    </head>
     <% String table = (String) request.getAttribute("table"); %>
    <body>
        <div class="wrap">
      <%@ include file="includes/header.jsp" %>
      <%@ include file="includes/menu.jsp" %>
        <h1>Hawkeye Footboll Players who went to NFL league</h1>
        <%= table %>
        
        <%@ include file="includes/footer.jsp" %>
      </div>
        
    </body>
</html>
