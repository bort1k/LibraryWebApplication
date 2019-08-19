package com.bortni.model.dao;

import com.bortni.model.entities.Administrator;

public interface AdministratorDao extends Dao<Administrator> {
    Administrator getByLoginAndPassword(String login, String password);
    boolean isExist(String login, String password);
}
