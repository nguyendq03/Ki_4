<%-- 
    Document   : login
    Created on : Mar 14, 2023, 10:15:47 PM
    Author     : Hoang Hiep
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
            Username: <input type="text" name="username" value="" />
            password: <input type="password" name="password" value="" />
            <input type="submit" value="Login" />
        </form>
    </body>
</html>
