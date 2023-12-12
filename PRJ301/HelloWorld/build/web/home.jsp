<%-- 
    Document   : home
    Created on : Sep 11, 2023, 10:21:12 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>

        <%@include file="header.jsp" %>
        <h1>Hello <%= request.getParameter("first_name")%>!</h1>
        <p>
            <% 
               int a=5;
               int b=3;
               out.println(a+b);
            %>
            <br>
            a =<%=a%>
            b=<%=b%>
        </p>
        <br>
        <%if(a>b){ %>
        <p>a greater than b</p>
        <%} else { %>
        <p>b greater than a</p>
        <%}%>
        <p>
            <% 
                switch(a){
                    case 0:
                        out.print("Sunday");
                        break;
                    case 1:
                        out.print("Monday");
                        break;
                    case 2:
                        out.print("Tuesday");
                        break;
                    default:
                        out.print("<span style = 'color: red'</span>Other");
            }
            %>

            <%
                for(int i=0;i<10;i++) {
            %>
            <p><%=i%></p>
            <%
                }
            %>
        </p>
        Today's date: <%= (new java.util.Date()).toLocaleString() %>
    </body>
</html>
