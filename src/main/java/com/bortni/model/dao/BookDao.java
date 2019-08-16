package com.bortni.model.dao;

import com.bortni.model.entities.Book;
import com.bortni.model.entities.BookAttribute;

import java.util.List;

public interface BookDao extends Dao<Book>{
    List<Book> getAllAvailable();
    List<Book> getLastThree();
    List<Book> searchByParam(String param);
    List<BookAttribute> getBookAttributesByBookId(int book_id);
}
