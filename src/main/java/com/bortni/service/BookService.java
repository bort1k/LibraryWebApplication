package com.bortni.service;

import com.bortni.model.dao.BookDao;
import com.bortni.model.dao.DaoFactory;
import com.bortni.model.entities.Book;

import java.util.List;

public class BookService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Book> getAllBooks(){
        List<Book> books;
        try (BookDao bookDao = daoFactory.createBookDao()){
            books = bookDao.getAll();
        }
        return books;
    }

    public List<Book> getLastThree(){
        List<Book> books;
        try (BookDao bookDao = daoFactory.createBookDao()){
            books = bookDao.getLastThree();
        }
        return books;
    }

    public List<Book> getAllAvailibleBooks(){
        List<Book> books;
        try (BookDao bookDao = daoFactory.createBookDao()){
            books = bookDao.getAllAvailable();
        }
        return books;
    }

    public List<Book> getBooksSearchByParam(String param){
        List<Book> books;
        try (BookDao bookDao = daoFactory.createBookDao()){
            books = bookDao.searchByParam(param);
        }
        return books;
    }

    public Book getBookById(int id){
        Book book;
        try (BookDao bookDao = daoFactory.createBookDao()){
            book = bookDao.getById(id);
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
