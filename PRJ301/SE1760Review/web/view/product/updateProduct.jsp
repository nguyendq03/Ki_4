<%-- 
    Document   : updateProduct
    Created on : Oct 13, 2023, 10:26:43 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.sql.ResultSet" %>
<%@page import="java.util.Vector" %>
<%@page import="entity.Product" %>
<%@page import="java.lang.Exception" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Prouct</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    </head>
    <body>
        <%
            Vector<Product> vector=(Vector<Product>)request.getAttribute("data");
            Product product = vector.get(0);
            ResultSet rsCate=(ResultSet)request.getAttribute("rsCate");
            ResultSet rsSup=(ResultSet)request.getAttribute("rsSup");
            String notification = (String)request.getAttribute("notification");
        %>
        <div>
            <a href="ProductURL">Back to ProductList</a>
        </div>
        <h3 style="color: red"><%=notification%></h3>
        <form action="ProductURL" method="post">
            <input type="hidden" name="service" value="updateProduct">
            ProductID:<input type="text" name="pid" value="<%=product.getProductID()%>" readonly/></br>
            Enter ProductName:<input type="text" name="name" value="<%=product.getProductName()%>"/></br>
            Enter Supplier:
            <select name="supID" accesskey="">
                <%while(rsSup.next()){%>
                <option value="<%=rsSup.getInt(1)%>"><%=rsSup.getString(2)%></option>
                <%}%>
            </select></br>
            Enter Category: <select name="cateID" accesskey="">
                <%while(rsCate.next()){%>
                <option value="<%=rsCate.getInt(1)%>"><%=rsCate.getString(2)%></option>
                <%}%>
            </select></br>
            Enter QuantityPerUnit:<input type="text" name="QuantityPerUnit" value="<%=product.getQuantityPerUnit()%>"/></br>
            Enter UnitePrice:<input type="number" name="UnitePrice" value="<%=product.getUnitPrice()%>"/></br>
            Enter UnitsInStock:<input type="number" name="UnitsInStock" value="<%=product.getUnitsInStock()%>"/></br>
            Enter UnitsOnOrder:<input type="number" name="UnitsOnOrder" value="<%=product.getUnitsOnOrder()%>"/></br>
            Enter ReorderLevel:<input type="number" name="ReorderLevel" value="<%=product.getReorderLevel()%>"/></br>
            Enter Discontinued:
            <input type="radio" name="Discontinued" value="1" <%=(product.getDiscontinued() == 1 
                        ? "checked" : "")%>/> continued
            <input type="radio" name="Discontinued" value="0" <%=(product.getDiscontinued() == 0
                        ? "checked" : "")%>/> discontinued
            </br>
            <input type="submit" name="submit" value="update Product"/>
            <input type="reset" value="Clear">
        </form>
    </body>
</html>
