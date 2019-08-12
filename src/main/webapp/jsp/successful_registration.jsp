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
        <h3>REGISTRATION IS SUCCESSFUL</h3>
        <p class="mt-5">Now you can <a href="${pageContext.request.contextPath}/library/sign_in">sign in</a>
            or go to <a href="${pageContext.request.contextPath}/library/home">home</a></p>
    </div>
</div>
</body>
</html>
