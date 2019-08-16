<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Library</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
<div class="admin_page d-flex">
    <div class="admin_left_menu">
        <div class="library_admin_text d-flex">
            <p>Library Admin</p>
        </div>
        <a class="admin_menu_button d-block" href="show_all.jsp">
            <p>Show all books</p>
        </a>
        <a class="admin_menu_button d-block" href="add_book.jsp">
            <p>Add the book</p>
        </a>
        <a class="admin_menu_button d-block" href="../home.jsp">
            <p>Back to the site</p>
        </a>
    </div>
    <div class="admin_right">
        <div>
            <div class="admin_welcome_text d-flex">
                <p>Welcome, ${sessionScope.adminSession.login}</p>
            </div>
            <div class="admin_line"></div>
        </div>
        <div>
            <p class="admin_title_content">All books</p>
        </div>
        <div class="book_list">
            <div class="table_book_list mb-5">
                <p class="text-center" style="color: #218DA6">Booked</p>
                <table class="table table-primary table-striped">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Title</th>
                            <th>Author</th>
                            <th>Number of pages</th>
                            <th>Reader</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.orders}" var="order">
                    <tr>
                        <th>${order.book.id}</th>
                        <td>${order.book.title}</td>
                        <td>${order.book.author.firstName} ${order.book.author.lastName}</td>
                        <td>${order.book.numberOfPages}</td>
                        <td>${order.reader.email}</td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="table_book_list">
                <p class="text-center" style="color: #218DA6">Not Booked</p>
                <table class="table table-primary table-striped">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Number of pages</th>
                        <th>Address</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.books}" var="book">
                        <tr>
                            <th>${book.id}</th>
                            <td>${book.title}</td>
                            <td>${book.author.firstName} ${book.author.lastName}</td>
                            <td>${book.numberOfPages}</td>
                            <td>${book.address}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>