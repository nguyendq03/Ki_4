<%-- 
    Document   : discuss
    Created on : Oct 30, 2023, 11:44:33 AM
    Author     : admin
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
        ${requestScope.mes}
        <c:if test="${requestScope.list != null}">
            <c:forEach items="${requestScope.list}" var="thread">
                <div>
                    Thread: ${thread.key.tContent}
                    <c:forEach items="${thread.value}" var="comment">
                        <c:if test="${comment != null}">
                            <p>
                                ${comment.displayName}: ${comment.ctitle}
                            </p>
                        </c:if>
                    </c:forEach>
                    <form>
                        <input name="ctitle"/> 
                        <input type="hidden" name="tid" value="${thread.key.tid}"/>
                        <input type="submit" name="submit" value="save"/>
                    </form>
                    <br><br><br>
                </div>
            </c:forEach>
        </c:if>

    </body>
</html>
