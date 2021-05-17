<%-- 
    Document   : LogIn
    Created on : Apr 16, 2021, 8:06:48 PM
    Author     : thapa.rbn24
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" type="text/css" href="template.css" />
    </head>
    <body>
        <div id="wrapper">
        <header>
            <c:import url="/Header.jsp" />
        </header>
        <article style="text-align: center;">
            <br/>
        <h3>Please input the password.</h3>
        <h4>Password: Youngstown</h4>
        <br/>
        <form action="LoginVerification">
            <label for="pass">Password (8 characters minimum):</label><br/>
            <input type="password" 
                   id="pwd" 
                   name="password" 
                   minlength="8" 
                   required
                   style="height: 30px; width: 250px;">
            <br/>
            <input type="submit" value="Log in" style="height: 30px; width: 100px;">
        </form>
        <%-- if password is not correct, display message --%>
        <c:if test="${pwdInvalid}">
                Password incorrect!
        </c:if>
        </article>
        <footer>            
            <c:import url="/Footer.jsp" />
        </footer>
        </div>
    </body>
</html>
