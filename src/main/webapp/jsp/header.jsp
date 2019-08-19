<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<div class="container d-flex m-auto">
    <div class="language_menu col-6 d-flex justify-content-between">
        <div class="language">
            <div class="dropdown_language">
                <a href="?locale=en">EN</a>
                <a class="dropdown_link" ><img src="../images/ic_keyboard_arrow_down_24px.png"></a>
                <div class="dropdown-content">
                    <a href="?locale=ua">UA</a>
                </div>
            </div>
        </div>
        <div class="menu d-flex">
            <a href="${pageContext.request.contextPath}/library/home">
                <fmt:message key="label.menu.home"/>
            </a>
            <a style="color: #8C4637">&#8195|&#8195</a>
            <a href="${pageContext.request.contextPath}/library/catalogue">
                <fmt:message key="label.menu.catalogue"/>
            </a>
            <a style="color: #8C4637">&#8195|&#8195</a>
            <a href="${pageContext.request.contextPath}/library/about">
                <fmt:message key="label.menu.about"/>
            </a>
        </div>
    </div>
    <div class="sign_in col-6 text-right">
        <c:if test="${sessionScope.readerSession == null}">
            <a href="${pageContext.request.contextPath}/library/sign_in_page"><fmt:message key="label.menu.sign.in"/> </a>
        </c:if>
        <c:if test="${sessionScope.readerSession != null}">
            <a href="${pageContext.request.contextPath}/library/reader_profile">
                <fmt:message key="label.menu.sign.profile"/>
            </a>
            <a style="color: #8C4637">&#8195|&#8195</a>
            <a href="${pageContext.request.contextPath}/library/log_out">
                <fmt:message key="label.menu.sign.up"/>
            </a>
        </c:if>
    </div>
</div>
