<%-- 
    Document   : insertSupplier
    Created on : Oct 14, 2023, 9:25:48 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Supplier</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    </head>
    <body>
        <%
            String notification=(String)request.getAttribute("notification"); 
        %>
        <div>
            <a href="SupplierURL">Back to SupplierList</a>
        </div>
        <p style="color:red"><%=notification%></p>
        <form action="SupplierURL" method="post">
            <input type="hidden" name="service" value="insertSupplier"><br>
            Enter Company Name: <input type="text" name="companyName" required><br>
            Enter Contact Name: <input type="text" name="contactName" required><br>
            Enter Contact Title: <input type="text" name="contactTitle" required><br>
            Enter Address: <input type="text" name="address" required><br>
            Enter City: <input type="text" name="city" required><br>
            Enter Region: <input type="text" name="region"><br>
            Enter Postal Code: <input type="text" name="postalCode" required><br>
            Enter Country: <input type="text" name="country" required><br>
            Enter Phone: <input type="text" name="phone" required><br>
            Enter Fax: <input type="text" name="fax"><br>
            Enter Homepage: <input type="text" name="homePage"><br>
            <input type="submit" name="submit" value="Add Supplier">
            <input type="reset" value="Clear">
        </form>
    </body>
</html>
