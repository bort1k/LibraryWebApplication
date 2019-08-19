package com.bortni.service;

import com.bortni.model.dao.BookAttributeDao;
import com.bortni.model.dao.BookDao;
import com.bortni.model.dao.DaoFactory;
import com.bortni.model.entities.Book;
import com.bortni.model.entities.BookAttribute;
import com.bortni.model.entities.Language;

import java.util.List;

public class BookService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Book> getAllBooks(){
        List<Book> books;
        try (BookDao bookDao = daoFactory.createBookDao()){
            books = bookDao.getAll();
            books.forEach(book -> book.setBookAttributes(bookDao.getBookAttributesByBookId(book.getId())));
        }
        return books;
    }

    public List<Book> getLastThree(Language language){
        List<Book> books;
        try (BookDao bookDao = daoFactory.createBookDao()){
            books = bookDao.getLastThree(language);
            books.forEach(book ->
                    book.setBookAttributes(bookDao.getBookAttributesByBookIdAndLanguage(book.getId(), language)));
        }
        return books;
    }

    public List<Book> getAllAvailableBooks(){
        List<Book> books;
        try (BookDao bookDao = daoFactory.createBookDao()){
            books = bookDao.getAllAvailable();
            books.forEach(book -> book.setBookAttributes(bookDao.getBookAttributesByBookId(book.getId())));
        }
        return books;
    }

    public List<Book> getAllAvailableBooksByLanguage(Language language){
        List<Book> books;
        try (BookDao bookDao = daoFactory.createBookDao()){
            books = bookDao.getAllAvailableByLanguage(language);
            books.forEach(book ->
                    book.setBookAttributes(bookDao.getBookAttributesByBookIdAndLanguage(book.getId(), language)));
        }
        return books;
    }

    public List<Book> getBooksSearchByParam(String param){
        List<Book> books;
        try (BookDao bookDao = daoFactory.createBookDao()){
            books = bookDao.searchByParam(param);
            books.forEach(book -> book.setBookAttributes(bookDao.getBookAttributesByBookId(book.getId())));
        }
        return books;
    }

    public Book getBookById(int id){
        Book book;
        try (BookDao bookDao = daoFactory.createBookDao()){
            book = bookDao.getById(id);
            book.setBookAttributes(bookDao.getBookAttributesByBookId(book.getId()));
        }
        return book;
    }

    public Book getBookByIdAndLanguage(int id, Language language){
        Book book;
        try (BookDao bookDao = daoFactory.createBookDao()){
            book = bookDao.getByIdAndLanguage(id, language);
            book.setBookAttributes(bookDao.getBookAttributesByBookIdAndLanguage(book.getId(), language));
        }
        return book;
    }

    public void createBook(Book book){
        try(BookDao bookDao = daoFactory.createBookDao()){
            bookDao.create(book);
        }
    }

    public void updateBook(Book book){
        try(BookDao bookDao = daoFactory.createBookDao()){
            bookDao.update(book);
        }
    }


    public void deleteBook(Book book){
        try(BookDao bookDao = daoFactory.createBookDao()){
            bookDao.delete(book);
        }
    }
}
