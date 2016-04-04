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
<html>
<head>
    <title>Welcome to Easy Housing system!</title>
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
            var latlng = new google.maps.LatLng(42.3383292,-71.0886148);
            var myOptions = {
                zoom: 15,
                center: latlng,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            var map = new google.maps.Map(document.getElementById("map_container"),myOptions);

            var marker = new google.maps.Marker({
                position: latlng,
                map: map,
                title:"Northeastern University"
            });

        }

    </script>
</head>
<body onload="loadMap()">
<h1>Title : ${title}</h1>
<h1>Message : ${message}</h1>

<sec:authorize access="hasRole('SystemAdmin')">
    <!-- For login user -->
    <c:url value="/j_spring_security_logout" var="logoutUrl" />
    <form action="${logoutUrl}" method="post" id="logoutForm">
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />
    </form>
    <script>
        function formSubmit() {
            document.getElementById("logoutForm").submit();
        }
    </script>

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>
            User : ${pageContext.request.userPrincipal.name} | <a
                href="javascript:formSubmit()"> Logout</a>
        </h2>
    </c:if>


</sec:authorize>

<div align="center">
    <c:url value="/j_spring_security_check" var="loginURL"/>
    <form method="post" action="${loginURL}" style="display: inline-block;">
        <label>User Name:</label>&nbsp&nbsp<input type="text" name="userName" required/>&nbsp&nbsp
        <label>Password:</label>&nbsp&nbsp<input type="password" name="password" required/>&nbsp&nbsp
        <input type="submit" name="loginButton" value="login" />
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />
    </form>
    <button onclick="location.href='registerAPI.do'">Register</button>
    <%--<form method="post" action="registerAPI.do" style="display: inline-block;">--%>
        <%--<input type="submit" name="registerButton" value="register"/>--%>
        <%--<input type="hidden" name="registerStatus" value="init">--%>
    <%--</form>--%>
</div>
<div id="map_container"></div>
</body>
</html>
