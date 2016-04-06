<%--
  Created by IntelliJ IDEA.
  User: kym-1992
  Date: 4/5/16
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List my own house</title>
    <link rel="stylesheet" href="/css/registerCSS.css">
</head>
<body>
<div id="logoutContainer" class="global" style="background-color: white; opacity: 0.9">
<c:choose>
    <c:when test="${sessionScope.loggedInAccount.userName != null}">
        <form method = "post" action="/logout.do" style="display: inline-block;">
            <label>Welcome ${sessionScope.loggedInAccount.accountType} ${sessionScope.loggedInAccount.userName}</label>
            <input type="submit" name="Logout" value="Logout"/>
        </form>
    </c:when>
    <c:otherwise>
        <c:redirect url="/realIndex.do"/>
    </c:otherwise>
</c:choose>
</div>


<div id="globalContainer" class="global" style="background-color: white; opacity: 0.9">
    <form:form action="salesListing.do" method="post" commandName="salesListing">
        <h1>List my own house</h1>
        <div id="listingDetailSection" class="default" style="background-color: white">
            <h3>Listing Detail</h3>&nbsp&nbsp
            <label>Listing type:</label><br/>&nbsp&nbsp
            <form:select path="listingType">
                <option value="forSales">Sales Listing</option>
                <option value="forLease">Lease Listing</option>
            </form:select><br/>&nbsp&nbsp
            <form:errors path="listingType"/><br/>&nbsp&nbsp

            <form:input path="address" id="address" placeholder="Property Address"/><br/>&nbsp&nbsp
            <form:errors path="address"/><br/>&nbsp&nbsp

            <form:textarea path="description" id="description" placeholder="Description" rows="5" cols="50"/><br/>&nbsp&nbsp
            <form:errors path="description"/><br/>&nbsp&nbsp

            <label>Number of Beds</label>
            <form:input path="numberOfBeds" id="numberOfBeds" placeholder="numberOfBeds"/><br/>&nbsp&nbsp
            <form:errors path="numberOfBeds"/><br/>&nbsp&nbsp

            <label>Number Of Baths</label>
            <form:input path="numberOfBaths" id="numberOfBaths" placeholder="numberOfBaths"/><br/>&nbsp&nbsp
            <form:errors path="numberOfBaths"/><br/>&nbsp&nbsp

            <label>Size In Sqft</label>
            <form:input path="sizeInSqft" id="sizeInSqft" placeholder="sizeInSqft"/><br/>&nbsp&nbsp
            <form:errors path="sizeInSqft"/><br/>&nbsp&nbsp

            <label>Lot Size</label>
            <form:input path="lotSize" id="lotSize" placeholder="lotSize"/><br/>&nbsp&nbsp
            <form:errors path="lotSize"/><br/>&nbsp&nbsp

            <form:input path="type" id="type" placeholder="Property Type(Apartment, house etc."/><br/>&nbsp&nbsp
            <form:errors path="type"/><br/>&nbsp&nbsp

            <label>Year Of Built</label>
            <form:input path="yearOfBuilt" id="yearOfBuilt" placeholder="yearOfBuilt"/><br/>&nbsp&nbsp
            <form:errors path="yearOfBuilt"/><br/>&nbsp&nbsp

            <form:input path="heatingType" id="heatingType" placeholder="heatingType"/><br/>&nbsp&nbsp
            <form:errors path="address"/><br/>&nbsp&nbsp

            <label>Property Tax</label>
            <form:input path="propertyTax" id="propertyTax" placeholder="propertyTax"/><br/>&nbsp&nbsp
            <form:errors path="address"/><br/>&nbsp&nbsp

            <form:textarea path="comments" id="comments" placeholder="comments" rows="5" cols="50"/><br/>&nbsp&nbsp
            <form:errors path="comments"/><br/>&nbsp&nbsp

        </div>

        <div id="fileUploadSection" class="default" style="background-color: white">
            <h3>Photo upload</h3>&nbsp&nbsp

        </div>

        <%--<div id="reCAPTCHA" class="g-recaptcha" data-sitekey="6LeqjBwTAAAAAGXXIHRlQipbogvJCSJvo5FnoKDB" style="background-color: white">--%>
        <%--<h3 style="color: red">${requestScope.reCAPTCHAError}</h3>--%>
        <%--</div>--%>

        <div id="submitSection" class="default" style="background-color: white">
            <input type="submit" name="submit" value="Submit"/>
        </div>
    </form:form>

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
                /** @type {!HTMLInputElement} */(document.getElementById('address')),
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
