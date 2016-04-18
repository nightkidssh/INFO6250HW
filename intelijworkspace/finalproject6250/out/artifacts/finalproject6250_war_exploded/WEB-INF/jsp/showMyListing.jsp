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
                <c:forEach var="record" items="${requestScope.resultSet}">
                [ '<c:out value="${record.getAddress()}"/>', <c:out value="${record.getLatitude()}"/>, <c:out value="${record.getLongitude()}"/> ],
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
                            infowindow.setContent(dataArray[i][0]);
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
            <button onclick="location.href='salesListing.do'">Add New SalesListing</button>
        </c:when>
        <c:otherwise>
            <%--<c:set var="Error" value="Please Login First!" scope="request"/>--%>
            <c:redirect url="/realIndex.do">
                <c:param name="Error"  value="Please Login First!"/>
            </c:redirect>
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
            <td>Delete</td>
        </tr>

        <c:forEach var="record" items="${requestScope.resultSet}">
            <tr>
                <td><input type="text" name= "listingID" value="${record.getListingID()}" readonly=""/></td>
                <td><input type="text" name= "listingType" value="${record.getListingType()}" readonly=""/></td>
                <td><input type="text" name= "accountID" value="${record.getCombinedAccount().getAccountID()}" readonly=""/></td>
                <td><input type="text" name= "address" value="${record.getAddress()}" readonly=""/></td>
                <td><input type="text" name= "zipCode" value="${record.getZipCode()}" readonly=""/></td>
                <td><input type="text" name= "latitude" value="${record.getLatitude()}" readonly=""/></td>
                <td><input type="text" name= "longitude" value="${record.getLongitude()}" readonly=""/></td>
                <td><input type="text" name= "description" value="${record.getDescription()}" readonly=""/></td>
                <td><input type="text" name= "numberOfBeds" value="${record.getNumberOfBeds()}" readonly=""/></td>
                <td><input type="text" name= "numberOfBaths" value="${record.getNumberOfBaths()}" readonly=""/></td>
                <td><input type="text" name= "sizeInSqft" value="${record.getSizeInSqft()}" readonly=""/></td>
                <td><input type="text" name= "lotSize" value="${record.getLotSize()}" readonly=""/></td>
                <td><input type="text" name= "type" value="${record.getType()}" readonly=""/></td>
                <td><input type="text" name= "yearOfBuilt" value="${record.getYearOfBuilt()}" readonly=""/></td>
                <td><input type="text" name= "heatingType" value="${record.getHeatingType()}" readonly=""/></td>
                <td><input type="text" name= "propertyTax" value="${record.getPropertyTax()}" readonly=""/></td>
                <td><input type="text" name= "comments" value="${record.getComments()}" readonly=""/></td>
                <c:if test="${record.getClass().simpleName =='SalesListing'}">
                    <td><input type="text" name= "price" value="${record.getListPrice()}" readonly=""/></td>
                </c:if>
                <td><input type="button" value="Remove" onclick="removeRow(this, ${record.getListingID()})"/></td>
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

<script>
    var xmlHttp;
    xmlHttp = GetXmlHttpObject();
    function removeRow(buttonNode, listingID){
        var result = confirm("Are you sure you want to delete this listing?");
        if(result == true){
            if (xmlHttp == null)
            {
                alert("Your browser does not support AJAX!");
                return;
            }
            var query = "listingID=" + listingID;
            xmlHttp.onreadystatechange = function stateChanged()
            {
                if (xmlHttp.readyState == 4)
                {
                    trNode = buttonNode.parentNode.parentNode;
                    trNode.parentNode.removeChild(trNode);
                }
            };
            xmlHttp.open("POST", "/showmylisting.do", true);
            xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xmlHttp.send(query);

        }
        return false;
    }

    function GetXmlHttpObject()
    {
        var xmlHttp = null;
        try
        {
            // Firefox, Opera 8.0+, Safari
            xmlHttp = new XMLHttpRequest();
        } catch (e)
        {
            // Internet Explorer
            try
            {
                xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
            } catch (e)
            {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
        }
        return xmlHttp;
    }
</script>

</body>
</html>
