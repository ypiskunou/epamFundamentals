package com.epam.practice4.Composition.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word {

    private String word;

    public String getWord() {
        return word;
    }

    @Override

    public String toString() {
        return word;
    }

    public Word(String word) {
        Pattern pattern = Pattern.compile("\\s\\w");
        Matcher matcher = pattern.matcher(word);

        if (!matcher.find() || word.contains("\n"))
            this.word = word;
        else
            throw new IllegalArgumentException("The word has spaces! ");
    }

    public Word() {
    }
}
