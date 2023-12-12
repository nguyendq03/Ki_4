<%-- 
    Document   : viewSearchOrder
    Created on : Oct 14, 2023, 5:31:00 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.lang.Exception" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Searched Order</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    </head>
    <body>
        <%
            ResultSet rs = (ResultSet)request.getAttribute("data");
            int size = 0;
        %>
        <a href="OrderURL">Back To OrderList</a>
        <table>
            <tr>
                <th>ID</th>
                <th>Customer</th>
                <th>Employee</th>
                <th>Order<br/>Date</th>
                <th>Required<br/>Date</th>
                <th>Shipped<br/>Date</th>
                <th>Ship<br/>Via</th>
                <th>Freight</th>
                <th>Ship<br/>Name</th>
                <th>Ship<br/>Address</th>
                <th>Ship<br/>City</th>
                <th>Ship<br/>Region</th>
                <th>ShipPostal<br/>Code</th>
                <th>Ship<br/>Country</th>
            </tr>
            <%try{
                while(rs.next()){ size++;%>
            <tr>
                <td><%=rs.getInt(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getString(3)%></td>
                <td><%=rs.getString(4)%></td>
                <td><%=rs.getString(5)%></td>
                <td><%=rs.getString(6)%></td>
                <td><%=rs.getInt(7)%></td>
                <td><%=rs.getString(8)%></td>
                <td><%=rs.getString(9)%></td>
                <td><%=rs.getString(10)%></td>
                <td><%=rs.getString(11)%></td>
                <td><%=rs.getString(12)%></td>
                <td><%=rs.getString(13)%></td>
                <td><%=rs.getString(14)%></td>
            </tr>
            <%}
            }catch(Exception e){}
            %>
            <caption><%=size%> result(s)</caption>
        </table>
    </body>
</html>
