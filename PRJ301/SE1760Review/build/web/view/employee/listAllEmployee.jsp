<%-- 
    Document   : listAllEmployee
    Created on : Oct 14, 2023, 9:36:44 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    </head>
    <body>
        <%
            ResultSet employeeList = (ResultSet)request.getAttribute("data");
            String message = (String)request.getAttribute("message");
        %>
        <div style="text-align: right">
            <a href="/SE1760Review">Home</a>
        </div>
        <p><a href="EmployeeURL?service=insertEmployee">Insert Employee</a></p>
        <h3 style="color: red"><%=message%></h3>
        <table>
            <caption>Employee List</caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Title</th>
                <th>BirthDate</th>
                <th>HireDate</th>
                <th>Address</th>
                <th>City</th>
                <th>Region</th>
                <th>PostalCode</th>
                <th>Country</th>
                <th>HomePhone</th>
                <th>Extension</th>
                <th>Photo</th>
                <!--<th>Notes</th>-->
                <th>ReportsTo</th>
                <th colspan="2">Action</th>
            </tr>
            <%while(employeeList.next()){%>
            <tr>
                <td><%=employeeList.getInt(1)%></td>
                <td><%=employeeList.getString(5) + employeeList.getString(3)+" "+employeeList.getString(2)%></td>
                <td><%=employeeList.getString(4)%></td>
                <td><%=employeeList.getString(6)%></td>
                <td><%=employeeList.getString(7)%></td>
                <td><%=employeeList.getString(8)%></td>
                <td><%=employeeList.getString(9)%></td>
                <td><%=employeeList.getString(10)%></td>
                <td><%=employeeList.getString(11)%></td>
                <td><%=employeeList.getString(12)%></td>
                <td><%=employeeList.getString(13)%></td>
                <td><%=employeeList.getString(14)%></td>
                <td><img src="../" alt="<%=employeeList.getString(3) + " " + employeeList.getString(2)%>"/></td>
                <!--<td><%=employeeList.getString(16)%></td>-->
                <td><%=employeeList.getString(17)%></td>
                <!--<td><%=employeeList.getString(18)%></td>-->
                <td><a href="EmployeeURL?service=updateEmployee&eid=<%=employeeList.getInt("EmployeeID")%>">update</a></td>
                <td><a href="EmployeeURL?service=deleteEmployee&eid=<%=employeeList.getInt("EmployeeID")%>">delete</a></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
