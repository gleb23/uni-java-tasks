<%-- 
    Document   : index
    Created on : 22.12.2012, 19:55:53
    Author     : Hlib Babii <hlib.babii at hlibbabii.ua>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Enter data</h1>
        <form action="findpoints" method="GET" >
            <div>
                Center
                <input type="text" name="x">
                <input type="text" name="y">
            </div>
            <div>
                Radius 1
                <input type="text" name="radius1">
            </div>
            <div>
                Radius 2
                <input type="text" name="radius2">
            </div>
            <div>
                Radius 3
                <input type="text" name="radius3">
            </div>
            <div>
                Radius 4
                <input type="text" name="radius4">
            </div>
            <div>
                Radius 5
                <input type="text" name="radius5">
            </div>
            <input type="submit" value="Ok!"/>
        </form>
    </body>
</html>
