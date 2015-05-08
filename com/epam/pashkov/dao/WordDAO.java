package com.epam.pashkov.dao;

import com.epam.pashkov.ConnectorDB;
import com.epam.pashkov.Word;
import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslav_Pashkov on 5/8/2015.
 */
public class WordDAO implements InterfaceDAO<Word> {

    //English (vocabulary=true)
    @Override
    public List<Word> findTranslate(String word, boolean vocabulary) {
        List<Word> words = new ArrayList<Word>();

        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectorDB.getConnection();
            statement = (Statement) connection.createStatement();
            ResultSet rs;
            if(vocabulary) {
                int id = 0;
                rs = statement.executeQuery("SELECT id_rus FROM RussianVocabulary WHERE word='"+word+"'");
                while(rs.next()){
                    id = rs.getInt(1);
                }

                rs = statement.executeQuery("SELECT * FROM EnglishVocabulary WHERE "+id+"=EnglishVocabulary.id_rus");
            }
            else{
                int id = 0;
                rs = statement.executeQuery("SELECT id_eng FROM EnglishVocabulary WHERE word='"+word+"'");
                while(rs.next()){
                    id = rs.getInt(1);
                }

                rs = statement.executeQuery("SELECT * FROM RussianVocabulary WHERE "+id+"=RussianVocabulary.id_eng");
            }
            while(rs.next()){
                int idDB = rs.getInt(1);
                String wordDB = rs.getString(2);
                int foreignKeyDB = rs.getInt(3);
                words.add(new Word(idDB,wordDB,foreignKeyDB));
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("SQL Exeption (request or table failed):"+e);
        }

        return words;
    }

    //English (vocabulary=true)
    @Override
    public List<Word> findAllWordsInVocabulary(boolean vocabulary) {
        List<Word> words = new ArrayList<Word>();
        String vocabularyStr = vocabulary ? "EnglishVocabulary" : "RussianVocabulary";

        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectorDB.getConnection();
            statement = (Statement) connection.createStatement();
            ResultSet rs= statement.executeQuery("SELECT * FROM "+vocabularyStr);
            while(rs.next()){
                int id = rs.getInt(1);
                String word = rs.getString(2);
                int foreignKey = rs.getInt(3);
                words.add(new Word(id,word,foreignKey));
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("SQL Exeption (request or table failed):"+e);
        }


        return words;
    }

    //English (vocabulary=true)
    @Override
    public Word update(Word word, boolean vocabulary) {

        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectorDB.getConnection();
            statement = (Statement) connection.createStatement();
            if(vocabulary) {
                statement.executeUpdate("UPDATE ENGLISHVOCABULARY SET word='"+word.getTextOfWord()+"', id_rus='"+word.getForeignKey()+"' WHERE id_eng="+word.getId());
            }

            else {
                statement.executeUpdate("UPDATE RUSSIANVOCABULARY SET word='"+word.getTextOfWord()+"', id_eng='"+word.getForeignKey()+"' WHERE id_rus="+word.getId());
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("SQL Exeption (request or table failed):"+e);
        }

        return word;
    }
}
