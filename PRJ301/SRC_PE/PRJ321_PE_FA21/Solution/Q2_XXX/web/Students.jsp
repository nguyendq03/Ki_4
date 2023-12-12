<%-- 
    Document   : Students
    Created on : Oct 29, 2021, 8:46:06 AM
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
    <c:if test="${!empty students}">
        <table border="1" >
            <thead>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>dob</th>
                    <th>gender</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="s" items="${requestScope.students}">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.name}</td>
                    <td>${s.dob}</td>
                    <td>${s.gender}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
        
</body>
</html>
