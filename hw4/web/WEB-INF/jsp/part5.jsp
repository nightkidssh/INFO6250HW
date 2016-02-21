<%-- 
    Document   : part5
    Created on : Feb 21, 2016, 1:26:59 PM
    Author     : kym-1992
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="part5" uri="/WEB-INF/part5taglibrary.tld" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Part 5</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${requestScope.flag == 'init'}">
                <h1>Please enter the name of the file:</h1>
                <form method="post" action="part5.htm">
                    <input type="text" name="filename"/>
                    <input type="submit" name="submit" value="submit"/>
                    <input type="hidden" name="part5action" value="enterName"/>
                </form>                
            </c:when>
                <c:when test="${requestScope.flag == 'enterName'}">
                    <part5:part5tag />
                </c:when>
                    
                <c:when test="${requestScope.flag == 'added'}">
                    <h1>Number of column added: ${requestScope.quantity}</h1>
                    <a href="part5.htm">Return to home</a>
                </c:when>
        </c:choose>
                   
    </body>
</html>
