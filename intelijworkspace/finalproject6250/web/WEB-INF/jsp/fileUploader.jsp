<%--
  Created by IntelliJ IDEA.
  User: kym-1992
  Date: 4/19/16
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload your images</title>
    <link rel="stylesheet" href="/css/showResultCSS.css">
</head>
<body>
<div id="logoutContainer" class="global" style="background-color: white; opacity: 0.9">
    <c:choose>
        <c:when test="${sessionScope.loggedInAccount.userName != null}">
            <form method = "post" action="/logout.do" style="display: inline-block;">
                <label>Welcome ${sessionScope.loggedInAccount.accountType} ${sessionScope.loggedInAccount.userName}</label>
                <input type="submit" name="Logout" value="Logout"/>
            </form>
            <button onclick="location.href='salesListing.do'">Add New SalesListing</button>
            <button onclick="location.href='realIndex.do'">Return to HomePage</button>
        </c:when>
        <c:otherwise>
            <jsp:forward page="/realIndex.do">
                <jsp:param name="loginError" value="Please Login First"/>
            </jsp:forward>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
