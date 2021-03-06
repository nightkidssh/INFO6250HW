<%--
  Created by IntelliJ IDEA.
  User: kym-1992
  Date: 3/23/16
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html5>
<head>
    <title>Welcome to Easy Housing system!</title>
    <style type="text/css">
        div#map_container{
            width:60%;
            height:60%;
            margin: 0 auto;
        }

        div.global{
            border-width: medium;
            border-style: double;
            border-color: black;
            text-align:center;
            margin-left:auto;
            margin-right:auto;
            width: 50%;
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
    <%--<script async defer src="https://maps.googleapis.com/maps/api/js?sensor=false"--%>
            <%--type="text/javascript"></script>--%>
    <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?libraries=places&sensor=false"></script>

    <script type="text/javascript">
        function loadMap() {
            var latlng = new google.maps.LatLng(42.3383292,-71.0886148);
            var myOptions = {
                zoom: 10,
                center: latlng,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            var map = new google.maps.Map(document.getElementById("map_container"),myOptions);
            var infowindow = new google.maps.InfoWindow();



            var dataArray = [
                <c:forEach var="record" items="${requestScope.resultSet}">
                [ '<c:out value="${record.getAddress()}"/>', <c:out value="${record.getLatitude()}"/>, <c:out value="${record.getLongitude()}"/> ],
                </c:forEach>

            ];

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
            else{
                var marker = new google.maps.Marker({
                    position: latlng,
                    map: map,
                    title:"Northeastern University"
                });
                google.maps.event.addListener(marker, 'click', (function (marker) {
                    return function () {
                        infowindow.setContent("Northeastern University");
                        infowindow.open(map, marker);
                    }
                })(marker));
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
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>

    <script>
        // This is called with the results from from FB.getLoginStatus().
        function statusChangeCallback(response) {
//            console.log('statusChangeCallback');
//            console.log(response);
            // The response object is returned with a status field that lets the
            // app know the current login status of the person.
            // Full docs on the response object can be found in the documentation
            // for FB.getLoginStatus().
            if (response.status === 'connected') {
                // Logged into your app and Facebook.
                testAPI();
            } else if (response.status === 'not_authorized') {
                // The person is logged into Facebook, but not your app.
                document.getElementById('status').innerHTML = 'Please log ' +
                        'into this app.';
            } else {
                // The person is not logged into Facebook, so we're not sure if
                // they are logged into this app or not.
                document.getElementById('status').innerHTML = 'Please log ' +
                        'into Facebook.';
            }
        }

        // This function is called when someone finishes with the Login
        // Button.  See the onlogin handler attached to it in the sample
        // code below.
        function checkLoginState() {
            FB.getLoginStatus(function(response) {
                statusChangeCallback(response);
                sendToServer(response);
            });
        }

        window.fbAsyncInit = function() {
            FB.init({
                appId      : '1702383136679634',
                cookie     : true,  // enable cookies to allow the server to access
                                    // the session
                xfbml      : true,  // parse social plugins on this page
                version    : 'v2.6' // use graph api version 2.5
            });

            FB.getLoginStatus(function(response) {
                statusChangeCallback(response);
            });

        };

        // Load the SDK asynchronously
        (function(d, s, id) {
            var js, fjs = d.getElementsByTagName(s)[0];
            if (d.getElementById(id)) return;
            js = d.createElement(s); js.id = id;
            js.src = "//connect.facebook.net/en_US/sdk.js";
            fjs.parentNode.insertBefore(js, fjs);
        }(document, 'script', 'facebook-jssdk'));

        // Here we run a very simple test of the Graph API after login is
        // successful.  See statusChangeCallback() for when this call is made.
        function testAPI() {
            console.log('Welcome!  Fetching your information.... ');
            FB.api('/me', function(response) {
                console.log('Successful login for: ' + response.name);
                document.getElementById('status').innerHTML =
                        'Thanks for logging in, ' + response.name + '!';
            });
        }

        function sendToServer(response) {
            var access_token = response.authResponse.accessToken;
            var form = document.createElement("form");
            form.setAttribute("method", "post");
            form.setAttribute("action", "/facebook.do");
            var hiddenField = document.createElement("input");
            hiddenField.setAttribute("type", "hidden");
            hiddenField.setAttribute("name", "token");
            hiddenField.setAttribute("value", access_token);
            form.appendChild(hiddenField);

            document.body.appendChild(form);
            form.submit();
        }
        
        function logout() {
            FB.logout(function(response) {
                // user is now logged out
            });
        }



    </script>
</head>
<body onload="loadMap()">
<div id="logoutContainer" class="global" style="background-color: white; opacity: 0.9">

    <c:set var="accountTypee">${sessionScope.loggedInAccount.accountType}</c:set>
    <c:choose>
        <c:when test="${sessionScope.loggedInAccount.userName != null}">
            <form method = "post" action="/logout.do" style="display: inline-block;">
                <label>Welcome ${sessionScope.loggedInAccount.accountType} ${sessionScope.loggedInAccount.userName}</label>
                <input onclick="logout();" type="submit" name="Logout" value="Logout"/>
            </form>
            <button onclick="location.href='changePassword.do'">Change my password</button>
            <c:choose>
                <c:when test="${accountTypee == 'SystemAdmin'}">
                    <button onclick="location.href='sysadminpanel.do'">Show Admin Control Panel</button>
                </c:when>
                <c:when test="${accountTypee == 'Landlord'}">
                    <button onclick="location.href='showmylisting.do'">Show my Listing</button>
                </c:when>
                <c:when test="${accountTypee == 'HomeBuyer'}">
                    <button onclick="location.href='buyerlisting.do'">Show all Listing</button>
                </c:when>
                <c:otherwise>
                </c:otherwise>
            </c:choose>
        </c:when>
        <c:otherwise>
            <%--<c:url value="/j_spring_security_check" var="loginURL"/>--%>
            <label>Please note: Facebook user can ONLY open buyer account!</label>
            <button onclick="location.href='registerAPI.do'" style="float:right">Register</button>
            <form method="post" action="/login.do" style="display: inline-block;">
            <%--<form method="post" action="${loginURL}" style="display: inline-block;">--%>
                <label>User Name:</label>&nbsp&nbsp<input type="text" name="userName" required/>&nbsp&nbsp
                <label>Password:</label>&nbsp&nbsp<input type="password" name="password" required/>&nbsp&nbsp
                <input type="submit" name="loginButton" value="login" />
                <fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
                </fb:login-button>
                    <%--<input type="hidden" name="${_csrf.parameterName}"--%>
                    <%--value="${_csrf.token}" />--%>
                <div class="g-recaptcha" data-sitekey="6LeqjBwTAAAAAGXXIHRlQipbogvJCSJvo5FnoKDB"></div>&nbsp&nbsp
            </form>
            <label style="color: red">${requestScope.Error}</label>
            <label style="color: red">${requestScope.loginError}</label>
            <label>${sessionScope.loggedInAccount.userName}</label>
        </c:otherwise>
    </c:choose>

</div>
<input id="pac-input" class="controls" type="text" placeholder="Enter a location">
<div id="map_container"></div>
</body>
</html5>
