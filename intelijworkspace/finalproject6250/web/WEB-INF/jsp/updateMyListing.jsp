<%--
  Created by IntelliJ IDEA.
  User: kym-1992
  Date: 4/23/16
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html5>
<head>
    <title>Update my listing</title>
    <link rel="stylesheet" href="/css/registerCSS.css">
</head>
<body>
<body background="ImageResources/o-BOSTON-facebook.jpg">
    <div id="logoutContainer" class="global" style="background-color: white; opacity: 0.9">
        <c:set var="accountTypee">${sessionScope.loggedInAccount.accountType}</c:set>
        <c:choose>
        <c:when test="${sessionScope.loggedInAccount.userName != null && accountTypee == 'Landlord'}">
        <form method = "post" action="/logout.do" style="display: inline-block;">
            <label>Welcome ${sessionScope.loggedInAccount.accountType} ${sessionScope.loggedInAccount.userName}</label>
            <input type="submit" name="Logout" value="Logout"/>
        </form>
        </c:when>
        <c:otherwise>
        <jsp:forward page="/realIndex.do">
            <jsp:param name="loginError" value="Please Login First"/>
        </jsp:forward>
        </c:otherwise>
        </c:choose>
    </div>

    <div id="globalContainer" class="global" style="background-color: white; opacity: 0.9">
        <form:form action="updateListing.do" enctype="multipart/form-data" method="post" commandName="salesListing">
            <h1>Update listing ${requestScope.salesListing.address}</h1>
            <div id="listingDetailSection" class="default" style="background-color: white">
                <h3>Listing Detail</h3>&nbsp&nbsp

                <input type="hidden" name="listingID" value="${requestScope.salesListing.listingID}"/>
                <form:textarea path="description" id="description" placeholder="Description" rows="5" cols="50"/><br/>&nbsp&nbsp
                <form:errors path="description"/><br/>&nbsp&nbsp

                <label>Number of Beds</label>
                <form:input path="numberOfBeds" id="numberOfBeds" placeholder="numberOfBeds"/><br/>&nbsp&nbsp
                <form:errors path="numberOfBeds"/><br/>&nbsp&nbsp

                <label>Number Of Baths</label>
                <form:input path="numberOfBaths" id="numberOfBaths" placeholder="numberOfBaths"/><br/>&nbsp&nbsp
                <form:errors path="numberOfBaths"/><br/>&nbsp&nbsp

                <label>Size In Sqft</label>
                <form:input path="sizeInSqft" id="sizeInSqft" placeholder="sizeInSqft"/><br/>&nbsp&nbsp
                <form:errors path="sizeInSqft"/><br/>&nbsp&nbsp

                <label>Lot Size</label>
                <form:input path="lotSize" id="lotSize" placeholder="lotSize"/><br/>&nbsp&nbsp
                <form:errors path="lotSize"/><br/>&nbsp&nbsp

                <form:input path="type" id="type" placeholder="Property Type(Apartment, house etc."/><br/>&nbsp&nbsp
                <form:errors path="type"/><br/>&nbsp&nbsp

                <label>Year Of Built</label>
                <form:input path="yearOfBuilt" id="yearOfBuilt" placeholder="yearOfBuilt"/><br/>&nbsp&nbsp
                <form:errors path="yearOfBuilt"/><br/>&nbsp&nbsp

                <form:input path="heatingType" id="heatingType" placeholder="heatingType"/><br/>&nbsp&nbsp
                <form:errors path="heatingType"/><br/>&nbsp&nbsp

                <label>Property Tax</label>
                <form:input path="propertyTax" id="propertyTax" placeholder="propertyTax"/><br/>&nbsp&nbsp
                <form:errors path="propertyTax"/><br/>&nbsp&nbsp

                <form:textarea path="comments" id="comments" placeholder="comments" rows="5" cols="50"/><br/>&nbsp&nbsp
                <form:errors path="comments"/><br/>&nbsp&nbsp

                <label>List Price</label>
                <form:input path="listPrice" id="listPrice" placeholder="listPrice"/><br/>&nbsp&nbsp
                <form:errors path="listPrice"/><br/>&nbsp&nbsp
            </div>

            <div id="fileUploadSection" class="default" style="background-color: white">
                <h3>Photo upload</h3>&nbsp&nbsp
                <form:input path="file1" id="file1" type="file" accept="image/*"/><br/>&nbsp&nbsp
                <form:errors path="file1"/>

                <form:input path="file2" id="file2" type="file" accept="image/*"/><br/>&nbsp&nbsp
                <form:errors path="file2"/>

                <form:input path="file3" id="file3" type="file" accept="image/*"/><br/>&nbsp&nbsp
                <form:errors path="file3"/>

                <form:input path="file4" id="file4" type="file" accept="image/*"/><br/>&nbsp&nbsp
                <form:errors path="file4"/>
            </div>

            <div id="submitSection" class="default" style="background-color: white">
                <input type="submit" name="submit" value="Submit"/>
            </div>
        </form:form>
        <button onclick="location.href='realIndex.do'">Back to Home Page</button>

    </div>
</body>
</html5>
