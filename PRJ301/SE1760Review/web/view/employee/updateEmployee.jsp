<%-- 
    Document   : updateEmployee
    Created on : Oct 14, 2023, 11:23:23 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Employee</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    </head>
    <body>
        <div>
            <a href="EmployeeURL">Back to EmployeeList</a>
        </div>
        <%
            ResultSet rs = (ResultSet)request.getAttribute("data");
        %>
        <form action="EmployeeURL" method="post">
            <input type="hidden" name="service" value="updateEmployee"/></br>
            <%while(rs.next()){%>
            EmployeeID:<input type="text" name="eid" value="<%=rs.getString(1)%>" readonly/></br>
            Enter LastName<input type="text" name="LastName" value="<%=rs.getString(2)%>"/></br>
            Enter FirstName<input type="text" name="FirstName" value="<%=rs.getString(3)%>"/></br>
            Enter Title<input type="text" name="Title" value="<%=rs.getString(4)%>"/></br>
            Enter TitleOfCourtesy<input type="text" name="TitleOfCourtesy" value="<%=rs.getString(5)%>"/></br>
            Enter Address<input type="text" name="Address" value="<%=rs.getString(8)%>"/></br>
            Enter City<input type="text" name="City" value="<%=rs.getString(9)%>"/></br>
            Enter Region<input type="text" name="Region" value="<%=rs.getString(10)%>"/></br>
            Enter PostalCode<input type="text" name="PostalCode" value="<%=rs.getString(11)%>"/></br>
            Enter Country<input type="text" name="Country" value="<%=rs.getString(12)%>"/></br>
            Enter HomePhone<input type="text" name="HomePhone" value="<%=rs.getString(13)%>"/></br>
            Enter Extension<input type="datetime" name="Extension" value="<%=rs.getString(14)%>"/></br>
            Enter Photo<input type="text" name="Photo" value="<%=rs.getString(15)%>"/></br>
            Enter Notes<input type="text" name="Notes" value="<%=rs.getString(16)%>"/></br>
            Enter ReportsTo<input type="number" name="ReportsTo" value="<%=rs.getInt(17)%>"/></br>
            Enter PhotoPath<input type="text" name="PhotoPath" value="<%=rs.getString(18)%>"/></br>
            <%}%>
            <input type="submit" name="submit" value="update Employee"/>
            <input type="reset" value="clear"/>
        </form>
    </body>
</html>
