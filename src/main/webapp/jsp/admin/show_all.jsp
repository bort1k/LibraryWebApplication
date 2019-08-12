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
                <p>Welcome, Nikitos</p>
            </div>
            <div class="admin_line"></div>
        </div>
        <div>
            <p class="admin_title_content">All books</p>
        </div>
        <div class="book_list">
            <div class="table_book_list">
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
                    <tr>
                        <th>1</th>
                        <td>Harry Potter</td>
                        <td>Joan Rolling</td>
                        <td>345</td>
                        <td>71d</td>
                    </tr>
                    <tr>
                        <th>2</th>
                        <td>Harry Potter</td>
                        <td>Joan Rolling</td>
                        <td>345</td>
                        <td>71d</td>
                    </tr>
                    <tr>
                        <th>3</th>
                        <td>Harry Potter</td>
                        <td>Joan Rolling</td>
                        <td>345</td>
                        <td>71d</td>
                    </tr>
                    <tr>
                        <th>4</th>
                        <td>Harry Potter</td>
                        <td>Joan Rolling</td>
                        <td>345</td>
                        <td>71d</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>