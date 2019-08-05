package com.bortni.model.dao;

import com.bortni.model.entities.BookAttribute;

import java.util.List;

public interface BookAttributeDao extends Dao<BookAttribute>{
    List<BookAttribute> getAttributesByBookId(int id);
}
