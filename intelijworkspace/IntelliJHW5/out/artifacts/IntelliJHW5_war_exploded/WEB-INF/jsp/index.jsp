<%--
    Document   : books
    Created on : Feb 8, 2016, 3:44:45 PM
    Author     : kym-1992
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Books</title>
</head>
<body>
<h1>How many books do you want to add?</h1>
<form action="books.htm" method="post">
  <input type="number" min="1" name="bookQuantity" required />
  <input type="submit" name="Submit" value="Submit"/>
  <input type="hidden" name="action" value="add"/>
</form>
</body>
</html>
