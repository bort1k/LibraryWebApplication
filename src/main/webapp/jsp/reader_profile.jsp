<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 8/4/2019
  Time: 10:04 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="head_tag.jsp"/>
</head>
<body>
<div class="my_header_other d-flex">
    <jsp:include page="header.jsp"/>
</div>
<div class="title_list">
    <div class="container">
        <h2 class="title">
            PROFILE
        </h2>
        <p>
            Email: ${sessionScope.readerSession.email}
        </p>
        <p>
            Name:
            : ${sessionScope.readerSession.firstName} ${sessionScope.readerSession.lastName}
        </p>
        <p>
            Telephone Number: ${sessionScope.readerSession.telephoneNumber}
        </p>
    </div>
</div>
<div class="my_footer">
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>
