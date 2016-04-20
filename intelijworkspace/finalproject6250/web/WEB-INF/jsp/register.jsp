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
<html5>
<head>
    <title>Register for Easy Hosing system!</title>
    <link rel="stylesheet" href="/css/registerCSS.css">
</head>
<body>
    <div id="globalContainer" class="default">
        <%--<form:form method="post" modelAttribute="accountForm" action="register.do">--%>
            <%--<h1>Register on Easy Housing system</h1>--%>
            <%--<div id="loginInfoSection" class="default">--%>
                <%--<h3>Login Information</h3>--%>
                <%--<spring:bind path="userName">--%>
                    <%--<form:input path="userName" id="userName" placeholder="User Name"/>--%>
                    <%--<form:errors path="userName"/>--%>
                <%--</spring:bind>--%>

                <%--<spring:bind path="password">--%>
                    <%--<form:input path="password" id="password" type="password" placeholder="password"/>--%>
                    <%--<form:errors path="password"/>--%>
                <%--</spring:bind>--%>

                <%--&lt;%&ndash;<spring:bind path="confirmPassword">&ndash;%&gt;--%>
                    <%--<form:input path="confirmPassword" id="confirmPassword" type="password" placeholder="Confirm Password"/>--%>
                    <%--<form:errors path="confirmPassword"/>--%>
                <%--&lt;%&ndash;</spring:bind>&ndash;%&gt;--%>
            <%--</div>--%>
        <%--</form:form>--%>

        <form method="post" action="register.do">
            <input type="hidden" name="registerStatus" value="doRegister"/>
            <h1>Register on Easy Housing system</h1>
            <div id="loginInfoSection" class="default">
                <h3>Login Information</h3>
                <label>Account Type:</label>&nbsp&nbsp
                <select name="accountType" id="accountType" required>
                    <option value="SystemAdmin">System Admin Account</option><option value="Landlord">Landlord Account</option>
                    <option value="HomeBuyer">Home Buyer Account</option><option value="Lessor">Leassor Account</option>
                    <option value="Lessee">Lessee Account</option><option value="SpecialAdmin">Special Admin Account</option>
                </select><br/><br/>
                <input name="userName" id="userName" placeholder="User Name" required/><br/>
                <label id="userNameErrorLabel"></label><br/>
                <input name="password" id="password" type="password" placeholder="password" required/><br/>
                <label id="passwordErrorLabel"></label><br/>
                <input name="confirmPassword" id="confirmPassword" type="password" placeholder="Confirm Password" required/><br/>
                <label id="confirmPasswordErrorLabel"></label><br/>
            </div>

            <div id="personalInfoSection" class="default">
                <h3>Personal Information</h3>
                <input name="firstName" id="firstName" placeholder="First Name" required/><br/>
                <label id="firstNameErrorLabel"></label><br/>
                <input name="lastName" id="lastName" placeholder="Last Name" required/><br/>
                <label id="lastNameErrorLabel"></label><br/>
                <select name="sex" id="sex">
                    <option value="M">Male</option>
                    <option value="F">Female</option>
                </select><br/><br/>

                <input name="phoneNumber" id="phoneNumber" placeholder="Phone Number" required/><br/>
                <label id="phoneNumberErrorLabel"></label><br/>
                <input name="emailAddress" id="emailAddress" placeholder="Email Address" required/><br/>
                <label id="emailAddressErrorLabel"></label><br/>
                <input name="mailingAddress" id="mailingAddress" placeholder="Mailing Address" required/><br/>
                <label id="mailingAddressErrorLabel"></label><br/>
                <input name="zipCode" id="zipCode" placeholder="Zip Code" required/><br/>
                <label id="zipCodeErrorLabel"></label><br/>
            </div>

            <div id="submitSection" class="default">
                <input type="submit" name="submit" value="Submit"/>
            </div>
        </form>
    </div>
</body>
</html5>
