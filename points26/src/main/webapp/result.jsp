<%-- 
    Document   : result
    Created on : 22.12.2012, 21:03:39
    Author     : Hlib Babii <hlib.babii at hlibbabii.ua>
--%>


<%@ taglib uri="/WEB-INF/tlds/points.tld" prefix="points"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Between circles number 
        <%= Integer.parseInt(session.getAttribute("circleNum").toString()) - 1 %> 
        and 
        <%= session.getAttribute("circleNum") %>
        <points:showPoints points="${sessionScope.points}"/>
    </body>
</html>
