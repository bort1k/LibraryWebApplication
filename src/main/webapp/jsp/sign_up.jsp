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
        <h3 class="mb-3"><fmt:message key="label.sign.up.registration"/></h3>
        <p style="color: red; font-size: 14px; margin: 20px auto">
            ${requestScope.SignUpFailedMessage}
        </p>
        <form class="sign_form" action="${pageContext.request.contextPath}/library/sign_up" method="post">
            <div class="form-group">
                <label for="first-name"><fmt:message key="label.sign.up.first.name"/> </label>
                <input type="text" class="form-control" id="first-name"
                       placeholder="<fmt:message key="label.placeholder.sign.first.name"/>" name="first_name"
                       required>
            </div>
            <div class="form-group">
                <label for="last-name"><fmt:message key="label.sign.up.last.name"/> </label>
                <input type="text" class="form-control" id="last-name"
                       placeholder="<fmt:message key="label.placeholder.sign.last.name"/> " name="last_name"
                       required>
            </div>
            <div class="form-group">
                <label for="telephone_number"><fmt:message key="label.sign.up.telephone.number"/> </label>
                <input type="text" class="form-control" id="telephone_number"
                       placeholder="<fmt:message key="label.placeholder.sign.telephone.number"/> "
                       name="telephone_number" required>
            </div>
            <div class="form-group">
                <label for="email"><fmt:message key="label.sign.in.email"/> </label>
                <input type="email" class="form-control" id="email"
                       placeholder="<fmt:message key="label.sign.in.email"/> " name="email" required>
            </div>
            <div class="form-group">
                <label for="password"><fmt:message key="label.sign.in.password"/> </label>
                <input type="password" class="form-control" id="password"
                       placeholder="<fmt:message key="label.placeholder.sign.password" />" name="password"
                       required>
            </div>
            <button type="submit" class="button">Sign Up</button>
        </form>

    </div>
</div>
</body>
</html>
