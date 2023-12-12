<%-- 
    Document   : add
    Created on : Apr 24, 2022, 9:11:53 PM
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
        <h1>${message}</h1>
        <c:if test="${sessionScope.userLogged!=null}">
            <form method="post">
                <div>Id: <input type="number" name="id" required=""></div>
                <div>Name: <input type="text" name="name" required=""></div>
                <div>Dob: <input type="date" name="dob" required=""></div>
                <div>Gender: <input type="radio" name="gender" value="1"> Male 
                    <input type="radio" name="gender" value="0"> Female
                </div>
                <div>
                    Certificates: <br>
                    <c:forEach begin="0" end="${cer.size()-1}" step="1" var="i">
                        <input type="checkbox" name="cerId" value="${i} ${cer.get(i).getCertId()}"> ${cer.get(i).getCertname()} at <input name="cerDate" type="date"> <br>
                    </c:forEach>
                    <button>Save</button>
                </div>
            </form>
        </c:if>
    </body>
</html>
