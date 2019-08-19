package com.bortni.service;

import com.bortni.model.dao.DaoFactory;
import com.bortni.model.dao.ReaderDao;
import com.bortni.model.entities.Order;
import com.bortni.model.entities.Reader;

import java.util.List;

public class ReaderService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Reader> getAllReaders(){
        List<Reader> readers;
        try (ReaderDao readerDao = daoFactory.createReaderDao()){
            readers = readerDao.getAll();
        }
        return readers;
    }


    public Reader getReaderById(int id){
        Reader reader;
        try (ReaderDao readerDao = daoFactory.createReaderDao()){
            reader = readerDao.getById(id);
        }
        return reader;
    }

    public void create(Reader reader){
        try (ReaderDao readerDao = daoFactory.createReaderDao()){
            readerDao.create(reader);
        }
    }

    public boolean isReaderExist(Reader reader){
        boolean exist;
        try(ReaderDao readerDao = daoFactory.createReaderDao()){
            exist = readerDao.isExist(reader);
        }
        return exist;
    }

    public Reader getReaderByEmailAndPassword(String email, String password){
        Reader reader;
        try(ReaderDao readerDao = daoFactory.createReaderDao()){
            reader = readerDao.getReaderByEmailAndPassword(email,password);
        }
        return reader;
    }

    public boolean isEmailExist(String email) {
        boolean exist;
        try(ReaderDao readerDao = daoFactory.createReaderDao()){
            exist = readerDao.isEmailExist(email);
        }
        return exist;
    }
}
