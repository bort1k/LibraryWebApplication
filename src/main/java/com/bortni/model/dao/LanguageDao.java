package com.bortni.model.dao;

import com.bortni.model.entities.Language;

public interface LanguageDao extends Dao<Language> {
    Language getLanguageByLanguageName(String languageName);
}
