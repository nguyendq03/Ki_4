<%-- 
    Document   : SearchView
    Created on : Nov 2, 2021, 8:30:19 PM
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
        <form action="search" method="POST">
            Authors: 
            <select name="authorid">
                <c:forEach items="${authors}" var="a">
                    <option ${raw_authorId==a.id? "selected" : ""} value="${a.id}">${a.name}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Search"/>
        </form>

        <c:if test="${!empty papers}">
            <table border="1">
                <thead>
                    <tr>
                        <th>Paper ID</th>
                        <th>Title</th>
                        <th>Published Date</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${papers}" var="p">
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
