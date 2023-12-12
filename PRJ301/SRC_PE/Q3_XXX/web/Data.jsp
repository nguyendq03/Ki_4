<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : Data
    Created on : Jul 14, 2023, 10:29:31 PM
    Author     : ASUS PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <th>mid</th>
                    <th>mname</th>
                    <th>gender</th>
                    <th>dob</th>
                    <th>gid</th>
                    <th>created_by</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${data}">
                    <tr>
                        <td>${item.mid}</td>
                        <td>${item.mname}</td>
                        <th>${item.gender}</th>
                        <th>${item.dob}</th>
                        <th>${item.gid}</th>
                        <th>${item.created_by}</th>
                    </tr>
                </c:forEach>

            </tbody>
        </table>

    </body>
</html>
