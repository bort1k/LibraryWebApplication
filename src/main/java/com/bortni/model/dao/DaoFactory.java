package com.bortni.model.dao;

import com.bortni.model.dao.implementation.DaoFactoryImpl;
import com.bortni.model.entities.BookAttribute;
import com.bortni.model.entities.Reader;

public abstract class DaoFactory {

    private static DaoFactory daoFactory;

    public abstract BookDao createBookDao();

    public abstract AuthorDao createAuthorDao();

    public abstract BookAttributeDao createBookAttributeDao();

    public abstract ReaderDao createReaderDao();

    public static DaoFactory getInstance(){
        if(daoFactory == null){
            synchronized (DaoFactory.class){
                if(daoFactory == null){
                    daoFactory = new DaoFactoryImpl();
                }
            }
        }
        return daoFactory;
    }
}
