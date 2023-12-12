<%-- 
    Document   : Search
    Created on : Jul 14, 2023, 10:14:56 PM
    Author     : ASUS PC
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="search" method="POST">
            Group<select name="group">
                <option value="-1" >ALL</option>
                <c:forEach var="item" items="${listgroup}">
                    <option value="${item.gid}" >${item.gname}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Search" />
        </form>

    </body>
</html>
