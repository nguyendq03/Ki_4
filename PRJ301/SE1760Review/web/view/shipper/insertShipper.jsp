<%-- 
    Document   : insertShipper
    Created on : Oct 14, 2023, 9:59:00 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Shipper</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    </head>
    <body>
        <%
            String notification=(String)request.getAttribute("notification"); 
        %>
        <div>
            <a href="ShipperURL">Back to ShipperList</a>
        </div>
        <p style="color:red"><%=notification%></p>
        <form action="ShipperURL" method="post">
            <input type="hidden" name="service" value="insertShipper">
            Enter Company Name: <input type="text" name="companyName" required><br>
            Enter Phone: <input type="text" name="phone" required><br>
            <input type="submit" name="submit" value="Add Shipper">
            <input type="reset" value="Clear">
        </form>
    </body>
</html>
