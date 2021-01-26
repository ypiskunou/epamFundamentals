package com.epam.practice3.Regexes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Piskunou Yury
 * @my.task 1. Cоздать приложение, разбирающее текст( текст хранится в строке) и
 * позволяющее выполнять с текстом три различных операции:
 * отсортировать абзацы по количеству предложений;
 * в каждом предложении отсортировать слова по длине;
 * отсортировать лексемы в предложении по убыванию количества вхождений заданного символа,
 * а в случае равенства – по алфавиту.
 * @since 12.01.21
 */
interface Action {
    String action(String s);
}

class sortSentencesOnQty implements Action {

    @Override
    public String action(String s) {
        s = sortOnSentencesQuantity(s);
        System.out.println("Sorted on proposals quantity: \n" + s);
        return s;
    }

    private String sortOnSentencesQuantity(String text) {
        String[] parts = text.split("\\n");
        int[][] lengthsPlace = new int[parts.length][2];
        for (int i = 0; i < parts.length; i++) {
            lengthsPlace[i][0] = proposalsQuantity(parts[i]);
            lengthsPlace[i][1] = i;
        }
        for (int i = 0; i < parts.length; i++)
            for (int j = i; j < parts.length; j++)
                if (lengthsPlace[i][0] > lengthsPlace[j][0])
                    swap(lengthsPlace, i, j);
        StringBuilder sortedText = new StringBuilder();
        for (int i = 0; i < parts.length; i++)
            sortedText.append(parts[lengthsPlace[i][1]]).append("\n");
        return sortedText.toString();
    }

    private void swap(int[][] array, int a, int b) {
        int t;
        for (int i = 0; i < array[0].length; i++) {
            t = array[a][i];
            array[a][i] = array[b][i];
            array[b][i] = t;
        }
    }

    private int proposalsQuantity(String s) {
        return (int) s.chars().filter(c -> c == '!' || c == '.' || c == '?').count();
    }
}

class sortWordsOnLength implements Action {

    public String action(String text) {
        StringBuilder result = new StringBuilder();
        String[] parts = text.split("\n");
        List<String[]> sentences = new ArrayList<>();
        for (int i = 0; i < parts.length; i++) {
            sentences.add(parts[i].split("\\."));
            StringBuilder sentence;
            String sentenceTrimmed;
            String[] words;
            for (int j = 0; j < sentences.get(i).length; j++) {
                sentence = new StringBuilder();
                words = sentences.get(i)[j].split(" ");
                words = Arrays.stream(words).filter(s -> !s.equals(""))
                        .sorted(Comparator.comparingInt(String::length)).toArray(String[]::new);
                for (String word : words)
                    sentence.append(word).append(" ");
                sentenceTrimmed = sentence.toString().trim();
                result.append(sentenceTrimmed).append(". ");
            }
            result.deleteCharAt(result.length() - 1).append("\n");
        }
        text = result.toString();
        System.out.println("Sorted on words length in proposal: \n" + text);
        return text;
    }
}

class sortWordsOnLetter implements Action {
    private char input = 0;

    public String action(String text) {
        getLetter();
        StringBuilder result = new StringBuilder();
        String[] parts = text.split("\n");
        List<String[]> sentences = new ArrayList<>();
        for (int i = 0; i < parts.length; i++) {
            sentences.add(parts[i].split("\\."));
            StringBuilder sentence;
            String sentenceTrimmed;
            String[] words;
            for (int j = 0; j < sentences.get(i).length; j++) {
                sentence = new StringBuilder();
                words = Arrays.stream(sentences.get(i)[j]
                        .split(" "))
                        .filter(c -> !c.equals(""))
                        .toArray(String[]::new);

                if (words.length == 0)
                    continue;
                words = sortedWordsOnLetterAndAbc(words);

                for (String word : words)
                    sentence.append(word).append(" ");
                sentenceTrimmed = sentence.toString().trim();
                result.append(sentenceTrimmed).append(". ");
            }
            result.deleteCharAt(result.length() - 1).append("\n");
        }
        text = result.toString();

        System.out.println("Sorted on letter quantity in sentence. Then on Abc: \n" + text);
        return text;
    }

    private void getLetter() {
        System.out.println("Enter a letter to sort words due to its entries: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = (char) bufferedReader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String[] sortedWordsOnLetterAndAbc(String[] words) {

        Comparator<String> letterThenAbcComp = new compareOnLetterQty(input)
                .reversed()
                .thenComparing(new compareOnAlphabet());

        Arrays.sort(words, letterThenAbcComp);

        return words;
    }
}

class compareOnLetterQty implements Comparator<String> {
    private char letter;

    compareOnLetterQty(char letter) {
        this.letter = letter;
    }

    private int countLetterInWord(String word) {
        return (int) word.chars().filter(c -> c == letter).count();
    }

    @Override
    public int compare(String a, String b) {
        if (countLetterInWord(a) - countLetterInWord(b) < 0)
            return -1;
        if (countLetterInWord(a) == countLetterInWord(b))
            return 0;
        return 1;
    }
}

class compareOnAlphabet implements Comparator<String> {

    public int compare(String a, String b) {
        return a.compareToIgnoreCase(b);
    }
}


public class Task1 {
    private static String text = "And so even though we face the difficulties of today and tomorrow, " +
            "I still have a dream. It is a dream deeply rooted in the American dream. \n" +
            "I have a dream. \n" +
            "But we refuse to believe that the bank of justice is bankrupt. " +
            "We refuse to believe that there are insufficient funds in the great vaults of opportunity of this " +
            "nation. And so, we've come to cash this check, a check that will give us upon demand the riches " +
            "of freedom and the security of justice.";

    public static void main(String[] args) throws IOException {

        System.out.println("Original text to process: \n" + text + "\n");
        menu();
    }

    private static void menu() throws IOException {
        int input;
        Action[] menu = new Action[]{
                new sortSentencesOnQty(),
                new sortWordsOnLength(),
                new sortWordsOnLetter()
        };
        while (true) {
            System.out.println("Enter number of operation you'd like to do: \n" +
                    "0) - quit\n" +
                    "1) - sort on sentences quantity\n" +
                    "2) - sort words on their length in every sentence\n" +
                    "3) - sort words on the given letter in every sentence. Then by Abc.");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                input = Integer.parseInt(bufferedReader.readLine());
            } catch (NumberFormatException exc) {
                continue;
            }
            if (input == 0) break;
            text = menu[input - 1].action(text);
        }
    }
}
