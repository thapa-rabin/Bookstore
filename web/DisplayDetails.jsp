<%-- 
    Document   : DisplayDetails
    Created on : Apr 10, 2021, 11:52:46 PM
    Author     : thapa.rbn24
--%>

<%@page import="Entities.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Info</title>
        <link rel="stylesheet" type="text/css" href="template.css" />
    </head>
    <body>
        <div id="wrapper">
        <header>
            <c:import url="/Header.jsp" />
        </header>
        <article>
        <br/>
        <br/>
        <%-- show selected book's details --%>
        Book title: ${selectedBook.name}<br/>
        ISBN: ${selectedBook.bookID}<br/>
        Author: ${selectedBook.author}</br>
        Condition: ${selectedBook.condition}<br/>
        Price: $${selectedBook.price}<br/>
        
        <%-- this form directs to Cart servlet --%>
        <form action="Cart"> 
            <%-- Add to Cart button --%>
            <input type="hidden" id="selectedBookID" name="selectedBookID" value="${selectedBook.bookID}"/>
            <input type="submit" value="Add to Cart" style="height: 40px; width: 175px;">
        </form>
        </article>
        <footer>            
            <c:import url="/Footer.jsp" />
        </footer>
        </div>
    </body>
</html>
