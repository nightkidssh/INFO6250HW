<%--
  Created by IntelliJ IDEA.
  User: kym-1992
  Date: 3/29/16
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Register for Easy Hosing system!</title>
    <link rel="stylesheet" href="/css/registerCSS.css">
    <%--<script src="https://www.google.com/recaptcha/api.js" async defer></script>--%>
</head>
<body background="ImageResources/registerbgimg.jpg">
<div id="globalContainer" class="global" style="background-color: white; opacity: 0.9">
    <form:form action="registerAPI.do" method="post" commandName="user">
    <h1>Register on Easy Housing system</h1>
    <div id="loginInfoSection" class="default" style="background-color: white">
    <h3>Login Information</h3>&nbsp&nbsp
    <label>Account Type:</label>&nbsp&nbsp
    <form:select path="accountType">
        <option value="Landlord">Landlord Account</option>
        <option value="HomeBuyer">Home Buyer Account</option>
        <option value="Lessee">Lessee Account</option>
    </form:select><br/><br/>&nbsp&nbsp
    <form:errors path="accountType"/><br/>&nbsp&nbsp

    <form:input path="userName" id="userName" placeholder="User Name"/><br/>&nbsp&nbsp
    <form:errors path="userName" cssStyle="color: red"/><br/>&nbsp&nbsp

    <form:input path="password" id="password" type="password" placeholder="password"/><br/>&nbsp&nbsp
    <form:errors path="password" cssStyle="color: red"/><br/>&nbsp&nbsp
    <label>Password Requirement: #must contains one digit from 0-9 <br/>#must contains one lowercase characters <br/>#must contains one uppercase characters
        <br/>#must contains one special symbols "@#$%" <br/>#length at least 6 characters and maximum of 20<br/></label>

    <form:input path="confirmPassword" id="confirmPassword" type="password" placeholder="Confirm Password"/><br/>&nbsp&nbsp
    <form:errors path="confirmPassword" cssStyle="color: red"/><br/>&nbsp&nbsp
    </div>

    <div id="personalInfoSection" class="default" style="background-color: white">
        <h3>Personal Information</h3>&nbsp&nbsp
        <form:input path="firstName" placeholder="First Name"/><br/>&nbsp&nbsp
        <form:errors path="firstName" cssStyle="color: red"/><br/>&nbsp&nbsp
        <form:input path="lastName" placeholder="Last Name"/><br/>&nbsp&nbsp
        <form:errors path="lastName" cssStyle="color: red"/><br/>&nbsp&nbsp
        <form:select path="sex">
            <option value="M">Male</option>
            <option value="F">Female</option>
        </form:select><br/><br/>
        <form:errors path="sex" cssStyle="color: red"/><br/>&nbsp&nbsp

        <form:input path="phoneNumber" placeholder="Phone Number"/><br/>&nbsp&nbsp
        <form:errors path="phoneNumber" cssStyle="color: red"/><br/>&nbsp&nbsp
        <form:input path="emailAddress" placeholder="Email Address"/><br/>&nbsp&nbsp
        <form:errors path="emailAddress" cssStyle="color: red"/><br/>&nbsp&nbsp
        <form:input path="mailingAddress" placeholder="Mailing Address"/><br/>&nbsp&nbsp
        <form:errors path="mailingAddress" cssStyle="color: red"/><br/>&nbsp&nbsp
        <form:input path="zipCode" placeholder="Zip Code"/><br/>&nbsp&nbsp
        <form:errors path="zipCode" cssStyle="color: red"/><br/>&nbsp&nbsp
    </div>

    <%--<div id="reCAPTCHA" class="g-recaptcha" data-sitekey="6LeqjBwTAAAAAGXXIHRlQipbogvJCSJvo5FnoKDB" style="background-color: white">--%>
        <%--<h3 style="color: red">${requestScope.reCAPTCHAError}</h3>--%>
    <%--</div>--%>

    <div id="submitSection" class="default" style="background-color: white">
        <input type="submit" name="submit" value="Submit"/>
    </div>
    </form:form>
    <button onclick="location.href='realIndex.do'">Back to Home Page</button>
</div>

<script>

    var placeSearch, autocomplete;
//    var componentForm = {
//        zipCode: 'short_name'
//    };

    function initAutocomplete() {
        // Create the autocomplete object, restricting the search to geographical
        // location types.
        autocomplete = new google.maps.places.Autocomplete(
                /** @type {!HTMLInputElement} */(document.getElementById('mailingAddress')),
                {types: ['geocode']});

        // When the user selects an address from the dropdown, populate the address
        // fields in the form.
        autocomplete.addListener('place_changed', fillInAddress);
    }

//    function fillInAddress() {
//        // Get the place details from the autocomplete object.
//        var place = autocomplete.getPlace();
//
//        for (var component in componentForm) {
//            document.getElementById(component).value = '';
//            document.getElementById(component).disabled = false;
//        }
//
//        // Get each component of the address from the place details
//        // and fill the corresponding field on the form.
//        for (var i = 0; i < place.address_components.length; i++) {
//            var addressType = place.address_components[i].types[0];
//            if (componentForm[addressType]) {
//                var val = place.address_components[i][componentForm[addressType]];
//                document.getElementById(addressType).value = val;
//            }
//        }
//    }

</script>
<script src="https://maps.googleapis.com/maps/api/js?libraries=places&callback=initAutocomplete"
        async defer></script>
</body>
</html>
