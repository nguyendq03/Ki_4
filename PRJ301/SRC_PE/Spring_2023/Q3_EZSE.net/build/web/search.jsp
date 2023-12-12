<%-- 
    Document   : search
    Created on : Mar 18, 2023, 9:29:13 PM
    Author     : Hoang Hiep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="search" method="POST">
            Group: 
            <select name="gid">
                <option value="0">ALL</option>
                <c:forEach var="group" items="${groupList}">
                    <option ${gid == group.gid ? "selected" : ""} value="${group.gid}">${group.gname}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Search" />
        </form>
        <br>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>DOB</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="member" items="${memberList}">
                    <tr>
                        <td>${member.mid}</td>
                        <td>${member.mname}</td>
                        <td>${member.gender}</td>
                        <td>${member.dob}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
