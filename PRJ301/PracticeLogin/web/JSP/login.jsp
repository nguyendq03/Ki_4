<%-- 
    Document   : login
    Created on : Oct 17, 2023, 11:13:34 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
    </head>
    <body>
        <form action="login" method="POST">
            <label> UserName: </label>
            <input type="text" name="username"><br>
            <label> Password: </label>
            <input type="password" name="password"><br>
            <input type="submit" title="Login"/>
        </form>
    </body>
</html>
