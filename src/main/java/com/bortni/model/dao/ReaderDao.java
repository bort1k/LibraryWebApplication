package com.bortni.model.dao;

import com.bortni.model.entities.Reader;

public interface ReaderDao extends Dao<Reader>{
    boolean isExist(Reader reader);
    Reader getReaderByEmailAndPassword(String email, String password);

    boolean isEmailExist(String email);
}
