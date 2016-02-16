<%-- 
    Document   : movie
    Created on : Feb 8, 2016, 3:44:18 PM
    Author     : kym-1992
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie Store</title>
    </head>
    <body style="background-color:pink;">
        <h1>Welcome to our Movie Store</h1>
        <h3>Please make your selection below</h3>
        <form action="movie.do" method="post">
            <select name="loginOption">
                <option value="browse">Browse Movies</option>
                <option value="add">Add New Movie to Database</option>
            </select>            
            <input type="submit" value="Submit"/>
            <input type="hidden" name="action" value="login" />
        </form>
    </body>
</html>
