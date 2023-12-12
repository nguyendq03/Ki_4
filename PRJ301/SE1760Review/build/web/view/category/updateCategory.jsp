<%-- 
    Document   : updateCategory
    Created on : Oct 14, 2023, 12:28:55 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Category</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    </head>
    <body>
        <%
            ResultSet rs = (ResultSet)request.getAttribute("data");
        %>
        <div>
            <a href="CategoryURL">Back to CategoryList</a>
        </div>
        <form action="CategoryURL" method="post">
            <input type="hidden" name="service" value="updateCategory">
            <%while(rs.next()){%>
            CategoryID <input type="text" name="CategoryID" value="<%=rs.getInt("CategoryID")%>" readonly><br>
            Enter CategoryName <input type="text" name="CategoryName" value="<%=rs.getString("CategoryName")%>"><br>
            Enter description <input type="text" name="Description" value="<%=rs.getString("Description")%>"><br>
            Enter picture <input type="text" name="Picture" value="<%=rs.getString("Picture")%>"><br>
            <%}%>
            <input type="submit" name="submit" value="update Category">
            <input type="reset" value="Clear">
        </form>
    </body>
</html>
