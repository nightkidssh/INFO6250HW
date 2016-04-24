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
    <script src="https://code.jquery.com/jquery-2.2.3.js" integrity="sha256-laXWtGydpwqJ8JA+X9x2miwmaiKhn8tVmOVEigRNtP4=" crossorigin="anonymous"></script>
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    <meta property="og:type" content="website" />
    <meta property="og:title" content="Beautiful real estate listing at ${requestScope.listingObj.getAddress()}" />
    <meta property="og:description" content="${requestScope.listingObj.getDescription()}" />
</head>
<body>
<div id="fb-root"></div>
<script>
    window.fbAsyncInit = function() {
        FB.init({
            appId      : '1702383136679634',
            xfbml      : true,
            version    : 'v2.6'
        });
    };

    (function(d, s, id){
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) {return;}
        js = d.createElement(s); js.id = id;
        js.src = "//connect.facebook.net/en_US/sdk.js";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));

    FB.ui({
        method: 'share',
        href: 'https://developers.facebook.com/docs/',
    }, function(response){});
</script>
<div class="container-fluid">
    <c:set var="accountTypee">${sessionScope.loggedInAccount.accountType}</c:set>
    <%--<c:choose>--%>
        <%--<c:when test="${sessionScope.loggedInAccount.userName != null && requestScope.emailAddress!=null}">--%>
        <%--</c:when>--%>
        <%--<c:otherwise>--%>
            <%--<jsp:forward page="/realIndex.do">--%>
                <%--<jsp:param name="loginError" value="Please Login First"/>--%>
            <%--</jsp:forward>--%>
        <%--</c:otherwise>--%>
    <%--</c:choose>--%>

    <div>
        <c:if test="${requestScope.listingObj.fileLocation1!=null}">
        <img src="uploadedphoto/${requestScope.listingObj.fileLocation1}" class="img-responsive" alt="Responsive image">
        </c:if>
        <c:if test="${requestScope.listingObj.fileLocation2!=null}">
        <img src="uploadedphoto/${requestScope.listingObj.fileLocation2}" class="img-responsive" alt="Responsive image">
        </c:if>
        <c:if test="${requestScope.listingObj.fileLocation3!=null}">
        <img src="uploadedphoto/${requestScope.listingObj.fileLocation3}" class="img-responsive" alt="Responsive image">
        </c:if>
        <c:if test="${requestScope.listingObj.fileLocation4!=null}">
        <img src="uploadedphoto/${requestScope.listingObj.fileLocation4}" class="img-responsive" alt="Responsive image">
        </c:if>
    </div>

    <table border="1" class="table">
        <tr>
            <td>listingID</td>
            <td>${requestScope.listingObj.getListingID()}</td>
        </tr>
        <tr>
            <td>listingType</td>
            <td>${requestScope.listingObj.getListingType()}</td>
        </tr>
        <tr>
            <td>accountID</td>
            <td>${requestScope.listingObj.getCombinedAccount().getAccountID()}</td>
        </tr>
        <tr>
            <td>address</td>
            <td>${requestScope.listingObj.getAddress()}</td>
        </tr>
        <tr>
            <td>zipCode</td>
            <td>${requestScope.listingObj.getZipCode()}</td>
        </tr>
        <tr>
            <td>latitude</td>
            <td>${requestScope.listingObj.getLatitude()}</td>
        </tr>
        <tr>
            <td>longitude</td>
            <td>${requestScope.listingObj.getLongitude()}</td>
        </tr>
        <tr>
            <td>description</td>
            <td>${requestScope.listingObj.getDescription()}</td>
        </tr>
        <tr>
            <td>numberOfBeds</td>
            <td>${requestScope.listingObj.getNumberOfBeds()}</td>
        </tr>
        <tr>
            <td>numberOfBaths</td>
            <td>${requestScope.listingObj.getNumberOfBaths()}</td>
        </tr>
        <tr>
            <td>sizeInSqft</td>
            <td>${requestScope.listingObj.getSizeInSqft()}</td>
        </tr>
        <tr>
            <td>lotSize</td>
            <td>${requestScope.listingObj.getLotSize()}</td>
        </tr>
        <tr>
            <td>type</td>
            <td>${requestScope.listingObj.getType()}</td>
        </tr>
        <tr>
            <td>yearOfBuilt</td>
            <td>${requestScope.listingObj.getYearOfBuilt()}</td>
        </tr>
        <tr>
            <td>heatingType</td>
            <td>${requestScope.listingObj.getHeatingType()}</td>
        </tr>
        <tr>
            <td>propertyTax</td>
            <td>${requestScope.listingObj.getPropertyTax()}</td>
        </tr>
        <tr>
            <td>comments</td>
            <td>${requestScope.listingObj.getComments()}</td>
        </tr>
        <tr>
            <td>price</td>
            <c:if test="${requestScope.listingObj.getClass().simpleName =='SalesListing'}">
                <td>${requestScope.listingObj.getListPrice()}</td>
            </c:if>
        </tr>

    </table>

    <script>
        document.write("<div class='fb-share-button' data-href='" + window.location.href + "' data-layout='button_count' data-mobile-iframe='true'></div>");
    </script>


    <c:if test="${accountTypee == 'HomeBuyer'}">
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
    </c:if>
</div>
</body>
</html5>
