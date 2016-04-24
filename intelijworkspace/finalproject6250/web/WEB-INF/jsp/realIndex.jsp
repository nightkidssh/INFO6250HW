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

    </style>
    <script async defer src="https://maps.googleapis.com/maps/api/js?sensor=false"
            type="text/javascript"></script>

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
        }
    </script>
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>

    <script>
        // This is called with the results from from FB.getLoginStatus().
        function statusChangeCallback(response) {
            console.log('statusChangeCallback');
            console.log(response);
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

            // Now that we've initialized the JavaScript SDK, we call
            // FB.getLoginStatus().  This function gets the state of the
            // person visiting this page and can return one of three states to
            // the callback you provide.  They can be:
            //
            // 1. Logged into your app ('connected')
            // 2. Logged into Facebook, but not your app ('not_authorized')
            // 3. Not logged into Facebook and can't tell if they are logged into
            //    your app or not.
            //
            // These three cases are handled in the callback function.

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
    </script>
</head>
<body onload="loadMap()">
<%--<h1>Title : ${title}</h1>--%>
<%--<h1>Message : ${message}</h1>--%>

<%--<sec:authorize access="hasRole('SystemAdmin')">--%>
    <%--<!-- For login user -->--%>
    <%--<c:url value="/j_spring_security_logout" var="logoutUrl" />--%>
    <%--<form action="${logoutUrl}" method="post" id="logoutForm">--%>
        <%--<input type="hidden" name="${_csrf.parameterName}"--%>
               <%--value="${_csrf.token}" />--%>
    <%--</form>--%>
    <%--<script>--%>
        <%--function formSubmit() {--%>
            <%--document.getElementById("logoutForm").submit();--%>
        <%--}--%>
    <%--</script>--%>

    <%--<c:if test="${pageContext.request.userPrincipal.name != null}">--%>
        <%--<h2>--%>
            <%--User : ${pageContext.request.userPrincipal.name} | <a--%>
                <%--href="javascript:formSubmit()"> Logout</a>--%>
        <%--</h2>--%>
    <%--</c:if>--%>


<%--</sec:authorize>--%>
<div id="logoutContainer" class="global" style="background-color: white; opacity: 0.9">
    <fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
    </fb:login-button>

    <div id="status">
    </div>

    <c:set var="accountTypee">${sessionScope.loggedInAccount.accountType}</c:set>
    <c:choose>
        <c:when test="${sessionScope.loggedInAccount.userName != null}">
            <form method = "post" action="/logout.do" style="display: inline-block;">
                <label>Welcome ${sessionScope.loggedInAccount.accountType} ${sessionScope.loggedInAccount.userName}</label>
                <input type="submit" name="Logout" value="Logout"/>
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
            <button onclick="location.href='registerAPI.do'" style="float:right">Register</button>
            <form method="post" action="/login.do" style="display: inline-block;">
            <%--<form method="post" action="${loginURL}" style="display: inline-block;">--%>
                <label>User Name:</label>&nbsp&nbsp<input type="text" name="userName" required/>&nbsp&nbsp
                <label>Password:</label>&nbsp&nbsp<input type="password" name="password" required/>&nbsp&nbsp
                <input type="submit" name="loginButton" value="login" />
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
<div id="map_container"></div>
</body>
</html5>
