<%-- 
    Document   : booksAdded
    Created on : Feb 9, 2016, 5:08:15 PM
    Author     : kym-1992
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books Added</title>
    </head>
    <body style="background-color: greenyellow">
        <h1><c:out value="${requestScope.quantity}"/> books added successfully</h1>
        <a href="books.jsp">Click here to go back to the main page</a>
    </body>
</html>
