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
        <title>Part 4</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${requestScope.flag == 'init'}">
                <h1>Please enter the name of the file:</h1>
                <form method="post" action="part4.htm">
                    <input type="text" name="filename"/>
                    <input type="submit" name="submit" value="submit"/>
                    <input type="hidden" name="part4action" value="enterName"/>
                </form>                
            </c:when>
                <c:when test="${requestScope.flag == 'display'}">
                    <h1>Please confirm the input:</h1>
                    <form action="part4.htm" method="post">
                        <input type="submit" value="Submit" name="Submit"/>
                        <input type="hidden" name="part4action" value="doInsert" />
                    <table border="1">
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
                        </tr>
                    </c:forEach>
                    </table>
                    </form>
                </c:when>
                <c:when test="${requestScope.flag == 'added'}">
                    <h1>Number of column added: ${requestScope.quantity}</h1>
                    <a href="part4.htm">Return to home</a>
                </c:when>
        </c:choose>
    </body>
</html>
