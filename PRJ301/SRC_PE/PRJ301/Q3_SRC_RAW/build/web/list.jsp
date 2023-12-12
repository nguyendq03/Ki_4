<%-- 
    Document   : list
    Created on : Mar 18, 2023, 10:11:18 PM
    Author     : LENOVO
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
        <table border="1">
            <tr>
                <th>mid</th>
                <th>mname</th>
                <th>gender</th>
                <th>dob</th>
                <th>gid</th>
                <th>created_by</th>
            </tr>
            <c:forEach items="${requestScope.listM}" var="m">
                <tr>
                    <td>${m.mid}</td>
                    <td>${m.mname}</td>
                    <td>${m.gender?'1':'0'}</td>
                    <td>${m.dob}</td>
                    <c:forEach var="g" items="${requestScope.listG}">
                        <c:if test="${m.gid==g.gid}">
                            <td>${g.gname}</td>
                        </c:if>    
                    </c:forEach>        
                    <td>${m.created_by}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
