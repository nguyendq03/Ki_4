<%-- 
    Document   : insert
    Created on : Mar 18, 2023, 10:59:59 PM
    Author     : LENOVO
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
        Session of : ${sessionScope.account.displayname}
        <form action="insert" method="post">
            Name:<input type="text" name="name"/><br/>
            Gender:
            <input type="radio" name="gender" value="1"/>Male
            <input type="radio" name="gender" value="0"/>Female<br/>
            Dob: <input type="date" name="dob" /><br/>
            Group:
            <select name="gid">
                <c:forEach items="${requestScope.listG}" var="g">
                    <option value="${g.gid}">${g.gname}</option>
                </c:forEach>
            </select><br/>
            <input type="submit"  value="Save"/>
        </form>
    </body>
</html>
