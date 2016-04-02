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
</head>
<body background="ImageResources/registerbgimg.jpg">
<div id="globalContainer" class="global" style="background-color: white; opacity: 0.9">
    <form:form action="registerAPI.do" method="post" commandName="user">
    <h1>Register on Easy Housing system</h1>
    <div id="loginInfoSection" class="default" style="background-color: white">
    <h3>Login Information</h3>&nbsp&nbsp
    <label>Account Type:</label>&nbsp&nbsp
    <form:select path="accountType">
        <option value="SystemAdmin">System Admin Account</option><option value="Landlord">Landlord Account</option>
        <option value="HomeBuyer">Home Buyer Account</option><option value="Lessor">Leassor Account</option>
        <option value="Lessee">Lessee Account</option><option value="SpecialAdmin">Special Admin Account</option>
    </form:select><br/><br/>&nbsp&nbsp
    <form:errors path="userName"/><br/>&nbsp&nbsp

    <form:input path="userName" id="userName" placeholder="User Name"/><br/>&nbsp&nbsp
    <form:errors path="userName"/><br/>&nbsp&nbsp

    <form:input path="password" id="password" type="password" placeholder="password"/><br/>&nbsp&nbsp
    <form:errors path="password"/><br/>&nbsp&nbsp

    <form:input path="confirmPassword" id="confirmPassword" type="password" placeholder="Confirm Password"/><br/>&nbsp&nbsp
    <form:errors path="confirmPassword"/><br/>&nbsp&nbsp
    </div>

    <div id="personalInfoSection" class="default" style="background-color: white">
        <h3>Personal Information</h3>&nbsp&nbsp
        <form:input path="firstName" placeholder="First Name"/><br/>&nbsp&nbsp
        <form:errors path="firstName"/><br/>&nbsp&nbsp
        <form:input path="lastName" placeholder="Last Name"/><br/>&nbsp&nbsp
        <form:errors path="lastName"/><br/>&nbsp&nbsp
        <form:select path="sex">
            <option value="M">Male</option>
            <option value="F">Female</option>
        </form:select><br/><br/>
        <form:errors path="sex"/><br/>&nbsp&nbsp

        <form:input path="phoneNumber" placeholder="Phone Number"/><br/>&nbsp&nbsp
        <form:errors path="phoneNumber"/><br/>&nbsp&nbsp
        <form:input path="emailAddress" placeholder="Email Address"/><br/>&nbsp&nbsp
        <form:errors path="emailAddress"/><br/>&nbsp&nbsp
        <form:input path="mailingAddress" placeholder="Mailing Address"/><br/>&nbsp&nbsp
        <form:errors path="mailingAddress"/><br/>&nbsp&nbsp
        <form:input path="zipCode" placeholder="Zip Code"/><br/>&nbsp&nbsp
        <form:errors path="zipCode"/><br/>&nbsp&nbsp
    </div>

    <div id="submitSection" class="default" style="background-color: white">
    <input type="submit" name="submit" value="Submit"/>
    </div>
    </form:form>

</div>
</body>
</html>
