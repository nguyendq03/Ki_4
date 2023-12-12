<%-- 
    Document   : list
    Created on : Mar 14, 2023, 9:56:00 PM
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
        <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Title</th>
                    <th>Published Date</th>
                    <th>is Open Access</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="article" items="${list}">
                    <tr>
                        <td>${article.aid}</td>
                        <td>${article.title}</td>
                        <td>${article.publishedDate}</td>
                        <td>
                            <c:if test="${article.openAccess}">
                                <img src="img/open.png"/>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
