<%-- 
    Document   : AddBooks
    Created on : Apr 13, 2021, 8:37:29 PM
    Author     : thapa.rbn24
--%>

<%@page import="Entities.*"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Books</title>
        <link rel="stylesheet" type="text/css" href="template.css" />
    </head>
    <body>
        <div id="wrapper">
            <header>
                <c:import url="/Header.jsp" />
            </header>
            <article>
                <br/>
                <%-- this form directs to AddBookServlet --%>
                <form action="BookInfoValidationServlet"> 
                    <h4>To add a book to the Booklist, please provide following information:</h4>
                    <%-- input book title --%>
                    Book Title: <input type="text" 
                                       name="name"
                                       value="${param.name}"
                                       required
                                       style="height: 30px; width: 250px;"/>
                    <%-- error test and message --%>
                    <c:if test="${errors.nameMissing}">
                        Book title is required!
                    </c:if>
                    <br/>
                    <%-- input isbn --%>
                    ISBN: <input type="text" 
                                 name="isbn" 
                                 value="${param.isbn}"
                                 maxlength="17" <%-- 13 digits and 4 hyphens--%>
                                 placeholder="XXX-X-XX-XXXXXX-X" 
                                 required
                                 style="height: 30px; width: 250px;"/>
                    <%-- error tests and messages --%>
                    <c:if test="${errors.isbnMissing}">
                        ISBN is required!
                    </c:if>
                    <c:if test="${errors.isbnNotNumeric}">
                        Input character(s) invalid! Accepts only digits and hyphen(-) in XXX-X-XX-XXXXXX-X format.
                    </c:if>
                    <c:if test="${errors.isbnInvalidFormat}">
                        Invalid format! Please enter ISBN in XXX-X-XX-XXXXXX-X format (eg. 978-3-16-148410-0).
                    </c:if>
                    <c:if test="${errors.isbnInvalid}">
                        Format is correct, but IBSN is invalid! Please recheck the digits.
                    </c:if>
                  
                    <%-- add test for invalid ISBNs --%>
                    <br/>
            
                    <%-- input author --%>
                    Author: <input type="text" 
                                   name="author" 
                                   value="${param.author}"
                                   required
                                   style="height: 30px; width: 250px;"/>
                    <%-- error test and message --%>
                    <c:if test="${errors.authorMissing}">
                        Book author is required!
                    </c:if>
                    <br/>
                    <%-- select option for condition --%>
                    Condition:
                    <select name="condition" style="height: 30px; width: 100px;">
                        <option value="choose">choose</option>
                        <%--<c:forEach var="condition" items="${BookList.conditions}">  this version not working--%>
                        <c:forEach var="condition" items="<%=BookList.conditions%>">
                            <option value=${condition} 
                            <c:if test="${param.condition == condition}">
                                selected="true"
                            </c:if>
                            >
                            ${condition}
                            </option>
                        </c:forEach>
                    </select>
                    <%-- error test and message --%>
                    <c:if test="${errors.conditionMissing}">
                        Book condition is required!
                    </c:if>
                    <br/>
            
                    <%-- input price --%>
                    Price: <input type="text" 
                                  name="price" 
                                  value="${param.price}"
                                  placeholder="$"
                                  required
                                  style="height: 30px; width: 250px;"/>
                    <%-- error test and message --%>
                    <c:if test="${errors.priceMissing}">
                        Book price is required!
                    </c:if>
                    <c:if test="${errors.priceNotNumeric}">
                        Please enter a numeric value (eg. 5.99)!
                    </c:if>
                    <c:if test="${errors.priceNegative}">
                        Book price cannot be negative!
                    </c:if>
                    <br/><br/>
                    <%-- submit button --%>
                    <input type="submit" 
                           value="Add Book"
                           style="height: 30px; width: 120px;"/>
            </article>
            <footer>            
            <c:import url="/Footer.jsp" />
            </footer>
        </div>
    </body>
</html>
