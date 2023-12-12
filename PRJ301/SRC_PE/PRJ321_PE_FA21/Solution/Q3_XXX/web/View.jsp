<%-- 
    Document   : View
    Created on : Oct 29, 2021, 8:13:32 AM
    Author     : area1
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="insert" method="POST">
            ID <input type="text" name="id"/><br/>
            Name <input type="text" name="name"/><br/>
            Gender <input type="radio" name="gender" value="male">Male
            <input type="radio" name="gender" value="female">Female
            <br> Dob <input type="text" name="dob"/><br/>
            Skills:<br>
            <c:forEach items="${requestScope.skills}" var="skill">
                <input type="checkbox" name="skill" value="${skill.id}">${skill.name}<br>
            </c:forEach>
            <input type="submit" value="Insert">
        </form>
    </body>
</html>
