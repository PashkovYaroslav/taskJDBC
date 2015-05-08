package com.epam.pashkov;

/**
 * Created by Yaroslav_Pashkov on 5/8/2015.
 */
public class Word extends Entity {
    private int foreignKey;
    private String textOfWord;

    public int getForeignKey() {
        return foreignKey;
    }

    public void setForeignKey(int foreignKey) {
        this.foreignKey = foreignKey;
    }

    public String getTextOfWord() {
        return textOfWord;
    }

    public void setTextOfWord(String textOfWord) {
        this.textOfWord = textOfWord;
    }

    public Word() {
    }

    public Word(int id, String textOfWord, int foreignKey) {
        super(id);
        this.foreignKey = foreignKey;
        this.textOfWord = textOfWord;
    }

    @Override
    public String toString() {
        return textOfWord;
    }
}
