package com.bortni.model.dao;

import com.bortni.model.entities.Book;

import java.util.List;

public interface BookDao extends Dao<Book>{
    List<Book> getAllAvailable();
    List<Book> getLastThree();
    List<Book> searchByParam(String param);
}
