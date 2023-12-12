<%-- 
    Document   : listAllCategory
    Created on : Oct 13, 2023, 11:48:17 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector" %>
<%@page import="entity.Category" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Category</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
    </head>
    <body>
        <%
            Vector<Category> vector=(Vector<Category>)request.getAttribute("data");
            String message=(String)request.getAttribute("message"); 
        %>
        <div style="text-align: right">
            <a href="/SE1760Review">Home</a>
        </div>
        <p style="color:red"><%=message%></p>
        <p><a href="CategoryURL?service=insertCategory">Insert Category</a></p>
        <table>
            <caption>Category List</caption>
            <tr>
                <th>CategoryID</th>
                <th>CategoryName</th>
                <th>Description</th>
                <th>Picture</th>
                <th colspan="2">Action</th>
            </tr>
            <% for (Category category : vector) { %>
            <tr>
                <td><%=category.getCategoryID()%></td>
                <td><%=category.getCategoryName()%></td>
                <td><%=category.getDescription()%></td>
                <td><img src="vsg" alt="<%=category.getCategoryName()%>"/></td>
                <td><a href="CategoryURL?service=updateCategory&cid=<%=category.getCategoryID()%>">update</a></td>
                <td><a href="CategoryURL?service=deleteCategory&cid=<%=category.getCategoryID()%>">delete</a></td>
            </tr>
            <% } %>
        </table>
    </body>
</html>
