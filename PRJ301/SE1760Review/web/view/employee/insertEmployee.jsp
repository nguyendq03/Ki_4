<%-- 
    Document   : insertEmployee
    Created on : Oct 14, 2023, 10:04:55 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Employee</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    </head>
    <body>
        <%
            String notification=(String)request.getAttribute("notification"); 
        %>
        <div>
            <a href="EmployeeURL">Back to EmployeeList</a>
        </div>
        <h3 style="color: red"><%=notification%></h3>
        <form action="EmployeeURL" method="post">
            <input type="hidden" name="service" value="insertEmployee"/></br>
            Enter LastName<input type="text" name="LastName"/></br>
            Enter FirstName<input type="text" name="FirstName"/></br>
            Enter Title<input type="text" name="Title"/></br>
            Enter TitleOfCourtesy<input type="text" name="TitleOfCourtesy"/></br>
            Enter BirthDate<input type="date" name="BirthDate"/></br>
            Enter HireDate<input type="date" name="HireDate"/></br>
            Enter Address<input type="text" name="Address"/></br>
            Enter City<input type="text" name="City"/></br>
            Enter Region<input type="text" name="Region"/></br>
            Enter PostalCode<input type="text" name="PostalCode"/></br>
            Enter Country<input type="text" name="Country"/></br>
            Enter HomePhone<input type="text" name="HomePhone"/></br>
            Enter Extension<input type="datetime" name="Extension"/></br>
            Enter Photo<input type="text" name="Photo"/></br>
            Enter Notes<input type="text" name="Notes"/></br>
            Enter ReportsTo<input type="number" name="ReportsTo"/></br>
            Enter PhotoPath<input type="text" name="PhotoPath"/></br>
            <input type="submit" name="submit" value="insert Employee"/>
            <input type="reset" value="clear"/>
        </form>
    </body>
</html>
