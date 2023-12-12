<%-- 
    Document   : insertCustomer
    Created on : Oct 14, 2023, 3:18:16 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Customer</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    </head>
    <body>
        <%
            String notification = (String)request.getAttribute("notification");
        %>
        <div>
            <a href="CustomerURL">Back to CustomerList</a>
        </div>
        <h3 style="color: red"><%=notification%></h3>
        <form action="CustomerURL" method="post">
            <input type="hidden" name="service" value="insertCustomer"/><br/>
            Enter CustomerID <input type="text" name="CustomerID" /><br/>
            Enter CompanyName <input type="text" name="CompanyName" /><br/>
            Enter ContactName <input type="text" name="ContactName" /><br/>
            Enter ContactTitle <input type="text" name="ContactTitle" /><br/>
            Enter Address <input type="text" name="Address" /><br/>
            Enter City <input type="text" name="City" /><br/>
            Enter Region <input type="text" name="Region" /><br/>
            Enter PostalCode <input type="text" name="PostalCode" /><br/>
            Enter Country <input type="text" name="Country" /><br/>
            Enter Phone <input type="text" name="Phone" /><br/>
            Enter Fax <input type="text" name="Fax" /><br/>
            <input type="submit" name="submit" value="add Customer"/>
            <input type="reset" value="Clear">
        </form>
    </body>
</html>
