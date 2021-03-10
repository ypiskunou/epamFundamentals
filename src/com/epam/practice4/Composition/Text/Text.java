package com.epam.practice4.Composition.Text;

import java.util.ArrayList;

/**
 * @author Piskunou Yury
 * @my.task 1. Создать объект класса Текст, используя классы Предложение, Слово.
 * Методы: дополнить текст, вывести на консоль текст, заголовок текста.
 * @since 09.01.21
 */

public class Text {
    private ArrayList<Sentence> sentences;

    public Text(ArrayList<Sentence> sentences) {
        this.sentences = sentences;
    }

    public Text() {
        sentences = new ArrayList<>();
        sentences.add(new Sentence(new ArrayList<>()));
    }

    public ArrayList<Sentence> getText() {
        return sentences;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (Sentence sentence:
             sentences) {
            text.append(sentence.toString());
        }

        return text.toString();
    }

    public void addToText(ArrayList<Sentence> sentences) {
        this.sentences.addAll(sentences);
    }

    public void printContent() {
        for (int i = 1; i < sentences.size(); i++)
            System.out.print(sentences.get(i));
    }

    public void printHeader() {

        System.out.print(sentences.get(0));
    }

    public static void main(String[] args) {

        ArrayList<Sentence> sentences = new ArrayList<>();
        String stringToAdd = "Evolution. \nRule of life in motion. Development.";
        String[] sentencesApart = stringToAdd.split("\\.");
        for (String k:
            sentencesApart ) {
            Sentence sentence = new Sentence();
            sentence.fillSentence(k);
            sentences.add(sentence);
        }

        Text text = new Text(sentences);
        System.out.println(text);
        System.out.println("\nHeader of text: ");
        text.printHeader();
        System.out.println("\n\nContent of text: ");
        text.printContent();
    }
}
