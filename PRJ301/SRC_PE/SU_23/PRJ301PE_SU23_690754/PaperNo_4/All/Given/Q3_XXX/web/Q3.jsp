<%-- 
    Document   : Q3
    Created on : Nov 4, 2023, 12:16:58 AM
    Author     : admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Q3 Page</title>
    </head>
    <body>
        List of Students
        <table border="1">
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Date of birth</th>
                <th>Gender</th>
                <th>Select</th>
            </tr>
            <c:forEach items="${requestScope.listStudent}" var="item">
                <tr>
                    <td>${item.studentID}</td>
                    <td>${item.studentName}</td>
                    <td>${item.birthday}</td>
                    <td>${item.gender}</td>
                    <td><a href="update?service=viewInfo&studentID=${item.studentID}">Select</a></td>
                </tr>
            </c:forEach>
        </table>
        <br/>
        <br/>
        
        <form action="update" method="post">
            <div>Detail information:</div>
            Code:<input name="code" value="${requestScope.stuInfo.studentID}"/>  
            Name:<input name="name" value="${requestScope.stuInfo.studentName}"/>
            <br/>
            Date of birth:<input name="dob" value="${requestScope.stuInfo.birthday}"/>  
            Gender:
            <input type="radio" name="gender" value="1" ${requestScope.stuInfo.gender == 'Male' ? 'checked' : ''}/>Male 
            <input type="radio" name="gender" value="0" ${requestScope.stuInfo.gender == 'Female' ? 'checked' : ''}/>Female
            <br/>
            Class: 
            <select name="classID">
                <c:forEach items="${requestScope.listClass}" var="item">
                    <option value="${item.classID}" ${item.classID == requestScope.stuInfo.classID ? 'selected' : ''}>
                        ${item.className}
                    </option>
                </c:forEach>
            </select>
            <input type="hidden" name="service" value="update"/>
            <input type="submit" name="submit" value="Update"/>
        </form>
        
    </body>
</html>
