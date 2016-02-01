<%-- 
    Document   : ShoppingCart
    Created on : Feb 1, 2016, 2:11:32 PM
    Author     : kym-1992
--%>

<%@page import="Part7.StoreItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashSet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
    </head>
    <body>
        <h1>Items Currently in Your Cart</h1><hr>
<!--        <%
            HashSet<StoreItem> myStoreItemSet = (HashSet<StoreItem>)session.getAttribute("myShoppingCart");
            Iterator iterator = myStoreItemSet.iterator();
            while(iterator.hasNext()){
                StoreItem storeItem = (StoreItem)iterator.next();
                int id = storeItem.getId();
                String name = storeItem.getName();
            }   
        %>        -->
        
        <c:set var="counter" value="1" scope="page" />
        <c:set var="total" value="0" scope="page" />
        <c:forEach var="storeItem" items="${sessionScope.myShoppingCart}">
            <h3><c:out value="${counter}"/>.&nbsp<c:out value="${storeItem.name}"/>&nbsp&nbsp&nbsp$<c:out value="${storeItem.price}"/><a href="removeItem.htm?action=remove&id=<c:out value='${storeItem.id}'/>">[ Remove from cart ]</a></h3><br/>
            <c:set var="total" value="${total + storeItem.price}" scope="page"/>
            <c:set var="counter" value="${counter + 1}" scope="page"/>
        </c:forEach>
        
        <hr/>
        <h3>TOTAL:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp$<c:out value="${total}"/></h3>
    </body>
</html>
