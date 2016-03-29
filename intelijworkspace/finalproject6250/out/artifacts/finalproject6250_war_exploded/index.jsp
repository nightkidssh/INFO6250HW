<%--
  Created by IntelliJ IDEA.
  User: kym-1992
  Date: 3/23/16
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
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
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBTcV-hPaIpO4DkqyQLdAr7coINAWoyyWo&sensor=false"
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

      function showRegister(){
        window.open("register.do");
        return false;
      }
    </script>
  </head>
  <body onload="loadMap()">
    <div align="center">
      <form method="post" action="">
        <label>User Name:</label>&nbsp&nbsp<input type="text" name="userName" required/>&nbsp&nbsp
        <label>Password:</label>&nbsp&nbsp<input type="password" name="password" required/>&nbsp&nbsp
        <label>Account Type:</label>&nbsp&nbsp<select><option value="SystemAdmin">System Admin Account</option>
        <option value="SystemAdmin">System Admin Account</option><option value="Landlord">Landlord Account</option>
        <option value="HomeBuyer">Home Buyer Account</option><option value="Lessor">Leassor Account</option>
        <option value="Lessee">Lessee Account</option><option value="SpecialAdmin">Special Admin Account</option></select>
        <input type="submit" name="loginButton" value="login" />
        <input type="button" name="registerButton" value="register" onclick="showRegister()"/>
      </form>
    </div>
    <div id="map_container"></div>
  </body>
</html>
