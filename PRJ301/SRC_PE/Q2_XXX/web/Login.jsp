<%-- 
    Document   : Login
    Created on : Jul 13, 2023, 9:48:46 PM
    Author     : ASUS PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="POST">
            Username: <input type="text" name="username" value="" /> <br>
            Password: <input type="password" name="password" value="" /><br>
            <input type="submit" value="Login" />
        </form>
    </body>
</html>
