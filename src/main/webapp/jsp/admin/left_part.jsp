<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<div class="admin_left_menu">
<div class="library_admin_text d-flex">
    <p>Library Admin</p>
</div>
<a class="admin_menu_button d-block" href="${pageContext.request.contextPath}/library/admin/show_all">
    <p>Show all books</p>
</a>
<a class="admin_menu_button d-block" href="${pageContext.request.contextPath}/library/admin/add_book_page">
    <p>Add the book</p>
</a>
<a class="admin_menu_button d-block" href="${pageContext.request.contextPath}/library/home">
    <p>Back to the site</p>
</a>
</div>
