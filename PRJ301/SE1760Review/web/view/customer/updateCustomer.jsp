<%-- 
    Document   : updateCustomer
    Created on : Oct 14, 2023, 3:18:24 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Customer</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    </head>
    <body>
        <%
            ResultSet rs=(ResultSet)request.getAttribute("data");
        %>
        <div>
            <a href="CustomerURL">Back to CustomerList</a>
        </div>
        <form action="CustomerURL" method="post">
            <input type="hidden" name="service" value="updateCustomer"/><br/>
            <%while(rs.next()){%>
            Enter CustomerID <input type="text" name="CustomerID" value="<%=rs.getString(1)%>" readonly/><br/>
            Enter CompanyName <input type="text" name="CompanyName" value="<%=rs.getString(2)%>"/><br/>
            Enter ContactName <input type="text" name="ContactName" value="<%=rs.getString(3)%>"/><br/>
            Enter ContactTitle <input type="text" name="ContactTitle" value="<%=rs.getString(4)%>"/><br/>
            Enter Address <input type="text" name="Address" value="<%=rs.getString(5)%>"/><br/>
            Enter City <input type="text" name="City" value="<%=rs.getString(6)%>"/><br/>
            Enter Region <input type="text" name="Region" value="<%=rs.getString(7)%>"/><br/>
            Enter PostalCode <input type="text" name="PostalCode" value="<%=rs.getString(8)%>"/><br/>
            Enter Country <input type="text" name="Country" value="<%=rs.getString(9)%>"/><br/>
            Enter Phone <input type="text" name="Phone" value="<%=rs.getString(10)%>"/><br/>
            Enter Fax <input type="text" name="Fax" value="<%=rs.getString(11)%>"/><br/>
            <%}%>
            <input type="submit" name="submit" value="update Customer"/>
            <input type="reset" value="Clear">
        </form>
    </body>
</html>
