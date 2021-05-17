<%-- 
    Document   : DisplayBooks
    Created on : Apr 10, 2021, 9:27:27 PM
    Author     : thapa.rbn24
--%>

<%@page import="Entities.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Available Books</title>
        <link rel="stylesheet" type="text/css" href="template.css" />
    </head>
    <body>
        <div id="wrapper">
        <header>
            <c:import url="/Header.jsp" />
        </header>
        <article>
        <br/>
        <%-- create table to show booklist --%>
        <table border="1">
            <tr>
               <th><h3>Book Title<h3></th>
            </tr>
            <%-- iterate through booklist --%>
            <c:forEach var="book" items="${booklist}">
                <tr>
                    <form action="FindSelectedBook">
                    <td> ${book.name}</td>
                    <td> 
                        <%-- add Details button --%>
                        <input type="hidden" id="bookID" name="bookID" value="${book.bookID}"/>
                        <input type="submit" name="Details" value="Details" style="height: 40px; width: 200px;"/>
                    </td>
                    </form>
                </tr>
            </c:forEach>
        </table>
        </article>
        <footer>
            <c:import url="/Footer.jsp" />
        </footer>
        </div>
    </body>
</html>