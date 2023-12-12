<%-- 
    Document   : updateShipper
    Created on : Oct 14, 2023, 10:10:33 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Shipper</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    </head>
    <body>
        <%
            ResultSet rs = (ResultSet)request.getAttribute("data");
        %>
        <div>
            <a href="ShipperURL">Back to ShipperList</a>
        </div>
        <form action="ShipperURL" method="post">
            <input type="hidden" name="service" value="updateShipper">
            <%while(rs.next()){%>
            ShipperID <input type="text" name="ShipperID" value="<%=rs.getInt(1)%>" readonly><br>
            Enter ShipperName <input type="text" name="companyName" value="<%=rs.getString(2)%>"><br>
            Enter description <input type="text" name="phone" value="<%=rs.getString(3)%>"><br>
            <%}%>
            <input type="submit" name="submit" value="update Shipper">
            <input type="reset" value="Clear">
        </form>
    </body>
</html>
