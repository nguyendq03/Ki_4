<%-- 
    Document   : insertOrder
    Created on : Oct 14, 2023, 4:38:25 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Order</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    </head>
    <body>
        <%
            String notification=(String)request.getAttribute("notification"); 
            ResultSet rs = (ResultSet)request.getAttribute("data");
        %>
        <div>
            <a href="OrderURL">Back to OrderList</a>
        </div>
        <th>ID</th>
                <th>Customer</th>
                <th>Employee</th>
                <th>OrderDate</th>
                <th>RequiredDate</th>
                <th>ShippedDate</th>
                <th>ShipVia</th>
                <th>Freight</th>
                <th>ShipName</th>
                <th>ShipAddress</th>
                <th>ShipCity</th>
                <th>ShipRegion</th>
                <th>ShipPostalCode</th>
                <th>Ship<br/>Country</th>
        <h3 style="color: red"><%=notification%></h3>
        <form action="OrderURL" method="post">
            <input type="hidden" name="service" value="updateOrder"/></br>
            <input type="text" name="CustomerID"/>
        </form>
    </body>
</html>
