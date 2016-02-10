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
        <table border="1px">
            <tr>
                <td>ISBN</td>
                <td>Book Title</td>
                <td>Authors</td>
                <td>Prices</td>
            </tr>
            <c:forEach begin="1" end="${requestScope.bookQuantity}">
                <tr>
                    <td><input type="text" name="isbn" size="12" required/></td>
                    <td><input type="text" name="title" size="60" required/></td>
                    <td><input type="text" name="authors" size="60" required/></td>
                    <td><input type="number" min="0" name="price" required/></td>
                </tr>
            </c:forEach>
                <tr>
                    <td>
                        <input type="submit" value="Add Books"/>
                        <input type="hidden" name="action" value="doAddBook" />                        
                    </td>
                </tr>
        </table>
    </body>
</html>
