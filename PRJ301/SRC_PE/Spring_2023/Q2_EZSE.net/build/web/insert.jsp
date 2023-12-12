<%-- 
    Document   : insert
    Created on : Mar 18, 2023, 8:53:17 PM
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
        Session of: ${user.displayname}
        <br>
        <br>
        <form action="insert" method="post">
            Name: <input type="text" name="name"/>
            <br>
            Gender: 
            <input type="radio" name="gender" value="1" id="radioMale" checked /><label for="radioMale">Male</label>
            <input type="radio" name="gender" value="0" id="radioFemale" /><label for="radioFemale">Female</label>
            <br>
            Dob: <input type="date" name="dob"/>
            <br>
            Group: 
            <select name="group">
                <c:forEach var="group" items="${groupList}">
                    <option value="${group.gid}">${group.gname}</option>
                </c:forEach>
            </select>
            <br>
            <input type="submit" value="Save" />
        </form>
    </body>
</html>
