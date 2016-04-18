<%--
  Created by IntelliJ IDEA.
  User: kym-1992
  Date: 4/18/16
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>System Admin Panel</title>
</head>
<body>
<c:choose>
    <c:when test="${sessionScope.loggedInAccount.userName != null && sessionScope.loggedInAccount.accountType == 'System Admin Account'}">
        <form method = "post" action="/logout.do" style="display: inline-block;">
            <label>Welcome ${sessionScope.loggedInAccount.accountType} ${sessionScope.loggedInAccount.userName}</label>
            <input type="submit" name="Logout" value="Logout"/>
        </form>
        <button onclick="location.href='salesListing.do'">Add New SalesListing</button>
    </c:when>
    <c:otherwise>
        <jsp:forward page="/realIndex.do">
            <jsp:param name="loginError" value="Please Login First"/>
        </jsp:forward>
    </c:otherwise>
</c:choose>
<h1>SystemAdmin!!!!!</h1>
</body>
</html>
