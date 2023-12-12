<%-- 
    Document   : viewBillOfCustomer
    Created on : Oct 14, 2023, 6:34:01 PM
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
            String customerID = (String)request.getAttribute("customerID");
            double grandTotal = 0;
        %>
        <title><%=vector.get(0).get(2)%>'s bill</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    </head>
    </head>
    <body>
        <a href="CustomerURL?service=listAllCustomer">Back to CustomerList</a>
        <h1>Bill of Customer <%=vector.get(0).get(2)%></h1>
        <table>
            <caption>----------------Bill----------------</caption>
            <tr>
                <th>No</th>
                <th>OrderID</th>
                <th>OrderDate</th>
                <th>Employee</th>
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
                <%for (int j = 0; j < vector.get(i).size(); j++) {
                    if(j != 2) {
                %>
                        <%if(j == 1) {%>
                <td><a href="OrderURL?service=viewOrderInDay&customerID=<%=customerID%>&date=<%=vector.get(i).get(1)%>">
                        <%=vector.get(i).get(j)%>
                    </a>
                </td>
                        <%}else {%>
                <td><%=vector.get(i).get(j)%></td>
                        <%}%>
                    <%}
                }%>
            </tr>
            <%}%>
            <tr>
                <td colspan="8"><b>Grand Total</b></td>
                <td><%= (String.format("%,.2f",grandTotal)) %></td>
            </tr>
        </table>
    </body>
</html>
