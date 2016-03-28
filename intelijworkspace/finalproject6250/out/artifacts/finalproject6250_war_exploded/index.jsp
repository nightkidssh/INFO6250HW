<%--
  Created by IntelliJ IDEA.
  User: kym-1992
  Date: 3/23/16
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
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
    </script>
  </head>
  <body onload="loadMap()">
    <div id="map_container"></div>
  </body>
</html>
