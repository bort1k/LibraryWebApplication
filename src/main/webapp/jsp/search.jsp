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
            SEARCH FOR: ${requestScope.search_param}
        </h2>
        <c:if test="${requestScope.search_size == 0}">
            <h3 class="title">NOTHING WAS FOUND</h3>
        </c:if>
        <div class="books_list row">
            <c:forEach var="book" items="${requestScope.booksSearchByParam}">
                <div class="book_item col-4 mb-5">
                    <div class="w-100 wrapper_image d-flex">
                        <img class="book_image" src="data:image/jpg;base64,${book.base64Image}">
                    </div>
                    <div class="book_name_wrapper d-flex m-auto">
                        <div class="m-auto">
                            <p class="book_author">${book.author.firstName} ${book.author.lastName}</p>
                            <p class="book_name">"${book.title}"</p>
                            <c:forEach var="attribute" items="${book.bookAttributes}">
                                <p> - ${attribute.keyWord}</p>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<div class="my_footer">
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>
