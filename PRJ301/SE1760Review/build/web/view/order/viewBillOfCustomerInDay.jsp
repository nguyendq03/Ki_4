<%-- 
    Document   : viewBillOfCustomerInDay
    Created on : Oct 15, 2023, 12:45:11 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.lang.Exception" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            Vector<ArrayList<String>> vector = (Vector<ArrayList<String>>)request.getAttribute("bill");
            double grandTotal = 0;
        %>
        <title><%=vector.get(0).get(2)%>'s bill - <%=vector.get(0).get(1)%></title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    </head>
    <body>
        <a href="OrderURL?service=viewOrder&customerID=<%=request.getParameter("customerID")%>">Go back</a>
        <br/><br/>
        <div><b>OrderID:</b> <%=vector.get(0).get(0)%></div>
        <div><b>OrderDate:</b> <%=vector.get(0).get(1)%></div>
        <div><b>Customer:</b> <%=vector.get(0).get(2)%></div>
        <div><b>Employee:</b> <%=vector.get(0).get(3)%></div>
        <br/><hr/><br/>
        <table>
            <caption>----------------Bill----------------</caption>
            <tr>
                <th>No</th>
                <th>Product</th>
                <th>Quantity</th>
                <th>UnitPrice</th>
                <th>Discount</th>
                <th>SubTotal</th>
            </tr>
            <% for (int i = 0; i < vector.size(); i++) {
                if(vector.get(i).get(8) == null) {
                    vector.get(i).set(8, "0");
                }
                try{
                    grandTotal += Double.parseDouble(vector.get(i).get(8));
                }catch(Exception e){}
            %>
            <tr>
                <td><%= (i + 1) %></td>
                <%for (int j = 4; j < vector.get(i).size(); j++) {
                    if(j != 2) {
                %>
                <td><%=vector.get(i).get(j)%></td>
                    <%}
                }%>
            </tr>
            <%}%>
            <tr>
                <td colspan="5"><b>Grand Total</b></td>
                <td><%= (String.format("%,.2f",grandTotal)) %></td>
            </tr>
        </table>
    </body>
</html>
