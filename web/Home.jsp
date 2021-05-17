<%-- 
    Document   : Home
    Created on : Apr 17, 2021, 4:31:48 PM
    Author     : thapa.rbn24
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link rel="stylesheet" type="text/css" href="template.css" />
    </head>
    <body>
        <div id="wrapper">
        <header>
            <c:import url="/Header.jsp" />
        </header>
        <article style="text-align: center;">
            <br/>
            <br/>
            <h2>Welcome to The Online Bookstore!</h2>
            <br/>
            <!-- Welcome page with an option to view Booklist -->
            <form action="ShowList">
                <!-- View Booklist button -->
                <input type="submit" value="View BookList" style="height: 50px; width: 250px;"/>
            </form>
            <br/>
            
            <!-- Log in as Admin -->
            <form action="Login.jsp">
                <input type="submit" value="Admin Access" style="height: 50px; width: 250px;"/>
            </form>
        </article>
        <footer>            
            <c:import url="/Footer.jsp" />
        </footer>
        </div>
    </body>
</html>
