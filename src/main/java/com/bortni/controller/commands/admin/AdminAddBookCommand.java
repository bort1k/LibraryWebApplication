package com.bortni.controller.commands.admin;

import com.bortni.controller.commands.Command;
import com.bortni.controller.utils.UrlPath;
import com.bortni.model.entities.Author;
import com.bortni.model.entities.Book;
import com.bortni.model.entities.BookAttribute;
import com.bortni.model.entities.Language;
import com.bortni.service.AuthorService;
import com.bortni.service.BookAttributeService;
import com.bortni.service.BookService;
import com.bortni.service.LanguageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class AdminAddBookCommand implements Command {
    private BookService bookService;
    private LanguageService languageService;
    private AuthorService authorService;
    private BookAttributeService bookAttributeService;

    public AdminAddBookCommand(BookService bookService, LanguageService languageService, AuthorService authorService, BookAttributeService bookAttributeService) {
        this.bookService = bookService;
        this.languageService = languageService;
        this.authorService = authorService;
        this.bookAttributeService = bookAttributeService;
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("book_title");
        String authorFirstName = request.getParameter("book_author_first_name");
        String authorLastName = request.getParameter("book_author_last_name");
        int numberOfPages = Integer.parseInt(request.getParameter("number_of_pages"));
        String bookLanguage = request.getParameter("book_language");
        String bookAddress = request.getParameter("address");
        int publicationYear = Integer.parseInt(request.getParameter("publication_year"));
        String publicationOffice = request.getParameter("publication_office");
        String attributes = request.getParameter("book_attributes");
        String contentLanguage = request.getParameter("content_language");

        Part filePart = request.getPart("book_image");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        InputStream fileContent = filePart.getInputStream();
        String image = new BufferedReader(new InputStreamReader(fileContent))
                .lines().collect(Collectors.joining("\n"));

        Language language = languageService.getLanguageByName(contentLanguage);

        Author author = new Author.AuthorBuilder()
                .setFirstName(authorFirstName)
                .setLastName(authorLastName)
                .setLanguage(language)
                .build();
        authorService.create(author);

        Book book = new Book.BookBuilder()
                .setTitle(title)
                .setAuthor(author)
                .setAddress(bookAddress)
                .setAvailable(true)
                .setNumberOfPages(numberOfPages)
                .setBookLanguage(bookLanguage)
                .setPublicationYear(publicationYear)
                .setPublicationOffice(publicationOffice)
                .setLanguage(language)
                .setBase64Image(image)
                .build();

        bookService.createBook(book);

        Book newBook = bookService.getBookById(book.getId());

        bookAttributeService.createMany(attributes, language, newBook);

        response.sendRedirect("/library" + UrlPath.ADMIN_SHOW_ALL_BOOKS);
    }
}
