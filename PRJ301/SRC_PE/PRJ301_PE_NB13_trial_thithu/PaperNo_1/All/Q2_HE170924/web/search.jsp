<%-- 
    Document   : search
    Created on : Oct 30, 2023, 10:54:07 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%ResultSet rs = (ResultSet)request.getAttribute("data");%>
    </head>
    <body>
        <form action="search" method="get">
            Name<input name="name"/>
            <input type="submit" value="search"/>
        </form>
        <%if(rs != null) {%>
        <table>
            <tr>
                <th>sid</th>
                <th>name</th>
                <th>gender</th>
                <th>dob</th>
            </tr>
            <%while(rs.next()){%>
            <tr>
                <td><%=rs.getInt(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getInt(3)%></td>
                <td><%=rs.getString(4)%></td>
            </tr>
            <%}%>
        </table>
        <%}%>
    </body>
</html>
