<%-- 
    Document   : CurrentCart
    Created on : Apr 13, 2021, 2:44:46 PM
    Author     : thapa.rbn24
--%>

<%@page import="Entities.*"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books in your Cart</title>
        <link rel="stylesheet" type="text/css" href="template.css" />
    </head>
    <body>
        <div id="wrapper">
        <header>
            <c:import url="/Header.jsp" />
        </header>
        <article>
        <br/>
        <c:choose>
            <%-- if cart is empty --%>
            <c:when test="${cart.isEmpty()}">
                Your cart is empty!
                <form action="DisplayBooks.jsp">
                    <input type="submit" value="Add books" style="height: 30px; width: 150px;"/>
                </form>
            </c:when>
            <%-- if there are books in cart --%>
            <c:otherwise>
                <table border="1">
                    <tr>
                        <th><h2>Book Title<h2></th>
                        <th><h2>Price<h2></th>        
                    </tr>
                        <%-- loop through books in cart --%>
                        <c:forEach var="book" items="${cart}">
                            <tr>
                                <%-- direction to Cart servlet --%>
                                <form action="Cart">
                                    <td>${book.name}</td>
                                    <td>$${book.price}</td>
                                    <td>
                                        <%-- button to remove book from cart --%>
                                        <input type="hidden" id="deleteBookID" name="deleteBookID" value="${book.bookID}"/>
                                        <input type="submit" name="Remove" value="Remove" style="height: 35px; width: 150px;"/>
                                    </td>
                                </form>
                            </tr>
                        </c:forEach>
                </table>
                <br/>
                <%-- show total price (2 decimal places) --%>
                <b>Total price:
                    <fmt:formatNumber type = "currency" 
                                  maxFractionDigits = "2" 
                                  value = "${Cart.getTotalPrice()}"/>
                </b>
                <%-- direction to DisplayBooks webpage --%>
                <br/>
                <form action="DisplayBooks.jsp">
                    <input type="submit" value="Add more books" style="height: 40px; width: 175px;">
                </form>
            </c:otherwise>
        </c:choose>
        </article>
        <footer>            
            <c:import url="/Footer.jsp" />
        </footer>
        </div>
    </body>
</html>
