package com.bortni.service;

import com.bortni.model.dao.AdministratorDao;
import com.bortni.model.dao.DaoFactory;
import com.bortni.model.dao.implementation.AdministratorDaoImpl;
import com.bortni.model.entities.Administrator;

public class AdministratorService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public Administrator getAdministratorByLoginAndPassword(String login, String password){
        Administrator administrator;
        try (AdministratorDao administratorDao = daoFactory.createAdministratorDao()){
            administrator = administratorDao.getByLoginAndPassword(login, password);
        }
        return administrator;
    }

    public boolean isExist(String login, String password){
        boolean exist;
        try(AdministratorDao administratorDao = daoFactory.createAdministratorDao()){
            exist = administratorDao.isExist(login, password);
        }
        return exist;
    }
}
