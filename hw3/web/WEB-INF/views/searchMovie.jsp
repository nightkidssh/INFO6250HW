<%-- 
    Document   : searchMovie
    Created on : Feb 9, 2016, 11:45:01 AM
    Author     : kym-1992
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Movies</title>
    </head>
    <body style="background-color: yellow">
        <h1>Search Movies</h1>
        <form action="movie.do" method="post">
            <h3>Keyword: <input type="text" name="searchKeyword" required /></h3>
            <h3><input type="radio" name="searchMethod" value="title" checked/>Search By Title</h3>
            <h3><input type="radio" name="searchMethod" value="actor" />Search By Actor</h3>
            <h3><input type="radio" name="searchMethod" value="actress" />Search By Actress</h3>
            <input type="submit" name="Submit" value="Search Movies"/>
            <input type="hidden" name="action" value="doSearch" />
        </form>
    </body>
</html>
