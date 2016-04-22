<%--
  Created by IntelliJ IDEA.
  User: kym-1992
  Date: 4/21/16
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show detail and send email</title>
</head>
<body>
<div id="logoutContainer" class="global" style="background-color: white; opacity: 0.9">
    <c:set var="accountTypee">${sessionScope.loggedInAccount.accountType}</c:set>
    <c:choose>
        <c:when test="${sessionScope.loggedInAccount.userName != null && accountTypee == 'HomeBuyer'}">
        </c:when>
        <c:otherwise>
            <jsp:forward page="/realIndex.do">
                <jsp:param name="loginError" value="Please Login First"/>
            </jsp:forward>
        </c:otherwise>
    </c:choose>

    <h1>Email</h1>
    <h1>${requestScope.emailAddress}</h1>
</div>
</body>
</html>
