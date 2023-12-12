<%-- 
    Document   : login
    Created on : Mar 18, 2023, 10:40:52 PM
    Author     : LENOVO
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
            Username:<input type="text" name="username"/><br/>
            Password:<input type="text" name="password"/><br/>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
