package com.epam.pashkov;

import com.epam.pashkov.dao.InterfaceDAO;
import com.epam.pashkov.dao.WordDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslav on 09.05.2015.
 */
public class Main {
    public static void main(String[] args) {
        InterfaceDAO<Word> vocabulary = new WordDAO();

        System.out.println("List of all words in English vocabulary:");
        for(Word word : vocabulary.findAllWordsInVocabulary(true)){
            System.out.println(word);
        }

        System.out.println("Translate(s) of the word \"Hello\":");

        for(Word word : vocabulary.findTranslate("Hello", false)){
            System.out.println(word);
        }

        System.out.println("Translate the list of words:");
        List<String> wordList = new ArrayList<String>();
        wordList.add("Hello");
        wordList.add("Hello");

        for(String w : wordList){
            for(Word word : vocabulary.findTranslate(w, false)){
                System.out.println(word);
            }
            System.out.println("-----");
        }

        System.out.println("Update the word with ID=1:");

        Word newWord = new Word(1,"Привет",1);
        System.out.println(vocabulary.update(newWord, false));
    }
}
