<%-- 
    Document   : insertCategory
    Created on : Oct 14, 2023, 12:02:41 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Category</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    </head>
    <body>
        <%
            String notification=(String)request.getAttribute("notification"); 
        %>
        <div>
            <a href="CategoryURL">Back to CategoryList</a>
        </div>
        <p style="color:red"><%=notification%></p>
        <form action="CategoryURL" method="post">
            <input type="hidden" name="service" value="insertCategory"><br>
            Enter CategoryName <input type="text" name="CategoryName"><br>
            Enter description <input type="text" name="Description"><br>
            Enter picture <input type="text" name="Picture"><br>
            <input type="submit" name="submit" value="submit">
            <input type="reset" value="Clear">
        </form>
    </body>
</html>
