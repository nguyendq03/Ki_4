<%-- 
    Document   : MyJSP
    Created on : Oct 2, 2023, 10:32:45 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--JSP script-->
        <h1>Hello World!</h1>
        <%
            //code java/jsp here
            int a=100;
            out.print("value a="+a);
        %>
        <!--jsp express-->
        <h2 style="color:red; font-family: sans-serif"> a= <%=a%></h2>
        
        <%for(int i=10;i<=200;i+=20){%>
            <hr width="<%=i%>" >
        <%}%>
        <!--declared: global variable, method-->
        <%int MaxLocal=1000;%>
        <%! int MAX=2000, MIN=1;%>
        <%!
            String display(String st){
                return "Welcome "+st;
            }
        %>
        <%
            String name="Trần Thanh Tùng";
        %>
        <%=display(name)%>
    </body>
</html>
