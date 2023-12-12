<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : View
    Created on : Oct 28, 2021, 3:58:01 PM
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
            Authors:
            <select name="authorId">
                <c:forEach var="a" items="${requestScope.authors}">
                    <option ${requestScope.authorId == a.id? "selected" : ""} value="${a.id}">${a.name}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Search"/> 
        </form>
        <c:if test="${!empty requestScope.papers}">
        <table border="1">
            <thead>
                <tr>
                    <th>Paper ID</th>
                    <th>Title</th>
                    <th>Published Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="p" items="${requestScope.papers}">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.title}</td>
                    <td>${p.published}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    </body>
</html>
