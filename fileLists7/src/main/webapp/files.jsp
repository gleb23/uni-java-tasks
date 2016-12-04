<%-- 
    Document   : files
    Created on : 07.01.2013, 17:30:28
    Author     : Hlib Babii <hlib.babii at hlibbabii.ua>
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" 
           uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ArrayList<String> fileNames =
                    (ArrayList<String>) session.getAttribute("files");
            out.println("" + fileNames.size() + " files available for you!");
        %>
        <c:forEach items="${sessionScope.files}" var="f"> 
            <% out.println(); %>
            <c:url var="url1" value="/GetFile">  
                <c:param name="name" value="${f}"/>  
            </c:url>            
            <a href="${url1}">${f}</a>
        </c:forEach>
    </body>
</html>
