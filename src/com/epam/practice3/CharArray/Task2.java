package com.epam.practice3.CharArray;

/**
 * @author Piskunou Yury
 * @my.task 2. Замените в строке все вхождения 'word' на 'letter'.
 * @since 24.12.20
 */
public class Task2 {

    private static String text = "Word. There was a word. And the word was love. Oh that sweet word. Prime word.";
    private static String word = "word";
    private static String letter = "letter";
    private static boolean isCaseSensitive = false;

    public static void main(String[] args) {

        System.out.println(replaceWordByLetter(text, word, letter, findAll(text, word, isCaseSensitive)));
    }

    private static String toLowerCase(String s) {
        char[] sChars = s.toCharArray();
        for (int i = 0; i < sChars.length; i++)
            if (sChars[i] >= 65 && sChars[i] <= 90)
                sChars[i] += 32;

        return new String(sChars);
    }

    private static String replaceWordByLetter(String text, String word, String letter, int[] addresses) {
        if (addresses[0] == text.length())
            return text;

        char[] wordChars = word.toCharArray();
        char[] letterChars = letter.toCharArray();

        int difference = letterChars.length - wordChars.length;
        char[] textChars = new char[text.length() + difference * addresses.length];
        char[] previousText = text.toCharArray();
        System.arraycopy(previousText, 0, textChars,
                0, addresses[0]);
        System.arraycopy(letterChars, 0, textChars,
                addresses[0], letter.length());

        for (int i = 1; i < addresses.length; i++) {
            System.arraycopy(previousText, addresses[i - 1] + word.length(), textChars,
                    addresses[i - 1] + (i - 1) * difference +
                            letter.length(), addresses[i] - addresses[i - 1] - word.length());
            System.arraycopy(letterChars, 0, textChars,
                    addresses[i] + i * difference, letter.length());
        }
        int last = addresses.length - 1;
        System.arraycopy(previousText, addresses[last] + word.length(), textChars,
                addresses[last] + last * difference + letter.length(),
                previousText.length - addresses[last] - word.length());

        return new String(textChars);
    }

    private static int[] right;

    private static void boyerMoore(String pat) { // Вычисление таблицы сдвигов,
        int M = pat.length();
        int R = 256;
        right = new int[R];
        for (int c = 0; c < R; c++)
            right[c] = -1; // -1 для символов, отсутствующих в образце
        for (int j = 0; j < M; j++)
            right[pat.charAt(j)] = j; // самая правая позиция для символов в образце
    }

    private static int search(String txt, String pat, int offset) { // Поиск образца в txt.
        boyerMoore(pat);
        int N = txt.length();
        int M = pat.length();
        int skip;
        for (int i = offset; i <= N - M; i += skip) { // Совпадает ли образец с текстом в позиции i ?
            skip = 0;
            for (int j = M - 1; j >= 0; j--)
                if (pat.charAt(j) != txt.charAt(i + j)) {
                    skip = j - right[txt.charAt(i + j)];
                    if (skip < 1) skip = 1;
                    break;
                }

            if (skip == 0) return i;
        }
        return N;
    }

    private static int[] findAll(String txt, String pat, boolean isCaseSensitive) {
        int[] addresses = new int[txt.length() / pat.length()];
        int i = 0;
        int offset = 0;
        if(!isCaseSensitive){
            txt = toLowerCase(txt);
            pat = toLowerCase(pat);
        }

        for (; addresses[i] < addresses.length; i++) {
            addresses[i] = search(txt, pat, offset);
            if (addresses[i] == txt.length())
                break;
            offset = addresses[i] + pat.length();
        }

        int[] result = new int[i];
        for (i = 0; addresses[i] < txt.length(); i++)
            result[i] = addresses[i];

        return result;
    }
}

