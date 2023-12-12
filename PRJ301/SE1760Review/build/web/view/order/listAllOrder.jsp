<%-- 
    Document   : listAllOrder
    Created on : Oct 14, 2023, 4:01:48 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order</title>
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
        <!--<p><a href="OrderURL?service=insertOrder">Insert Order</a></p>-->
        <form action="OrderURL" method="post" style="border: 1px solid #ddd; width: 60%">
            <input type="hidden" name="service" value="searchOrder"/></br>
            <p style="text-align: center"><b>Search Order</b></p>
            <hr/>
<!--            OrderID<input type="number" name="OrderID"/>
            Customer<input type="text" name="Customer"/>
            Employee<input type="text" name="Employee"/>
            <br/></br>-->
            OrderDateFrom<input type="date" name="OrderFrom"/>
            OrderDateTo<input type="date" name="OrderTo"/>
            <br/></br>
<!--            RequiredDateFrom<input type="date" name="RequiredFrom"/>
            RequiredDateTo<input type="date" name="RequiredTo"/>
            <br/></br>-->
<!--            ShippedDateFrom<input type="date" name="ShippedFrom"/>
            ShippedDateTo<input type="date" name="ShippedTo"/>
            <br/></br>
            ShipVia<input type="text" name="ShipVia"/>
            Freight<input type="text" name="Freight"/>
            ShipName<input type="text" name="ShipName"/>
            <br/></br>
            ShipAddress<input type="text" name="ShipAddress"/>
            ShipCity<input type="text" name="ShipCity"/>
            ShipRegion<input type="text" name="ShipRegion"/>
            <br/></br>
            ShipPostalCode<input type="text" name="ShipPostalCode"/>
            ShipCountry<input type="text" name="ShipCountry"/>
            <br/></br>-->
            <input type="submit" value="search" name="submit"/>
            <input type="reset" value="clear"/>
        </form>
        <h3 style="color: red"><%=message%></h3>
        <table>
            <caption>Order List</caption>
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
            <%while(rs.next()){%>
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
            <%}%>
        </table>
    </body>
</html>
