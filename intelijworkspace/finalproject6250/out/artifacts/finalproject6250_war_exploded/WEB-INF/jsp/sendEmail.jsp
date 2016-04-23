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
<html5>
<head>
    <title>Show detail and send email</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-2.2.3.js" integrity="sha256-laXWtGydpwqJ8JA+X9x2miwmaiKhn8tVmOVEigRNtP4=" crossorigin="anonymous"></script>
</head>
<body>
<div class="container-fluid">
    <c:set var="accountTypee">${sessionScope.loggedInAccount.accountType}</c:set>
    <c:choose>
        <c:when test="${sessionScope.loggedInAccount.userName != null && accountTypee == 'HomeBuyer' && requestScope.emailAddress!=null}">
        </c:when>
        <c:otherwise>
            <jsp:forward page="/realIndex.do">
                <jsp:param name="loginError" value="Please Login First"/>
            </jsp:forward>
        </c:otherwise>
    </c:choose>

    <div>
        <img src="uploadedphoto/${requestScope.listingObj.fileLocation1}" class="img-responsive" alt="Responsive image">
        <img src="uploadedphoto/${requestScope.listingObj.fileLocation2}" class="img-responsive" alt="Responsive image">
        <img src="uploadedphoto/${requestScope.listingObj.fileLocation3}" class="img-responsive" alt="Responsive image">
        <img src="uploadedphoto/${requestScope.listingObj.fileLocation4}" class="img-responsive" alt="Responsive image">
    </div>

    <h1>Send Email</h1>
    <form action="sendEmail.do" method="post">
        <div class="form-group">
            <label for="title">Title</label>
            <input type="text" class="form-control" id="title" placeholder="title" name="title" required/>
        </div>
        <div class="form-group">
            <label for="Content">Content</label>
            <textarea class="form-control" id="Content" placeholder="EmailContent" name="Content" required></textarea>
        </div>
        <input type="hidden" name="email" value="${requestScope.emailAddress}"/>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>
</body>
</html5>
