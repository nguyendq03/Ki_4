<%-- 
    Document   : updateSupplier
    Created on : Oct 14, 2023, 9:33:54 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Supplier</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    </head>
    <body>
        <%
            ResultSet rs = (ResultSet)request.getAttribute("data");
        %>
        <div>
            <a href="SupplierURL">Back to SupplierList</a>
        </div>
        <form action="SupplierURL" method="post">
            <input type="hidden" name="service" value="updateSupplier">
            <%while(rs.next()){%>
            SupllierID: <input type="text" name="SupllierID" value="<%=rs.getInt(1)%>" readonly><br>
            Enter Company Name: <input type="text" name="companyName" value="<%=rs.getString(2)%>"><br>
            Enter Contact Name: <input type="text" name="contactName" value="<%=rs.getString(3)%>"><br>
            Enter Contact Title: <input type="text" name="contactTitle" value="<%=rs.getString(4)%>"><br>
            Enter Address: <input type="text" name="address" value="<%=rs.getString(5)%>"><br>
            Enter City: <input type="text" name="city" value="<%=rs.getString(6)%>"><br>
            Enter Region: <input type="text" name="region" value="<%=rs.getString(7)%>"><br>
            Enter Postal Code: <input type="text" name="postalCode" value="<%=rs.getString(8)%>"><br>
            Enter Country: <input type="text" name="country" value="<%=rs.getString(9)%>"><br>
            Enter Phone: <input type="text" name="phone" value="<%=rs.getString(10)%>"><br>
            Enter Fax: <input type="text" name="fax" value="<%=rs.getString(11)%>"><br>
            Enter Homepage: <input type="text" name="homePage" value="<%=rs.getString(12)%>"><br>
            <%}%>
            <input type="submit" name="submit" value="Add Supplier">
            <input type="reset" value="Clear">
        </form>
    </body>
</html>
