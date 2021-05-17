<%-- 
    Document   : Footer
    Created on : Apr 17, 2021, 3:43:07 PM
    Author     : thapa.rbn24
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Footer</title>
    </head>
    <body> 
        <%-- footer design --%>
        <div class="footer">
            <div class="footer-content">
                <div class="footer-section about">
                    <h2 class="logo-text"><span>The Online Bookstore</span></h2>
                    <%-- contact info --%>
                    <div class="contact">
                        <span><i class="fas fa-phone"></i>&nbsp;330-000-0000</span><br/>
                        <span><i class="fas fa-envelope"></i>&nbsp;info@Bookstore.com</span>
                    </div>
                    <%-- social media --%>
                    <div class="socials"><%-- needs more work --%>
                        <a href="#"><i class="fab fa-facebook"></i></a>
                        <a href="#"><i class="fab fa-twitter"></i></a>
                        <a href="#"><i class="fab fa-instagram"></i></a>
                        <a href="#"><i class="fab fa-youtube"></i></a>
                    </div>
                </div>
                <%-- user links --%>
                <div class="footer-section links"><%-- needs more work --%>
                    <h2>Quick Links</h2>
                    <br/>
                    <ul>
                        <a href="#"><li>Gallery</li></a>
                        <a href="#"><li>Deals</li></a>
                        <a href="#"><li>Extras</li></a>
                        <a href="#"><li>Terms and Conditions</li></a>
                    </ul>
                </div>
                <%-- text message --%>
                <div class="footer-section contact-form"><%-- needs more work --%>
                    <h2>Contact us</h2>
                    <br/>
                    <form>
                        <input type="email" name="email" class="text-input-contact-input" placeholder="Your email address..."/><br/>
                        <textarea name="textarea" class="text-input-contact-input" placeholder="Your message..."></textarea>
                    </form>
                </div>
            </div>
            <%-- copyright --%>
            <div class="footer-bottom">
                &copy; The Online Bookstore | Designed by Rabin Thapa
            </div>
        </div>
    </body>
</html>
