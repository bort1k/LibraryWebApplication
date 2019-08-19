package com.bortni.service;

import com.bortni.model.dao.BookAttributeDao;
import com.bortni.model.dao.Dao;
import com.bortni.model.dao.DaoFactory;
import com.bortni.model.entities.Book;
import com.bortni.model.entities.BookAttribute;
import com.bortni.model.entities.Language;

import java.util.ArrayList;
import java.util.List;

public class BookAttributeService {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    public void create(BookAttribute bookAttribute){
        try(BookAttributeDao bookAttributeDao = daoFactory.createBookAttributeDao()){
            bookAttributeDao.create(bookAttribute);
        }
    }

    public void createMany(String bookAttributesString, Language language, Book book){
        String[] bookAttributeArray = bookAttributesString.split(",");

        for(String attribute : bookAttributeArray){
            BookAttribute bookAttribute = new BookAttribute.BookAttributeBuilder()
                    .setKeyWord(attribute)
                    .setLanguage(language)
                    .setBook(book)
                    .build();
            create(bookAttribute);
        }
    }
}
