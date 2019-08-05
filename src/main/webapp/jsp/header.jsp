<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 8/4/2019
  Time: 4:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container d-flex m-auto">
    <div class="language_menu col-6 d-flex justify-content-between">
        <div class="language">
            <div class="dropdown_language">
                <a href="#">EN</a>
                <a class="dropdown_link" href="#"><img src="../images/ic_keyboard_arrow_down_24px.png"></a>
                <div class="dropdown-content">
                    <a href="#">UA</a>
                </div>
            </div>
        </div>
        <div class="menu d-flex">
            <a href="${pageContext.request.contextPath}/library/home">
                HOME
            </a>
            <a style="color: #8C4637">&#8195|&#8195</a>
            <a href="${pageContext.request.contextPath}/library/catalogue">
                CATALOGUE
            </a>
            <a style="color: #8C4637">&#8195|&#8195</a>
            <a href="${pageContext.request.contextPath}/library/about">
                ABOUT
            </a>
        </div>
    </div>
    <div class="sign_in col-6 text-right">
        <a href="#">SIGN IN</a>
    </div>
</div>
