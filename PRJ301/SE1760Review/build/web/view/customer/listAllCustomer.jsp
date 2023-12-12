<%-- 
    Document   : listAllCustomer
    Created on : Oct 14, 2023, 2:58:56 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer</title>
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
        <p><a href="CustomerURL?service=insertCustomer">Insert Customer</a></p>
        <h3 style="color: red"><%=message%></h3>
        <h2>Select a customer to show bill</h2>
        <table>
            <caption>Customer list</caption>
            <tr>
                <th>CustomerID</th>
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
                <th colspan="2">Action</th>
            </tr>
            <%while(rs.next()){%>
            <tr>
                <td><a href=OrderURL?service=viewOrder&customerID=<%=rs.getString(1)%>><%=rs.getString(1)%></a></td>
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
                <td><a href="CustomerURL?service=updateCustomer&customerID=<%=rs.getString(1)%>">update</a></td>
                <td><a href="CustomerURL?service=deleteCustomer&customerID=<%=rs.getString(1)%>">delete</a></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
