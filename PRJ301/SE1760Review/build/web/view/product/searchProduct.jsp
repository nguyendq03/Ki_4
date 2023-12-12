<%-- 
    Document   : searchProduct
    Created on : Oct 22, 2023, 11:35:24 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ProductURL" method="POST">
    <input type="text" name="searchKeyword" placeholder="Nhập từ khóa tìm kiếm">
    <input type="hidden" name="service" value="searchProduct">
    <input type="submit" value="Search">
</form>

    </body>
</html>
