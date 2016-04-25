<%--
  Created by IntelliJ IDEA.
  User: kym-1992
  Date: 4/15/16
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html5>
<head>
    <title>Show All Listing</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-2.2.3.js" integrity="sha256-laXWtGydpwqJ8JA+X9x2miwmaiKhn8tVmOVEigRNtP4=" crossorigin="anonymous"></script>
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    <style type="text/css">
        div#map_container{
            width:60%;
            height:60%;
            margin: 0 auto;
        }
    </style>
    <link rel="stylesheet" href="/css/showResultCSS.css">
    <script async defer src="https://maps.googleapis.com/maps/api/js?sensor=false"
            type="text/javascript"></script>
    <script type="text/javascript">
        function loadMap() {
            //Put data in array
            var dataArray = [
                <c:forEach var="record" items="${requestScope.resultSet}" varStatus="loop">
                [ '<c:out value="${record.getAddress()}"/>', <c:out value="${record.getLatitude()}"/>, <c:out value="${record.getLongitude()}"/>, <c:out value="${loop.index}"/>],
                </c:forEach>

            ];

            var myOptions = {
                zoom: 15,
                center: new google.maps.LatLng(dataArray[0][1], dataArray[0][2]),
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            var map = new google.maps.Map(document.getElementById("map_container"), myOptions);
            var infowindow = new google.maps.InfoWindow();

            if(dataArray.length > 0) {
                var marker, i;
                for(i = 0; i < dataArray.length; i++) {
                    marker = new google.maps.Marker({
                        position: new google.maps.LatLng(dataArray[i][1], dataArray[i][2]),
                        map: map,
                        title: dataArray[i][0]
                    });
                    google.maps.event.addListener(marker, 'click', (function (marker, i) {
                        return function () {
                            document.getElementById("listTable").style.backgroundColor="white";
                            document.getElementById("listTable").rows[dataArray[i + 1][3]].style.backgroundColor = 'green';
                            document.getElementById("listTable").rows[dataArray[i + 1][3]].focus();
                            infowindow.setContent(dataArray[i][0]);
                            infowindow.open(map, marker);
                        }
                    })(marker, i));
                }
            }
        }
    </script>

</head>
<body>

<body onload="loadMap()">
<div class="container-fluid">
<div id="logoutContainer" class="global" style="background-color: white; opacity: 0.9">
    <c:set var="accountTypee">${sessionScope.loggedInAccount.accountType}</c:set>
    <c:choose>
        <c:when test="${sessionScope.loggedInAccount.userName != null && accountTypee == 'HomeBuyer'}">
            <form method = "post" action="/logout.do" style="display: inline-block;">
                <label>Welcome ${sessionScope.loggedInAccount.accountType} ${sessionScope.loggedInAccount.userName}</label>
                <input type="submit" name="Logout" value="Logout"/>
            </form>
            <button onclick="location.href='realIndex.do'">Return to HomePage</button>
        </c:when>
        <c:otherwise>
            <jsp:forward page="/realIndex.do">
                <jsp:param name="loginError" value="Please Login First"/>
            </jsp:forward>
        </c:otherwise>
    </c:choose>
</div>

<h1>All our listing:</h1>
<form action="buyerlisting.do" method="post">
    <table border="1" class="table" id="listTable">
        <tr>
            <td>listingID</td>
            <td>listingType</td>
            <td>address</td>
            <td>zipCode</td>
            <td>description</td>
            <td>numberOfBeds</td>
            <td>numberOfBaths</td>
            <td>sizeInSqft</td>
            <td>price</td>
            <td>Show Detail</td>
            <td>Download PDF</td>
        </tr>

        <c:forEach var="record" items="${requestScope.resultSet}">
            <tr>
                <td><input type="text" name= "listingID" value="${record.getListingID()}" readonly=""/></td>
                <td><input type="text" name= "listingType" value="${record.getListingType()}" readonly=""/></td>
                <td><input type="text" name= "address" value="${record.getAddress()}" readonly=""/></td>
                <td><input type="text" name= "zipCode" value="${record.getZipCode()}" readonly=""/></td>
                <td><input type="text" name= "description" value="${record.getDescription()}" readonly=""/></td>
                <td><input type="text" name= "numberOfBeds" value="${record.getNumberOfBeds()}" readonly=""/></td>
                <td><input type="text" name= "numberOfBaths" value="${record.getNumberOfBaths()}" readonly=""/></td>
                <td><input type="text" name= "sizeInSqft" value="${record.getSizeInSqft()}" readonly=""/></td>
                <c:if test="${record.getClass().simpleName =='SalesListing'}">
                    <td><input type="text" name= "price" value="${record.getListPrice()}" readonly=""/></td>
                </c:if>
                <td><button name= "emailbutton" onclick="openEmailWindow(${record.getListingID()}); return false;">Show Detail</button></td>
                <td><button name= "pdfbutton" onclick="openPDFWindows(${record.getListingID()}); return false;">Download PDF</button></td>
            </tr>
        </c:forEach>
    </table>
    <c:forEach var="page" begin="1" end="${requestScope.maxPage}">
        <c:choose>
            <c:when test="${page == requestScope.currentPage+1}">
                <a>[${page}]</a>
            </c:when>
            <c:otherwise>
                <a href="showmylisting.do?page=${page}">  [${page}]  </a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</form>

<div id="map_container"></div>
</div>
<script>
    function openEmailWindow(listingID) {
        window.open("sendEmail.do?listingID=" + listingID, "emailWindow", "width=1024,height=768");
    }

    function openPDFWindows(listingID) {
        window.open("report.pdf?listingID=" + listingID, "pdfWindow", "width=1024,height=768");
    }
</script>
</body>
</html5>
