package com.epam.practice4.Composition.Text;

import java.util.ArrayList;

public class Sentence {

    private ArrayList<Word> words;

    public Sentence(ArrayList<Word> words) {
        this.words = words;
    }

    public Sentence() {
        words = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sentence = new StringBuilder();
        for (Word word :
                words) {
            sentence.append(word).append(" ");
        }

        return sentence.toString();
    }

    public void fillSentence(String sentence) {

        String[] sentenceWords = sentence.split(" ");

        for (String word :
                sentenceWords) {
            if(word!=null && !word.equals(""))
            words.add(new Word(word));
        }
        words.add(new Word("\b."));
    }
}
