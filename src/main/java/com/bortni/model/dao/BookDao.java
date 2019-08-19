package com.bortni.model.dao;

import com.bortni.model.entities.Book;
import com.bortni.model.entities.BookAttribute;
import com.bortni.model.entities.Language;

import java.util.List;

public interface BookDao extends Dao<Book>{
    Book getByIdAndLanguage(int bookId, Language language);
    List<Book> getAllAvailable();
    List<Book> getAllAvailableByLanguage(Language language);
    List<Book> getLastThree(Language language);
    List<Book> searchByParam(String param);
    List<BookAttribute> getBookAttributesByBookId(int book_id);
    List<BookAttribute> getBookAttributesByBookIdAndLanguage(int book_id, Language language);
}
