<%-- 
    Document   : listAllTerritory
    Created on : Oct 14, 2023, 11:51:36 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
        <title>Territory</title>
    </head>
    <body>
        <%
            ResultSet rs = (ResultSet)request.getAttribute("data");
        %>
        <div style="text-align: right">
            <a href="/SE1760Review">Home</a>
        </div>
        <table>
            <caption>Territory List</caption>
            <tr>
                <th>Employee</th>
                <th>TerritoryID</th>
                <th>TerritoryDescription</th>
                <th>RegionID</th>
                <th>RegionDescription</th>
            </tr>
            <%while(rs.next()) { %>
            <tr>
                <td><%=rs.getString(1)%></td>
                <td><%=rs.getInt(2)%></td>
                <td><%=rs.getString(3)%></td>
                <td><%=rs.getInt(4)%></td>
                <td><%=rs.getString(5)%></td>
            </tr>
            <% } %>
        </table>
    </body>
</html>
