<%-- 
    Document   : addBooks
    Created on : Feb 9, 2016, 5:08:07 PM
    Author     : kym-1992
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enter Book Details</title>
    </head>
    <body style="background-color: yellowgreen">
        <table style="border: 1">
            <tr>
                <td>ISBN</td>
                <td>Book Title</td>
                <td>Authors</td>
                <td>Prices</td>
            </tr>
            <c:forEach begin="0" end="${requestScope.bookQuantity}">
                <tr>
                    <td><input type="text" name="isbn" size="12" required/></td>
                    <td><input type="text" name="title" size="60" required/></td>
                    <td><input type="text" name="authors" size="60" required/></td>
                    <td><input type="number" min="0" name="price" required/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
