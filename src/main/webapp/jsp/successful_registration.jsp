<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<!DOCTYPE html>
<html lang="${locale}">

<head>
    <jsp:include page="head_tag.jsp"/>
</head>

<body style="background: #FFEFD5; background-size: cover; ">
<div class="">
    <div class="sign-up col-lg-4" style="color: #8C4637; margin:100px auto auto auto">
        <h3><fmt:message key="label.successful.registration"/> </h3>
        <p class="mt-5"><fmt:message key="label.successful.registration.now.you.can"/>
            <a href="${pageContext.request.contextPath}/library/sign_in">
                <fmt:message key="label.successful.registration.sign.in"/>
            </a>
            <fmt:message key="label.successful.registration.or.go.to"/>
            <a href="${pageContext.request.contextPath}/library/home">
                <fmt:message key="label.successful.registration.home"/>
            </a>
        </p>
    </div>
</div>
</body>
</html>
