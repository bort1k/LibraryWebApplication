<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/jsp/head_tag.jsp"/>
</head>
<body>
<div class="admin_page d-flex">

    <jsp:include page="left_part.jsp"/>

    <div class="admin_right">
        <div class="margin_block">
            <div class="admin_welcome_text d-flex">
                <p>Welcome, ${sessionScope.adminSession.login}</p>
            </div>
            <div class="admin_line"></div>
        </div>
        <div class>
            <p class="admin_title_content">Add the book</p>
        </div>
        <div class="add_book_form">
            <form method="post"
                  action="${pageContext.request.contextPath}/library/admin/add_book"
                  enctype="multipart/form-data">
                <div class = "my_form_item">
                    <p>Title:</p>
                    <input type="text" name="book_title" placeholder="Enter title" required>
                </div>
                <div class = "my_form_item">
                    <p>Author:</p>
                    <input type="text" name="book_author_first_name" placeholder="Enter author first name" required>
                    <input type="text" name="book_author_last_name" placeholder="Enter author last name" required>
                </div>
                <div class = "my_form_item">
                    <p>Number of pages:</p>
                    <input type="number" name="number_of_pages" placeholder="Enter number of pages" required>
                </div>
                <div class = "my_form_item">
                    <p>Address:</p>
                    <input type="text" name="address" placeholder="Enter address" required>
                </div>
                <div class = "my_form_item">
                    <p>Language:</p>
                    <input type="text" name="book_language" placeholder="Enter book language" required>
                </div>
                <div class = "my_form_item">
                    <p>Publication year:</p>
                    <input type="number" name="publication_year" placeholder="Enter publication year" required>
                </div>
                <div class = "my_form_item">
                    <p>Publication office:</p>
                    <input type="text" name="publication_office" placeholder="Enter publication office" required>
                </div>
                <div class = "my_form_item">
                    <p>Book attributes:</p>
                    <input type="text" name="book_attributes" placeholder="Enter book attributes" required>
                </div>
                <div class = "my_form_item">
                    <p>Content Language(en, ua):</p>
                    <input type="text" name="content_language" placeholder="Enter content language(en, ua)" required>
                </div>
                <div class="my_form_item">
                    <p>Download the image of the book:</p>
                    <input type="file" name="book_image" required>
                </div>
                <input type="submit" value="ADD BOOK">
            </form>
        </div>
    </div>
</div>
</body>
</html>