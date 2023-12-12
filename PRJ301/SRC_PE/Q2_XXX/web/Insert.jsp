<%-- 
    Document   : Insert
    Created on : Jul 13, 2023, 10:11:44 PM
    Author     : ASUS PC
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="insert" method="POST">
            Session of: ${user.displayname}<br>
             Name:<input type="text" name="name" value="" /> <br>
             Gender:
             <input type="radio" name="gender" value="1"  />Male
             <input type="radio" name="gender" value="0" />Female
             <br>
             
         Dob: <input type="date" name="date" value="" /> <br>
         Group<select name="group">
             <c:forEach var="item" items="${listgroup}">
                 <option value="${item.gid}" >${item.gname}</option>
             </c:forEach>
         </select>
         <br>
         <input type="submit" value="Save" />
        </form>
    </body>
</html>
