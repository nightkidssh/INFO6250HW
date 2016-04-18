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
<h1>List of your accounts:</h1>
<form action="sysadminpanel.do" method="post">
    <table border="1">
        <tr>
            <td>accountID</td>
            <td>userName</td>
            <td>dateCreated</td>
            <td>accountType</td>
            <td>firstName</td>
            <td>lastName</td>
            <td>sex</td>
            <td>phoneNumber</td>
            <td>emailAddress</td>
            <td>mailingAddress</td>
            <td>zipCode</td>
            <td>Delete</td>
        </tr>

        <c:forEach var="record" items="${requestScope.resultSet}">
            <tr>
                <td><input type="text" name= "accountID" value="${record.getListingID()}" readonly=""/></td>
                <td><input type="text" name= "userName" value="${record.getListingType()}" readonly=""/></td>
                <td><input type="text" name= "dateCreated" value="${record.getCombinedAccount().getAccountID()}" readonly=""/></td>
                <td><input type="text" name= "accountType" value="${record.getAddress()}" readonly=""/></td>
                <td><input type="text" name= "firstName" value="${record.getZipCode()}" readonly=""/></td>
                <td><input type="text" name= "lastName" value="${record.getLatitude()}" readonly=""/></td>
                <td><input type="text" name= "sex" value="${record.getLongitude()}" readonly=""/></td>
                <td><input type="text" name= "phoneNumber" value="${record.getDescription()}" readonly=""/></td>
                <td><input type="text" name= "emailAddress" value="${record.getNumberOfBeds()}" readonly=""/></td>
                <td><input type="text" name= "mailingAddress" value="${record.getNumberOfBaths()}" readonly=""/></td>
                <td><input type="text" name= "zipCode" value="${record.getSizeInSqft()}" readonly=""/></td>

            </tr>
        </c:forEach>
    </table>
</body>
</html>
