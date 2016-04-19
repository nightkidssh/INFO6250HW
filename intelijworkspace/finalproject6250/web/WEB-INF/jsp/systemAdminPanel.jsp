<%--
  Created by IntelliJ IDEA.
  User: kym-1992
  Date: 4/18/16
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>System Admin Panel</title>
    <link rel="stylesheet" href="/css/showResultCSS.css">
</head>
<body>
<div id="logoutContainer" class="global" style="background-color: white; opacity: 0.9">
<c:set var="accountTypee">${sessionScope.loggedInAccount.accountType}</c:set>
<c:choose>
    <c:when test="${sessionScope.loggedInAccount != null && accountTypee == 'SystemAdmin'}">
        <form method = "post" action="/logout.do" style="display: inline-block;">
            <label>Welcome ${sessionScope.loggedInAccount.accountType} ${sessionScope.loggedInAccount.userName}</label>
            <input type="submit" name="Logout" value="Logout"/>
        </form>
        <button onclick="location.href='realIndex.do'">Return to HomePage</button>
    </c:when>
    <c:otherwise>
        <jsp:forward page="/realIndex.do">
            <jsp:param name="loginError" value="Please Login First"/>
        </jsp:forward>
    </c:otherwise>
</c:choose>
</div>

<h1>List of your accounts:</h1>
<form action="sysadminpanel.do" method="post">
    <table border="1">
        <tr>
            <td>accountID</td>
            <td>userName</td>
            <td>dateCreated</td>
            <td>accountType</td>
            <td>firstName</td>
            <td>lastName</td>
            <td>sex</td>
            <td>phoneNumber</td>
            <td>emailAddress</td>
            <td>mailingAddress</td>
            <td>zipCode</td>
            <td>Delete</td>
        </tr>

        <c:forEach var="record" items="${requestScope.resultSet}">
            <tr>
                <td><input type="text" name= "accountID" value="${record.getAccountID()}" readonly=""/></td>
                <td><input type="text" name= "userName" value="${record.getUserName()}" readonly=""/></td>
                <td><input type="text" name= "dateCreated" value="${record.getDateCreated()}" readonly=""/></td>
                <td><input type="text" name= "accountType" value="${record.getAccountType()}" readonly=""/></td>
                <td><input type="text" name= "firstName" value="${record.getFirstName()}" readonly=""/></td>
                <td><input type="text" name= "lastName" value="${record.getLastName()}" readonly=""/></td>
                <td><input type="text" name= "sex" value="${record.getSex()}" readonly=""/></td>
                <td><input type="text" name= "phoneNumber" value="${record.getPhoneNumber()}" readonly=""/></td>
                <td><input type="text" name= "emailAddress" value="${record.getEmailAddress()}" readonly=""/></td>
                <td><input type="text" name= "mailingAddress" value="${record.getMailingAddress()}" readonly=""/></td>
                <td><input type="text" name= "zipCode" value="${record.getZipCode()}" readonly=""/></td>
                <td><input type="button" value="Remove" onclick="removeRow(this, ${record.getAccountID()})"/></td>
            </tr>
        </c:forEach>
    </table>

    <script>
        var xmlHttp;
        xmlHttp = GetXmlHttpObject();
        function removeRow(buttonNode, accountID){
            var result = confirm("Are you sure you want to delete this account?");
            if(result == true){
                if (xmlHttp == null)
                {
                    alert("Your browser does not support AJAX!");
                    return;
                }
                var query = "accountID=" + accountID;
                xmlHttp.onreadystatechange = function stateChanged()
                {
                    if (xmlHttp.readyState == 4)
                    {
                        trNode = buttonNode.parentNode.parentNode;
                        trNode.parentNode.removeChild(trNode);
                    }
                };
                xmlHttp.open("POST", "/sysadminpanel.do", true);
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
