<%-- 
    Document   : listAllSupplier
    Created on : Oct 14, 2023, 9:14:24 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Supplier</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    </head>
    <body>
        <%
            ResultSet rs = (ResultSet)request.getAttribute("data");
            String message = (String)request.getAttribute("message");
        %>
        <div style="text-align: right">
            <a href="/SE1760Review">Home</a>
        </div>
        <p style="color:red"><%=message%></p>
        <p><a href="SupplierURL?service=insertSupplier">Insert Supplier</a></p>
        <table>
            <caption>Supplier List</caption>
            <tr>
                <th>SupplierID</th>
                <th>CompanyName</th>
                <th>ContactName</th>
                <th>ContactTitle</th>
                <th>Address</th>
                <th>City</th>
                <th>Region</th>
                <th>PostalCode</th>
                <th>Country</th>
                <th>Phone</th>
                <th>Fax</th>
                <th>HomePage</th>
                <th colspan="2">Action</th>
            </tr>
            <%while(rs.next()) { %>
            <tr>
                <td><%=rs.getInt(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getString(3)%></td>
                <td><%=rs.getString(4)%></td>
                <td><%=rs.getString(5)%></td>
                <td><%=rs.getString(6)%></td>
                <td><%=rs.getString(7)%></td>
                <td><%=rs.getString(8)%></td>
                <td><%=rs.getString(9)%></td>
                <td><%=rs.getString(10)%></td>
                <td><%=rs.getString(11)%></td>
                <td><%=rs.getString(12)%></td>
                <td><a href="SupplierURL?service=updateSupplier&sid=<%=rs.getInt(1)%>">update</a></td>
                <td><a href="SupplierURL?service=deleteSupplier&sid=<%=rs.getInt(1)%>">delete</a></td>
            </tr>
            <% } %>
        </table>
    </body>
</html>
