<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE HTML>
<html lang="en">

<head>
    <jsp:include page="head_tag.jsp"/>
</head>

<body style="background: #FFEFD5; background-size: cover; ">
<div class="">
    <div class="sign-up col-lg-4" style="color: #8C4637; margin:100px auto auto auto">
        <c:if test="${param.emailExist}">
            <p style="color: white">Sign in to your account.</p>
        </c:if>
        <c:if test="${!param.emailExist}">
            <h3 class="mb-5">SIGN IN</h3>
        </c:if>
        <form class="sign_form" action="${pageContext.request.contextPath}/library/sign_in" method="post">
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" placeholder="Enter password" name="password"
                       required>
            </div>
            <button type="submit" class="sign_button">
                Sign In
            </button>
        </form>
        <p class="mt-5">Don't have account? You can register <a href="${pageContext.request.contextPath}/jsp/sign_up.jsp">here</a> </p>
    </div>
</div>
</body>
</html>
