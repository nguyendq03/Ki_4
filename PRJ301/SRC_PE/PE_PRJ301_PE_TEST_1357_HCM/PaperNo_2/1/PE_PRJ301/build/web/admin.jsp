<%-- 
    Document   : admin
    Created on : Mar 1, 2022, 8:29:12 PM
    Author     : hd
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin Page</title>
</head>
<body>
    <center>
        <h1>Welcome, <%= session.getAttribute("fullName") %></h1>
        <a href="LogoutServlet">Log Out</a>
    </center>
</body>
</html>

