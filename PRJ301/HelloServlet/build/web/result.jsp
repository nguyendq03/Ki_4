<%-- 
    Document   : result
    Created on : Sep 26, 2023, 4:30:25 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
    </head>
    <body>
        <h1>Your age:<%=(String) session.getAttribute("age:") %></h1>
    </body>
</html>
