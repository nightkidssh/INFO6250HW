<%-- 
    Document   : addMovie
    Created on : Feb 8, 2016, 5:23:44 PM
    Author     : kym-1992
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add movie to Database</title>
    </head>
    <body style="background-color:cyan;">
        <h1>Please enter the details below:</h1>
        <form action="movie.do" method="post">
            <table>
                <tr>
                    <td>Movie Title:</td>
                    <td><input type="text" name="title" size="80" required /></td>
                </tr>    
                <tr>
                    <td>Lead Actor:</td>
                    <td><input type="text" name="actor" size="30" required /></td>
                </tr>  
                <tr>
                    <td>Lead Actress</td>
                    <td><input type="text" name="actress" size="30" required /></td>
                </tr>
                <tr>
                    <td>Genre</td>
                    <td><input type="text" name="genre" size="20" required /></td>
                </tr>
                <tr>
                    <td>Year</td>
                    <td><input type="number" min="1000" max="2016" name="year" size="11" required /></td>
                </tr>
            </table>
            <input type="submit" value="Submit"/>
            <input type="hidden" name="action" value="doAddMovie" />
        </form>
    </body>
</html>
