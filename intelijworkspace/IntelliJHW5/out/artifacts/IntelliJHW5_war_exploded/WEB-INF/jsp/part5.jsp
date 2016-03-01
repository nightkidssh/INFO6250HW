<%--
    Document   : part4
    Created on : Feb 20, 2016, 12:37:35 PM
    Author     : kym-1992
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Part 5</title>
</head>
<body>
<c:choose>
    <c:when test="${requestScope.flag == 'init'}">
        <h1>Please enter the name of the file:</h1>
        <form method="post" action="part5.htm">
            <input type="text" name="filename"/>
            <input type="submit" name="submit" value="submit"/>
            <input type="hidden" name="part5action" value="enterName"/>
        </form>
    </c:when>
    <c:when test="${requestScope.flag == 'display'}">
        <h1>Please confirm the input:</h1>
        <form action="part5.htm" method="post">
            <input type="hidden" name="part5action" value="doInsert" />
            <table border="1" id="orderTable">
                <tr>
                    <td>SalesOrderID</td>
                    <td>RevisionNumber</td>
                    <td>OrderDate</td>
                    <td>DueDate</td>
                    <td>ShipDate</td>
                    <td>Status</td>
                    <td>OnlineOrderFlag</td>
                    <td>SalesOrderNumber</td>
                    <td>PurchaseOrderNumber</td>
                    <td>AccountNumber</td>
                    <td>CustomerID</td>
                    <td>SalesPersonID</td>
                    <td>TerritoryID</td>
                    <td>BillToAddressID</td>
                    <td>ShipToAddressID</td>
                    <td>ShipMethodID</td>
                    <td>CreditCardID</td>
                    <td>CreditCardApprovalCode</td>
                    <td>CurrencyRateID</td>
                    <td>SubTotal</td>
                    <td>TaxAmt</td>
                    <td>Freight</td>
                    <td>TotalDue</td>
                    <td>Comment</td>
                    <td>ModifiedDate</td>
                    <td>AddToDataBase</td>
                    <td>DeleteRecord</td>
                </tr>

                <c:forEach var="record" items="${requestScope.orderList}">
                    <tr>
                        <td><input type="text" name= "SalesOrderID" value="${record.getSalesOrderID()}" readonly=""/></td>
                        <td><input type="text" name= "RevisionNumber" value="${record.getRevisionNumber()}" readonly=""/></td>
                        <td><input type="text" name= "OrderDate" value="${record.getOrderDate()}" readonly=""/></td>
                        <td><input type="text" name= "DueDate" value="${record.getDueDate()}" readonly=""/></td>
                        <td><input type="text" name= "ShipDate" value="${record.getShipDate()}" readonly=""/></td>
                        <td><input type="text" name= "Status" value="${record.getStatus()}" readonly=""/></td>
                        <td><input type="text" name= "OnlineOrderFlag" value="${record.getOnlineOrderFlag()}" readonly=""/></td>
                        <td><input type="text" name= "SalesOrderNumber" value="${record.getSalesOrderNumber()}" readonly=""/></td>
                        <td><input type="text" name= "PurchaseOrderNumber" value="${record.getPurchaseOrderNumber()}" readonly=""/></td>
                        <td><input type="text" name= "AccountNumber" value="${record.getAccountNumber()}" readonly=""/></td>
                        <td><input type="text" name= "CustomerID" value="${record.getCustomerID()}" readonly=""/></td>
                        <td><input type="text" name= "SalesPersonID" value="${record.getSalesPersonID()}" readonly=""/></td>
                        <td><input type="text" name= "TerritoryID" value="${record.getTerritoryID()}" readonly=""/></td>
                        <td><input type="text" name= "BillToAddressID" value="${record.getBillToAddressID()}" readonly=""/></td>
                        <td><input type="text" name= "ShipToAddressID" value="${record.getShipToAddressID()}" readonly=""/></td>
                        <td><input type="text" name= "ShipMethodID" value="${record.getShipMethodID()}" readonly=""/></td>
                        <td><input type="text" name= "CreditCardID" value="${record.getCreditCardID()}" readonly=""/></td>
                        <td><input type="text" name= "CreditCardApprovalCode" value="${record.getCreditCardApprovalCode()}" readonly=""/></td>
                        <td><input type="text" name= "CurrencyRateID" value="${record.getCurrencyRateID()}" readonly=""/></td>
                        <td><input type="text" name= "SubTotal" value="${record.getSubTotal()}" readonly=""/></td>
                        <td><input type="text" name= "TaxAmt" value="${record.getTaxAmt()}" readonly=""/></td>
                        <td><input type="text" name= "Freight" value="${record.getFreight()}" readonly=""/></td>
                        <td><input type="text" name= "TotalDue" value="${record.getTotalDue()}" readonly=""/></td>
                        <td><input type="text" name= "Comment" value="${record.getComment()}" readonly=""/></td>
                        <td><input type="text" name= "ModifiedDate" value="${record.getModifiedDate()}" readonly=""/></td>
                        <td><input type="button" value="SAVE" onclick="addToDB(this, '${record.getSalesOrderID()}', '${record.getRevisionNumber()}', '${record.getOrderDate()}',
                            '${record.getDueDate()}', '${record.getShipDate()}', '${record.getStatus()}', '${record.getOnlineOrderFlag()}', '${record.getSalesOrderNumber()}',
                            '${record.getPurchaseOrderNumber()}', '${record.getAccountNumber()}', '${record.getCustomerID()}', '${record.getSalesPersonID()}', '${record.getTerritoryID()}', '${record.getBillToAddressID()}',
                            '${record.getShipToAddressID()}', '${record.getShipMethodID()}', '${record.getCreditCardID()}', '${record.getCreditCardApprovalCode()}', '${record.getCurrencyRateID()}', '${record.getSubTotal()}',
                            '${record.getTaxAmt()}', '${record.getFreight()}', '${record.getTotalDue()}', '${record.getComment()}', '${record.getModifiedDate()}')"/></td>
                        <td><input type="button" value="Remove" onclick="removeRow(this)"/></td>
                    </tr>
                </c:forEach>
            </table>
            <button type="button" id="loadMoreButton" onclick="loadMore('${requestScope.fileNamee}')">Load More</button>
        </form>
    </c:when>
    <c:when test="${requestScope.flag == 'added'}">
        <h1>Number of column added: ${requestScope.quantity}</h1>
        <a href="part5.htm">Return to home</a>
    </c:when>
</c:choose>
<script type="text/javascript">
    var xmlHttp;
    xmlHttp = GetXmlHttpObject();
    var pagee = '${requestScope.currentPage}';

    function loadMore(fileNamee){
        if (xmlHttp == null)
        {
            alert("Your browser does not support AJAX!");
            return;
        }

        var query = "part5action=loadMoreAjax&filename=" + fileNamee + "&page=" + pagee;
        xmlHttp.onreadystatechange = function stateChanged()
        {
            if (xmlHttp.readyState == 4)
            {
                var tableRef = document.getElementById('orderTable').getElementsByTagName('tbody')[0];


                console.log(xmlHttp.responseText);
                var json = JSON.parse(xmlHttp.responseText);
                pagee = json.currentPage;

                if(json.orders.length >0){
                    for(var i = 0; i<json.orders.length; i++){
                        var newRow = tableRef.insertRow(tableRef.rows.length);

                        var newCell = newRow.insertCell(0);
                        var newText = document.createTextNode(json.orders[i].salesOrderID);
                        newCell.appendChild(newText);

//                        var td2= document.createElement("TD");
//                        td2.innerHTML = json.orders[i].revisionNumber;
//
//                        var td3= document.createElement("TD");
//                        td3.innerHTML = json.orders[i].orderDate;
//
//                        var td4= document.createElement("TD");
//                        td4.innerHTML = json.orders[i].dueDate;
//
//                        var td5= document.createElement("TD");
//                        td5.innerHTML = json.orders[i].shipDate;
//
//                        var td6= document.createElement("TD");
//                        td6.innerHTML = json.orders[i].status;
//
//                        var td7= document.createElement("TD");
//                        td7.innerHTML = json.orders[i].onlineOrderFlag;
//
//                        var td8= document.createElement("TD");
//                        td8.innerHTML = json.orders[i].salesOrderNumber;
//
//                        var td9= document.createElement("TD");
//                        td9.innerHTML = json.orders[i].purchaseOrderNumber;
//
//                        var td10= document.createElement("TD");
//                        td10.innerHTML = json.orders[i].accountNumber;
//
//                        var td11= document.createElement("TD");
//                        td11.innerHTML = json.orders[i].customerID;
//
//                        var td12= document.createElement("TD");
//                        td12.innerHTML = json.orders[i].salesPersonID;
//
//                        var td13= document.createElement("TD");
//                        td13.innerHTML = json.orders[i].territoryID;
//
//                        var td14= document.createElement("TD");
//                        td14.innerHTML = json.orders[i].billToAddressID;
//
//                        var td15= document.createElement("TD");
//                        td15.innerHTML = json.orders[i].shipToAddressID;
//
//                        var td16= document.createElement("TD");
//                        td16.innerHTML = json.orders[i].shipMethodID;
//
//                        var td17= document.createElement("TD");
//                        td17.innerHTML = json.orders[i].creditCardID;
//
//                        var td18= document.createElement("TD");
//                        td18.innerHTML = json.orders[i].creditCardApprovalCode;
//
//                        var td19= document.createElement("TD");
//                        td19.innerHTML = json.orders[i].currencyRateID;
//
//                        var td20= document.createElement("TD");
//                        td20.innerHTML = json.orders[i].subTotal;
//
//                        var td21= document.createElement("TD");
//                        td21.innerHTML = json.orders[i].taxAmt;
//
//                        var td22= document.createElement("TD");
//                        td22.innerHTML = json.orders[i].freight;
//
//                        var td23= document.createElement("TD");
//                        td23.innerHTML = json.orders[i].totalDue;
//
//                        var td24= document.createElement("TD");
//                        td24.innerHTML = json.orders[i].comment;
//
//                        var td25= document.createElement("TD");
//                        td25.innerHTML = json.orders[i].modifiedDate;

                    }
                }
            }
        };
        xmlHttp.open("POST", "part5.htm", true);
        xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlHttp.send(query);
        return false;

    }

    function addToDB(thisNode, SalesOrderID,RevisionNumber,OrderDate,DueDate,ShipDate,Status,OnlineOrderFlag,SalesOrderNumber,PurchaseOrderNumber,AccountNumber,CustomerID,SalesPersonID,TerritoryID,BillToAddressID,ShipToAddressID,ShipMethodID,CreditCardID,CreditCardApprovalCode,CurrencyRateID,SubTotal,TaxAmt,Freight,TotalDue,Comment,ModifiedDate){
        if (xmlHttp == null)
        {
            alert("Your browser does not support AJAX!");
            return;
        }

        var query = "part5action=doInsert&SalesOrderID=" + SalesOrderID + "&RevisionNumber=" + RevisionNumber + "&OrderDate=" + OrderDate +"&DueDate=" + DueDate +"&ShipDate=" + ShipDate+"&Status=" + Status + "&OnlineOrderFlag=" + OnlineOrderFlag +"&SalesOrderNumber=" + SalesOrderNumber +
                "&PurchaseOrderNumber=" +PurchaseOrderNumber+"&AccountNumber="+AccountNumber+"&CustomerID="+CustomerID+"&SalesPersonID=" + SalesPersonID+"&TerritoryID="+TerritoryID+"&BillToAddressID="+BillToAddressID+"&ShipToAddressID="+ShipToAddressID+"&ShipMethodID="+ShipMethodID+"&CreditCardID=" +CreditCardID+
                "&CreditCardApprovalCode="+CreditCardApprovalCode+"&CurrencyRateID="+CurrencyRateID+"&SubTotal="+SubTotal+"&TaxAmt="+TaxAmt+"&Freight="+Freight+"&TotalDue="+TotalDue+"&Comment="+Comment+"&ModifiedDate="+ModifiedDate;

        xmlHttp.onreadystatechange = function stateChanged()
        {
            if (xmlHttp.readyState == 4)
            {
                thisNode.parentNode.parentNode.style.backgroundColor = "green";
                thisNode.value = "SAVED";
                thisNode.disabled = true;
            }
        };
        xmlHttp.open("POST", "part5.htm", true);
        xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlHttp.send(query);
        return false;

    }

    function removeRow(buttonNode){
        trNode = buttonNode.parentNode.parentNode;
        trNode.parentNode.removeChild(trNode);
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
