<%-- 
    Document   : DisplayProduct
    Created on : Oct 2, 2023, 11:18:29 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector" %>
<%@page import="entity.Product" %>
<!DOCTYPE html>
<html>
    <head>
        <%
            String pageTitle=(String)request.getAttribute("pageTitle");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=pageTitle%></title>
    </head>
    <body>
        <%
           //  DAOProduct dao = new DAOProduct();
            Vector<Product> vector=(Vector<Product>)request.getAttribute("data");
            String tableTitle=(String)request.getAttribute("tableTitle");  
            String message=(String)request.getAttribute("message"); 
        %>
        <p style="color:red"><%=message%></p>
        <p><a href="ProductURL?service=insertProduct">Insert Products</p>
        <Table>
            <caption><%=tableTitle%></caption>
            <tr>
                <th>ProductID</th>
                <th>ProductName</th>
                <th>SupplierID</th>
                <th>CategoryID</th>
                <th>QuantityPerUnit</th>
                <th>UnitPrice</th>
                <th>UnitsInStock</th>
                <th>UnitsOnOrder</th>
                <th>ReorderLevel</th>
                <th>Discontinued</th>
                <th>update</th>
                <th>delete</th>
            </tr>
            <% for (Product product : vector) {%>
            <tr>
                <td><%=product.getProductID()%></td>
                <td><%=product.getProductName()%></td>
                <td><%=product.getSupplierID()%></td>
                <td><%=product.getCategoryID()%></td>
                <td><%=product.getQuantityPerUnit()%></td>
                <td><%=product.getUnitPrice()%></td>
                <td><%=product.getUnitsInStock()%></td>
                <td><%=product.getUnitsOnOrder()%></td>
                <td><%=product.getReorderLevel()%></td>
                <td><%=(product.getDiscontinued() == 1 
                        ? "Continued" : "Discontinued")%></td>
                <td><a href="ProductURL?service=updateProduct&pid=<%=product.getProductID()%>">update</a></td>
                <td><a href="ProductURL?service=deleteProduct&pid=<%=product.getProductID()%>">delete</a></td>
            </tr>
            <%}%>

        </table>
    </body>
</html>
