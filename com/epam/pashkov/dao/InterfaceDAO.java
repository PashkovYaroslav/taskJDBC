package com.epam.pashkov.dao;

import com.epam.pashkov.Entity;

import java.util.List;

/**
 * Created by Yaroslav_Pashkov on 5/8/2015.
 */
public interface InterfaceDAO<W extends Entity>{
    public abstract List<W> findAllWordsInVocabulary(boolean vocabulary);
    public abstract List<W> findTranslate(String word, boolean vocabulary);
    public abstract W update(W w, boolean vocabulary);
}

