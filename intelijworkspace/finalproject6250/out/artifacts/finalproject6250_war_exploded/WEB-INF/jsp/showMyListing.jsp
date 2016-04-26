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
<html5>
<head>
    <title>My Listing</title>
    <script src="https://code.jquery.com/jquery-2.2.3.js" integrity="sha256-laXWtGydpwqJ8JA+X9x2miwmaiKhn8tVmOVEigRNtP4=" crossorigin="anonymous"></script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    <style type="text/css">
        div#map_container{
            width:60%;
            height:60%;
            margin: 0 auto;
        }

        .controls {
            margin-top: 10px;
            border: 1px solid transparent;
            border-radius: 2px 0 0 2px;
            box-sizing: border-box;
            -moz-box-sizing: border-box;
            height: 32px;
            outline: none;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.3);
        }

        #pac-input {
            background-color: #fff;
            font-family: Roboto;
            font-size: 15px;
            font-weight: 300;
            margin-left: 12px;
            padding: 0 11px 0 13px;
            text-overflow: ellipsis;
            width: 300px;
        }

        #pac-input:focus {
            border-color: #4d90fe;
        }

    </style>
    <link rel="stylesheet" href="/css/showResultCSS.css">
    <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?libraries=places&sensor=false"></script>
    <script type="text/javascript">
        function loadMap() {
            //Put data in array
            var dataArray = [
                <c:forEach var="record" items="${requestScope.resultSet}" varStatus="loop">
                [ '<c:out value="${record.getAddress()}"/>', <c:out value="${record.getLatitude()}"/>, <c:out value="${record.getLongitude()}"/>, <c:out value="${loop.index}"/> ],
                </c:forEach>

            ];
            if(dataArray.length > 0) {
                var myOptions = {
                    zoom: 15,
                    center: new google.maps.LatLng(dataArray[0][1], dataArray[0][2]),
                    mapTypeId: google.maps.MapTypeId.ROADMAP
                };
            }
            else{
                var myOptions = {
                    zoom: 10,
                    center: new google.maps.LatLng(42.3383292,-71.0886148),
                    mapTypeId: google.maps.MapTypeId.ROADMAP
                };
            }
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
                            $('table tr').css('background-color','white');
                            document.getElementById("listTable").rows[dataArray[i][3]+1].style.backgroundColor = 'green';
                            document.getElementById("listTable").rows[dataArray[i][3]+1].focus();
                            infowindow.setContent(dataArray[i][0]);
                            infowindow.open(map, marker);
                        }
                    })(marker, i));
                }
            }


            var input = /** @type {!HTMLInputElement} */(
                    document.getElementById('pac-input'));

            map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

            var autocomplete = new google.maps.places.Autocomplete(input);
            autocomplete.bindTo('bounds', map);


            autocomplete.addListener('place_changed', function() {
                var place = autocomplete.getPlace();
                if (!place.geometry) {
                    window.alert("Autocomplete's returned place contains no geometry");
                    return;
                }

                // If the place has a geometry, then present it on a map.
                if (place.geometry.viewport) {
                    map.fitBounds(place.geometry.viewport);
                } else {
                    map.setCenter(place.geometry.location);
                    map.setZoom(17);  // Why 17? Because it looks good.
                }
            });

        }
    </script>

</head>
<body onload="loadMap()">
<div class="container-fluid">
<div id="logoutContainer" class="global" style="background-color: white; opacity: 0.9">
    <c:set var="accountTypee">${sessionScope.loggedInAccount.accountType}</c:set>
    <c:choose>
        <c:when test="${sessionScope.loggedInAccount.userName != null && accountTypee == 'Landlord'}">
            <form method = "post" action="/logout.do" style="display: inline-block;">
                <label>Welcome ${sessionScope.loggedInAccount.accountType} ${sessionScope.loggedInAccount.userName}</label>
                <input type="submit" name="Logout" value="Logout"/>
            </form>
            <button onclick="location.href='salesListing.do'">Add New SalesListing</button>
            <button onclick="location.href='realIndex.do'">Return to HomePage</button>
        </c:when>
        <c:otherwise>
            <jsp:forward page="/realIndex.do">
                <jsp:param name="loginError" value="Please Login First"/>
            </jsp:forward>
        </c:otherwise>
    </c:choose>
</div>

<h1>List of your listing:</h1>
<form action="showmylisting.do" method="post">
    <table border="1" class="table" id="listTable">
        <tr>
            <td>listingID</td>
            <td>listingType</td>
            <td>accountID</td>
            <td>address</td>
            <td>zipCode</td>
            <td>description</td>
            <td>price</td>
            <td>Show Detail</td>
            <td>Delete</td>
            <td>Update</td>
        </tr>

        <c:forEach var="record" items="${requestScope.resultSet}">
            <tr>
                <td><input type="text" name= "listingID" value="${record.getListingID()}" readonly=""/></td>
                <td><input type="text" name= "listingType" value="${record.getListingType()}" readonly=""/></td>
                <td><input type="text" name= "accountID" value="${record.getCombinedAccount().getAccountID()}" readonly=""/></td>
                <td><input type="text" name= "address" value="${record.getAddress()}" readonly=""/></td>
                <td><input type="text" name= "zipCode" value="${record.getZipCode()}" readonly=""/></td>
                <td><input type="text" name= "description" value="${record.getDescription()}" readonly=""/></td>
                <c:if test="${record.getClass().simpleName =='SalesListing'}">
                    <td><input type="text" name= "price" value="${record.getListPrice()}" readonly=""/></td>
                </c:if>
                <td><button name= "emailbutton" onclick="openEmailWindow(${record.getListingID()}); return false;">Show Detail</button></td>
                <td><input type="button" value="Remove" onclick="removeRow(this, ${record.getListingID()})"/></td>
                <td><button onclick="location.href='updateListing.do?listingID=${record.getListingID()}'; return false;">Updata Record</button></td>
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
<input id="pac-input" class="controls" type="text" placeholder="Enter a location">
<div id="map_container"></div>
</div>
<script>
    function openEmailWindow(listingID) {
        window.open("sendEmail.do?listingID=" + listingID, "emailWindow", "width=1024,height=768");
    }
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
</html5>
