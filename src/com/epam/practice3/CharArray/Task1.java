package com.epam.practice3.CharArray;

/**
 * @author Piskunou Yury
 * @my.task 1. Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.
 * @since 24.12.20
 */
public class Task1 {
    public static void main(String[] args) {

        String[] camelCases = new String[]{
                "toBeerErC",
                "NorNot",
                "toBeer",
                "topCoder",
                "shredderCoder"
        };

        String[] snake_cases = camelToSnake(camelCases);
        for (String snake_case : snake_cases)
            System.out.println(snake_case);
    }

    private static String[] camelToSnake(String[] camels) {
        String[] snakes = new String[camels.length];
        for (int j = 0; j < camels.length; j++) {
            char[] camelLetters = camels[j].toCharArray();
            while (firstHumpToSnake(camelLetters) != null)
                camelLetters = firstHumpToSnake(camelLetters);

            snakes[j] = new String(camelLetters);
        }

        return snakes;
    }

    private static char[] firstHumpToSnake(char[] camelLetters) {
        char[] snake_letters = null;
        for (int i = 0; i < camelLetters.length; i++) {
            if (camelLetters[i] >= 65 && camelLetters[i] <= 90) {
                snake_letters = new char[camelLetters.length + 1];
                System.arraycopy(camelLetters, 0, snake_letters, 0, i);
                snake_letters[i] = '_';
                snake_letters[i + 1] = (char) (camelLetters[i] + 32);
                int chunkStart = i + 2;
                int chunkLength = snake_letters.length - chunkStart;
                System.arraycopy(camelLetters, i + 1, snake_letters,
                        chunkStart, chunkLength);
            }
        }

        return snake_letters;
    }
}
