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
    <style type="text/css">
        div#map_container{
            width:90%;
            height:70%;
            margin: 0 auto;
        }
    </style>
    <script async defer src="https://maps.googleapis.com/maps/api/js?sensor=false"
            type="text/javascript"></script>
    <script type="text/javascript">
        function loadMap() {
            //Put data in array
            var dataArray = [
                <c:forEach var="record" items="${requestScope.resultSet}">
                [ <c:out value="${record.getAddress()}"/>, <c:out value="${record.getLatitude()}"/>, <c:out value="${record.getLongitude()}"/> ],
                </c:forEach>

            ];

            var myOptions = {
                zoom: 15,
                center: new google.maps.LatLng(42.3383292,-71.0886148),
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            var map = new google.maps.Map(document.getElementById("map_container"), myOptions);
            var infowindow = new google.maps.InfoWindow();

//            var marker = new google.maps.Marker({
//                position: latlng,
//                map: map,
//                title: "Northeastern University"
//            });
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
                            infowindow.setContent(locations[i][0]);
                            infowindow.open(map, marker);
                        }
                    })(marker, i));
                }
            }
        }
    </script>

</head>
<body onload="loadMap()">
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

<h1>List of your listing:</h1>
<form action="showmylisting.do" method="post">
    <table border="1">
        <tr>
            <td>listingID</td>
            <td>listingType</td>
            <td>accountID</td>
            <td>address</td>
            <td>zipCode</td>
            <td>latitude</td>
            <td>longitude</td>
            <td>description</td>
            <td>numberOfBeds</td>
            <td>numberOfBaths</td>
            <td>sizeInSqft</td>
            <td>lotSize</td>
            <td>type</td>
            <td>yearOfBuilt</td>
            <td>heatingType</td>
            <td>propertyTax</td>
            <td>comments</td>
            <td>price</td>
        </tr>

        <c:forEach var="record" items="${requestScope.resultSet}">
            <tr>
                <td><input type="text" name= "listingID" value="${record.getSalesOrderID()}" readonly=""/></td>
                <td><input type="text" name= "listingType" value="${record.getRevisionNumber()}" readonly=""/></td>
                <td><input type="text" name= "accountID" value="${record.getOrderDate()}" readonly=""/></td>
                <td><input type="text" name= "address" value="${record.getAddress()}" readonly=""/></td>
                <td><input type="text" name= "zipCode" value="${record.getShipDate()}" readonly=""/></td>
                <td><input type="text" name= "latitude" value="${record.getLatitude()}" readonly=""/></td>
                <td><input type="text" name= "longitude" value="${record.getLongitude()}" readonly=""/></td>
                <td><input type="text" name= "description" value="${record.getSalesOrderNumber()}" readonly=""/></td>
                <td><input type="text" name= "numberOfBeds" value="${record.getPurchaseOrderNumber()}" readonly=""/></td>
                <td><input type="text" name= "numberOfBaths" value="${record.getAccountNumber()}" readonly=""/></td>
                <td><input type="text" name= "sizeInSqft" value="${record.getCustomerID()}" readonly=""/></td>
                <td><input type="text" name= "lotSize" value="${record.getSalesPersonID()}" readonly=""/></td>
                <td><input type="text" name= "type" value="${record.getTerritoryID()}" readonly=""/></td>
                <td><input type="text" name= "yearOfBuilt" value="${record.getBillToAddressID()}" readonly=""/></td>
                <td><input type="text" name= "heatingType" value="${record.getShipToAddressID()}" readonly=""/></td>
                <td><input type="text" name= "propertyTax" value="${record.getShipMethodID()}" readonly=""/></td>
                <td><input type="text" name= "comments" value="${record.getCreditCardID()}" readonly=""/></td>
                <td><input type="text" name= "price" value="${record.getCreditCardApprovalCode()}" readonly=""/></td>
                <%--<td><input type="button" value="Remove" onclick="removeRow(this)"/></td>--%>
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

</body>
</html>
