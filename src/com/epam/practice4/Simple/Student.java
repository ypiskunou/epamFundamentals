package com.epam.practice4.Simple;

import java.util.*;

/**
 * @author Piskunou Yury
 * @my.task 3. Создайте класс с именем Train, содержащий поля: фамилия и инициалы, номер группы,
 * успеваемость (массив из пяти элементов). Создайте массив из десяти элементов такого типа.
 * Добавьте возможность вывода фамилий и номеров групп студентов, имеющих оценки, равные только 9 или 10.
 * @since 06.02.21
 */

public class Student {

    private static Student[] students;

    private String name;
    private int group;
    private Map<String, Integer> ratings;

    public Student(String name, int group, Map<String, Integer> ratings) {
        if (ratings.size() != 5) throw new IllegalArgumentException();
        this.ratings = ratings;
        this.name = name;
        this.group = group;
    }

    private void printStudent() {
        Set<Map.Entry<String, Integer>> subjects = ratings.entrySet();
        System.out.println("\n" + name + " - group " + group + ": ");
        for (Map.Entry entry : ratings.entrySet())
            System.out.println(entry.getKey() + " - " + entry.getValue());
    }

    private static void printStudentsOfHigherRating() {
        System.out.println("\n Students with all ranks higher than 9: ");
        for (Student student : students) {
            boolean higherRating = true;
            for (Integer i : student.ratings.values())
                if (i < 9) {
                    higherRating = false;
                    break;
                }
            if (higherRating)
                System.out.println(student.name + " - group " + student.group);
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> ratings;
        students = new Student[10];
        String[] names = new String[]{
                "John D.",
                "Riddley S.",
                "Potter H.",
                "Wisley R.",
                "Fisher R.",
                "Durov L.",
                "Heyerdal T.",
                "Hemmingway E.",
                "Durrell D.",
                "Churchil W."
        };
        int[] groups = new int[]{2, 5, 9};
        for (int i = 0; i < students.length; i++) {
            ratings = new HashMap<String, Integer>();
            for (int j = 0; j < 5; j++) {
                ratings.put("Science", (int) (Math.random() * 3) + 8);
                ratings.put("Calculus", (int) (Math.random() * 4) + 7);
                ratings.put("Algebra", (int) (Math.random() * 3) + 8);
                ratings.put("Optimization", (int) (Math.random() * 3) + 8);
                ratings.put("Statistics", (int) (Math.random() * 4) + 7);
            }
            students[i] = new Student(names[i], groups[(int) (Math.random() * groups.length)], ratings);
            students[i].printStudent();
        }

        Set<String> keys = students[3].ratings.keySet();

        for (String key : keys) {
            students[3].ratings.put(key, 9);
        }

        printStudentsOfHigherRating();
    }
}
