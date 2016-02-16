<%-- 
    Document   : showMovie
    Created on : Feb 9, 2016, 3:25:54 PM
    Author     : kym-1992
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Result</title>
    </head>
    <body style="background-color: greenyellow">
        <h1>You searched for "${requestScope.searchedItem}"</h1>
        <h3><u>Here are the search results</u></h3>
        <table>
        <c:forEach var="movie" items="${requestScope.resultArrayList}">
            <tr>
                <td>Movie Title:</td>
                <td><c:out value="${movie.title}"/></td>
            </tr>
            <tr>
                <td>Lead Actor:</td>
                <td><td><c:out value="${movie.actor}"/></td></td>
            </tr>
            <tr>
                <td>Lead Actress:</td>
                <td><td><c:out value="${movie.actress}"/></td></td>
            </tr>
            <tr>
                <td>Genre:</td>
                <td><td><c:out value="${movie.genre}"/></td></td>
            </tr>
            <tr>
                <td>Year</td>
                <td><td><c:out value="${movie.year}"/></td></td>
            </tr>
        </c:forEach>
        </table>
        <a href="movie.jsp">Click here to go back to the main page</a>
    </body>
</html>
