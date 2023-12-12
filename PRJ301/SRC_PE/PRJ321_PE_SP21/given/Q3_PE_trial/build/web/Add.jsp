<%-- 
    Document   : Add
    Created on : Oct 28, 2021, 4:33:47 PM
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
        <form action="add" method="POST">
            <table>
                <tr>
                    <td>Paper ID:</td>
                    <td><input type="text" name="paperId"/></td>
                </tr>
                <tr>
                    <td>Title:</td>
                    <td><input type="text" name="title"/></td>
                </tr>
                <tr>
                    <td>Date:</td>
                    <td><input type="text" name="date"/>(yyyy-MM-dd)</td>
                </tr>
                <c:forEach items="${requestScope.authors}" var="a">
                <tr>
                    <td></td>
                    <td><input type="checkbox" name="authorId" value="${a.id}" />${a.name}</td>
                </tr>
                </c:forEach>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Save"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
