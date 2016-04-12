<%--
  Created by IntelliJ IDEA.
  User: kym-1992
  Date: 4/11/16
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Listing</title>
</head>
<body>
<div id="logoutContainer" class="global" style="background-color: white; opacity: 0.9">
    <c:choose>
        <c:when test="${sessionScope.loggedInAccount.userName != null}">
            <form method = "post" action="/logout.do" style="display: inline-block;">
                <label>Welcome ${sessionScope.loggedInAccount.accountType} ${sessionScope.loggedInAccount.userName}</label>
                <input type="submit" name="Logout" value="Logout"/>
            </form>
        </c:when>
        <c:otherwise>
            <c:set var="Error" value="Please Login First!" scope="request"/>
            <c:redirect url="/realIndex.do"/>
        </c:otherwise>
    </c:choose>
</div>


</body>
</html>
