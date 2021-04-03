package com.epam.practice5.TextFile;

import java.io.*;
import java.util.Scanner;

/**
 * @author Piskunou Yury
 * @my.task 1. Создать объект класса Текстовый файл, используя классы Файл, Директория.
 * Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить.
 * @since 06.02.21
 */

public class TextFile {
    Directory directory = new Directory("C://fundamentals//");
    File file = new File(directory.getPath() + "file.txt");

    public File getFile() {
        return file;
    }

    private void dialogOnOverwrite(File file) {
        if (file.exists()) {
            System.out.println("The file already exists! Do you want to overwrite it? y/n");
            while (true) {
                Scanner scanner = new Scanner(System.in);
                char q = scanner.nextLine().charAt(0);
                if (q == 'n')
                    return;
                else if (q == 'y') {
                    file.delete();
                    break;
                }
            }
        }
    }

    public void create() {
        dialogOnOverwrite(file);
        try {
            boolean created = file.createNewFile();
            if (created)
                System.out.println("File has been created");
        } catch (IOException ex) {
            System.out.println("Error on creation. ");
        }
    }

    public void rename(String newName) {
        if (!newName.contains("."))
            throw new ExceptionInInitializerError("Name should contain extension!");
        File newFile = new File(file.getAbsolutePath().replaceFirst("\\w+\\.\\w{3}$", newName));
        dialogOnOverwrite(newFile);
        if (file.renameTo(newFile)) {
            file = newFile;
            System.out.println("File was renamed to " + newFile.getAbsolutePath());
        } else
            System.out.println("File wasn't renamed.");
    }

    public void printContent(File file) {
        if (file.length() == 0) {
            System.out.println("No content to read.");
            return;
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
            String s;
            while ((s = bufferedReader.readLine()) != null)
                System.out.println(s);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(String text) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
            if (text != null)
                try (FileWriter writer = new FileWriter(file, false)) {
                    writer.write(text);
                    writer.flush();
                } catch (IOException ex) {

                    System.out.println(ex.getMessage());
                }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete() {
        boolean deleted = file.delete();
        if (deleted)
            System.out.println("File has been deleted");
    }


    public static void main(String[] args) {
        TextFile textFile = new TextFile();
        String text = "Elon Musk has launched another rocket.\n" +
                "And he's going to reach Mars. This is insane. ";

        textFile.create();
        textFile.update(text);
        textFile.rename("newFile.txt");
        textFile.printContent(textFile.getFile());
        textFile.delete();
    }
}