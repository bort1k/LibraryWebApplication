<b>Task</b><br>
Система Библиотека. Создайте Каталог, по которому можно искать по:
· Автору (одному из группы).
· Названию книги или её фрагменте.
· Одному из ключевых слов книги (атрибут книги).
Каталог книг заполняет Администратор, добавляя и изменяя/удаляя их.
Каждая книга должна иметь адрес (место на полке) или читателя. Читатель
чтобы взять книгу регистрируется, оставляя э-мейл и номер телефона. Книга
может быть взята у Администратора в библиотеке на время не более месяца,
только в случае если книга доступна в библиотеке. Администратор должен
иметь страницу где отражаются взятые книги и читатели, которые
пользуются книгой.

<b>Installing instruction</b><br>
You need to download project by click Clone or download project.

You can download zip or clone project , just write in git bush console git clone 
https://github.com/bort1k/LibraryWebApplication.git

<b>Launching instruction</b><br>
To run this app you should have installed Java and Maven on your local machine.

Launch library.sql from resources/database at your sql server
At src/main/resources/database.properties change properties for your sql server
Open console and specify path to project
Write mvn clean tomcat7:run
Open your browser and in the url write http://localhost:8082/library/
