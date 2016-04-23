<%--
  Created by IntelliJ IDEA.
  User: kym-1992
  Date: 4/23/16
  Time: 00:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change your password</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-2.2.3.js" integrity="sha256-laXWtGydpwqJ8JA+X9x2miwmaiKhn8tVmOVEigRNtP4=" crossorigin="anonymous"></script>
</head>
<body>
<div class="container-fluid">
<c:choose>
    <c:when test="${sessionScope.loggedInAccount.userName != null}">
    </c:when>
    <c:otherwise>
        <jsp:forward page="/realIndex.do">
            <jsp:param name="loginError" value="Please Login First"/>
        </jsp:forward>
    </c:otherwise>
</c:choose>

    <h1>Change password for ${sessionScope.loggedInAccount.userName}</h1>
    <form action="changePassword.do" method="post">
        <div class="form-group">
            <label for="oldPass">Old password</label>
            <label>Password Requirement: #must contains one digit from 0-9 <br/>#must contains one lowercase characters <br/>#must contains one uppercase characters
                <br/>#must contains one special symbols "@#$%" <br/>#length at least 6 characters and maximum of 20<br/></label><br/>
            <input type="password" class="form-control" id="oldPass" placeholder="old Password" name="oldPass" required/>
            <label style="color: red">${requestScope.oldPassError}</label>
        </div>
        <div class="form-group">
            <label for="newPass">New password</label>
            <input type="password" class="form-control" id="newPass" placeholder="new Password" name="newPass" required/>
            <label style="color: red">${requestScope.newPassError}</label>
        </div>
        <div class="form-group">
            <label for="confirmPass">Confirm password</label>
            <input type="password" class="form-control" id="confirmPass" placeholder="Confirm Password" name="confirmPass" required/>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
    <button onclick="location.href='realIndex.do'" class="btn btn-default">Back to Home Page</button>
</div>
</body>
</html>
