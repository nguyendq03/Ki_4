<%-- 
    Document   : home
    Created on : Oct 16, 2023, 11:00:32 PM
    Author     : Do Duc Duong
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
        <h1>Home</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Product Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Supplier Name</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${products}" var="p">
                    <tr>
                        <td>${p.name}</td>
                        <td>${p.description}</td>
                        <td>${p.price}</td>
                        <td>${p.supplierName}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>


    </body>
</html>
