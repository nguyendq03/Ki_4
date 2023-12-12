<%-- 
    Document   : addProduct
    Created on : Oct 9, 2023, 10:19:54 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%ResultSet rsCate=(ResultSet)request.getAttribute("rsCate");
        ResultSet rsSup=(ResultSet)request.getAttribute("rsSup");%>
       <form action="ProductURL" method="post">
            <input type="hidden" name="service" value="insertProduct">
            Enter ProductName:<input type="text" name="name"/></br>
            Enter SuppliedID:
            <select name="supID">
                <%while(rsSup.next()){%>
                <option value="<%=rsSup.getInt(1)%>"><%=rsSup.getString(2)%></option>
                <%}%>
            </select></br>
             Enter CategoryID: <select name="cateID">
                <%while(rsCate.next()){%>
                <option value="<%=rsCate.getInt(1)%>"><%=rsCate.getString(2)%></option>
                <%}%>
            </select></br>
            Enter QuantityPerUnit:<input type="text" name="QuantityPerUnit"/></br>
            Enter UnitePrice:<input type="number" name="UnitePrice"/></br>
            Enter UnitsInStock:<input type="number" name="UnitsInStock"/></br>
            Enter UnitsOnOrder:<input type="number" name="UnitsOnOrder"/></br>
            Enter ReorderLevel:<input type="number" name="ReorderLevel"/></br>
            Enter Discontinued:
            <input type="radio" name="Discontinued" value="1"/> continued
            <input type="radio" name="Discontinued" value="0"/> discontinued
            </br>
            <input type="submit" name="submit" value="add Product"/>
            <input type="reset" value="Clear">
        </form>
    </body>
</html>
