<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE HTML>
<html lang="en">

<head>
    meta charset="UTF-8">
    <title>Admin Library</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>

<body style="background: #FFEFD5; background-size: cover; ">
<div class="">
    <div class="sign-up col-lg-4" style="color: #8C4637; margin:100px auto auto auto">
        <h3 class="mb-3">ADMINISTRATOR</h3>
        <form class="sign_form" action="${pageContext.request.contextPath}/library/admin" method="post">
            <div class="form-group">
                <label for="login">Email:</label>
                <input type="email" class="form-control" id="login" placeholder="Enter login" name="login" required>
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
    </div>
</div>
</body>
</html>
