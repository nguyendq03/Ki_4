<%-- 
    Document   : search
    Created on : Mar 18, 2023, 10:02:28 PM
    Author     : LENOVO
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
        <form action="search" method="post">
            Group:
            <select name="gid">
                <option value="-1">ALL</option>
                <c:forEach items="${requestScope.listG}" var="g">
                    <option value="${g.gid}">
                        ${g.gname}
                    </option>
                </c:forEach>
            </select>
            <input type="submit" value="Search"/>
        </form>
        
    </body>
</html>
