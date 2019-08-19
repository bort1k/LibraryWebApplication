
<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 8/4/2019
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<!DOCTYPE html>

<div class="my_footer">
    <div class="footer_top container d-flex justify-content-between">
        <div class="col-4">
            <p class="contact_us"><fmt:message key="label.footer.contact.us"/> </p>
            <div class="phone_icons d-flex">
                <div class="phone_icon">
                    <img src="../images/020-telegram.png">
                </div>
                <div class="phone_icon">
                    <img src="../images/027-whatsapp.png">
                </div>
            </div>
            <p class="phone_number">+ (380) 93-904-77-66</p>
            <p class="phone_number">+ (380) 93-061-47-85</p>

        </div>
        <div class="col-5">
            <p class="subscribe_social"><fmt:message key="label.footer.subscribe.social"/> </p>
            <div class="social_icons">
                <div class="social_icon d-flex">
                    <div class="wrapper_icon">
                        <img src="../images/013-facebook.png">
                    </div>
                    <a href="https://www.facebook.com/nikita.bort"><p class="fb_link mt-auto mb-auto">www.facebook.com/chytalnya</p></a>
                </div>
                <div class="social_icon d-flex">
                    <div class="wrapper_icon">
                        <img src="../images/014-instagram.png">
                    </div>
                    <a href="https://www.instagram.com/nbortik/"><p class="insta_link mt-auto mb-auto">www.instagram.com/chytalnya/</p></a>
                </div>
            </div>
        </div>
    </div>
    <div class="footer_bottom container d-flex justify-content-between">
        <div class="col-4">
            <div class="email">
                <img src="../images/043-email.png">
                <p>happy.chytalnya@gmail.com</p>
            </div>
        </div>
        <div class="col-5 position-relative">
            <div class="position-absolute copyright">
                <p><fmt:message key="label.footer.copyright"/> </p>
                <p><fmt:message key="label.footer.all.rights.reserved"/> </p>
            </div>
        </div>
    </div>
</div>
