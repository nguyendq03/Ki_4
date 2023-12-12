<%-- 
    Document   : search
    Created on : Apr 24, 2022, 8:39:54 PM
    Author     : vietd
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post">
            <div>Account: <select name="username">
                    <c:forEach items="${accounts}" var="a">
                        <option value="${a.getUsername()}" ${username eq a.getUsername()? "selected" : ""}>${a.getDisplayname()}</option>
                    </c:forEach>
                </select>
                <button>Search</button>
            </div>
        </form>
        <c:if test="${employees!=null}">
            <div>
                <table border="1">
                    <thead>
                        <tr>
                            <th>Employee Id</th>
                            <th>Name</th>
                            <th>Dob</th>
                            <th>Gender</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${employees}" var="e">
                            <tr>
                                <td>${e.getEmployeeId()}</td>
                                <td>${e.getEmployeeName()}</td>
                                <td>${e.getDob()}</td>
                                <td>${e.getGender()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
    </body>
</html>
