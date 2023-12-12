<%-- 
    Document   : listAllProduct
    Created on : Oct 13, 2023, 7:53:41 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product</title>
        <%
            ResultSet productList = (ResultSet)request.getAttribute("data");
            String message = (String)request.getAttribute("message");
        %>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    </head>
    <body>
        <div style="text-align: right">
            <a href="/SE1760Review">Home</a>
        </div>
        <p><a href="ProductURL?service=insertProduct">Insert Products</a></p>
        <h3 style="color: red"><%=message%></h3>
        <table>
            <caption>Product List</caption>
            <tr> 
                <th>ProductID</th>
                <th>ProductName</th>
                <th>CompanyName</th>
                <th>CategoryName</th>
                <th>QuantityPerUnit</th>
                <th>UnitPrice</th>
                <th>UnitsInStock</th>
                <th>UnitsOnOrder</th>
                <th>ReorderLevel</th>
                <th>Discontinued</th>
                <th colspan="2">Action</th>
            </tr>
            <%while(productList.next()){%>
                <tr>
                    <td><%=productList.getInt("ProductID")%></td>
                    <td><%=productList.getString("ProductName")%></td>
                    <td><%=productList.getString("CompanyName")%></td>
                    <td><%=productList.getString("CategoryName")%></td>
                    <td><%=productList.getString("QuantityPerUnit")%></td>
                    <td><%=productList.getDouble("UnitPrice")%></td>
                    <td><%=productList.getInt("UnitsInStock")%></td>
                    <td><%=productList.getInt("UnitsOnOrder")%></td>
                    <td><%=productList.getInt("ReorderLevel")%></td>
                    <td><%=(productList.getInt("Discontinued") == 1 ? "Continued" : "Discontinued")%></td>
                    <td><a href="ProductURL?service=updateProduct&pid=<%=productList.getInt("ProductID")%>">update</a></td>
                    <td><a href="ProductURL?service=deleteProduct&pid=<%=productList.getInt("ProductID")%>">delete</a></td>
                </tr>
            <%}%>
        </table>
    </body>
</html>
