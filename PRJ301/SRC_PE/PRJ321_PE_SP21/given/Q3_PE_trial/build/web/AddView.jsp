<%-- 
    Document   : AddView
    Created on : Nov 2, 2021, 8:53:59 PM
    Author     : area1
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
        <form action="add" method="POST">
            <table>
                <tbody>
                    <tr>
                        <td>Paper ID:</td>
                        <td><input type="text" name="paperid"></td>
                    </tr>
                    <tr>
                        <td>Title:</td>
                        <td><input type="text" name="title"></td>
                    </tr>
                    <tr>
                        <td>Date:</td>
                        <td><input type="text" name="date">(yyyy-MM-dd)</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <c:forEach items="${authors}" var="a">
                                <input type="checkbox" value="${a.id}" name="authorid"/>${a.name}<br/>
                            </c:forEach>
                        </td>                    
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Save"></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
