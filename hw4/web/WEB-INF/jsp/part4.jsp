<%-- 
    Document   : part4
    Created on : Feb 20, 2016, 12:37:35 PM
    Author     : kym-1992
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Part 4</title>
    </head>
    <body>
        <h1>Please enter the name of the file:</h1>
        <form method="post" action="part4.htm">
            <input type="text" name="filename"/>
            <input type="submit" name="submit" value="submit"/>
            <input type="hidden" name="part4action" value="enterName"/>
        </form>
    </body>
</html>
