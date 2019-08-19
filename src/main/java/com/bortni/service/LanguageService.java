package com.bortni.service;

import com.bortni.model.dao.DaoFactory;
import com.bortni.model.dao.LanguageDao;
import com.bortni.model.entities.Book;
import com.bortni.model.entities.Language;

public class LanguageService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public Language getLanguageByName(String languageName){
        try(LanguageDao languageDao = daoFactory.createLanguageDao()){
            return languageDao.getLanguageByLanguageName(languageName);
        }
    }
}
