<%-- 
    Document   : assign
    Created on : Mar 14, 2023, 10:40:12 PM
    Author     : Hoang Hiep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Paper Id: ${paper.pid}<br>
        Title: ${paper.title}<br>
        Published date: ${paper.publishedDate}<br>
        Open access: ${paper.openAccess ? "yes" : "no"}<br>
        <br>
        Author:
        <table border="1">
            <thead>
                <tr>
                    <th>Author ID</th>
                    <th>Author Name</th>
                    <th>Is Corresponding Author</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="author" items="${authors}">
                    <tr>
                        <td>${author.auid}</td>
                        <td>${author.auname}</td>
                        <td>${author.isCorresponding ? "yes" : "no"}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <br>
        <br>
        <c:if test="${paper.openAccess}"> <!-- Bo sung sau video chua de -->
        Assign:
        <table border="1">
            <thead>
                <tr>
                    <th>Author ID</th>
                    <th>Author Name</th>
                    <th colspan="2">Assign</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="author" items="${notAssignAuthors}">
                    <tr>
                        <td>${author.auid}</td>
                        <td>${author.auname}</td>
                        <td>
                            <form action="assign" method="POST">
                                <input type="hidden" name="pid" value="${paper.pid}">
                                <input type="hidden" name="auid" value="${author.auid}">
                                <input type="submit" value="Assign" />
                            </form>
                        </td>
                        <td>
                            <form action="assign" method="POST">
                                <input type="hidden" name="pid" value="${paper.pid}">
                                <input type="hidden" name="auid" value="${author.auid}">
                                <input type="hidden" name="isCorresponding" value="1">
                                <input type="submit" value="Corresponding" />
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        </c:if>
    </body>
</html>
