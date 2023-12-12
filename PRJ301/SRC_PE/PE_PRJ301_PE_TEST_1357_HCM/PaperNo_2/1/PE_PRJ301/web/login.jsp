<%-- 
    Document   : login
    Created on : Mar 11, 2022, 9:02:11 PM
    Author     : hd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <center>
    <h1>Login Page</h1>
    
    <form action="LoginServlet" method="POST">
        Username <input type="text" name="txtUsername" /><br/>
        Password <input type="password" name="txtPassword" /><br/>
        <input type="submit" value="Login" name="btAction" />
        <input type="reset" value="Reset" />
    </form>

    <p><%= request.getAttribute("error") %></p>
        </center>
</body>
    
</html>

