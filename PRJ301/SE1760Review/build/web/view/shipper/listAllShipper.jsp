<%-- 
    Document   : listAllShipper
    Created on : Oct 14, 2023, 9:50:51 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shipper</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    </head>
    <body>
        <%
            ResultSet rs = (ResultSet)request.getAttribute("data");
            String message=(String)request.getAttribute("message"); 
        %>
        <div style="text-align: right">
            <a href="/SE1760Review">Home</a>
        </div>
        <p style="color:red"><%=message%></p>
        <p><a href="ShipperURL?service=insertShipper">Insert Shipper</a></p>
        <table>
            <caption>Shipper List</caption>
            <tr>
                <th>ShipperID</th>
                <th>CompanyName</th>
                <th>Phone</th>
                <th colspan="2">Action</th>
            </tr>
            <%while(rs.next()) { %>
            <tr>
                <td><%=rs.getInt(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getString(3)%></td>
                <td><a href="ShipperURL?service=updateShipper&sid=<%=rs.getInt(1)%>">update</a></td>
                <td><a href="ShipperURL?service=deleteShipper&sid=<%=rs.getInt(1)%>">delete</a></td>
            </tr>
            <% } %>
        </table>
    </body>
</html>
