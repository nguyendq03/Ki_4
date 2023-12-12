<%-- 
    Document   : login
    Created on : Oct 30, 2023, 11:23:30 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <form action="login" method="post">
            UserName <input name="user"/><br />
            Password <input name="pass"/><br />
            <input type="submit" value="login"/>
        </form>
        
        ${sessionScope.noti}
    </body>
</html>
