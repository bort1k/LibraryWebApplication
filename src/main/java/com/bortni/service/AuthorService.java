package com.bortni.service;

import com.bortni.model.dao.AuthorDao;
import com.bortni.model.dao.DaoFactory;
import com.bortni.model.entities.Author;

import java.util.List;

public class AuthorService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public void create(Author author){
        try(AuthorDao authorDao = daoFactory.createAuthorDao()){
            authorDao.create(author);
        }
    }

    public void update(){

    }

    public List<Author> getAllAuthors(){
        return null;
    }

    public Author getAuthorById(){
        return null;
    }

    public void delete(){

    }
}
