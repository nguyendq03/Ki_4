<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : View
    Created on : Oct 29, 2021, 7:51:11 AM
    Author     : area1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="search" method="POST">
            Name <input type="text" name="name" value="${requestScope.name}">
            <input type="submit" value="Search">
        </form>
     
    </body>
</html>
