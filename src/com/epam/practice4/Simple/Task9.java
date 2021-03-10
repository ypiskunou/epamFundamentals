package com.epam.practice4.Simple;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Piskunou Yury
 * @my.task 9. Создать класс Book, спецификация которого приведена ниже.
 * Определить конструкторы, set- и get- методы и метод toString().
 * Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и методами.
 * Задать критерии выбора данных и вывести эти данные на консоль.
 * <p>
 * Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
 * Найти и вывести:
 * a) список книг заданного автора;
 * b) список книг, выпущенных заданным издательством;
 * c) список книг, выпущенных после заданного года.
 * @since 07.02.21
 */
enum Binder {
    PAPER,
    LEATHER,
    FABRIC
}

class Book {

    private static int counter = 1;

    private int id;
    private String name;
    private String author;
    private String publisher;
    private int year;
    private int pages;
    private BigDecimal price;
    private Binder binder;

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public Book(String name, String author, String publisher, int year, int pages, BigDecimal price, Binder binder) {
        id = counter++;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.pages = pages;
        this.price = price;
        this.binder = binder;
    }

    @Override
    public String toString() {

        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year=" + year +
                ", pages=" + pages +
                ", price=" + price +
                ", binder=" + binder +
                '}';
    }
}

class Library {

    public ArrayList<Book> getBooks() {
        return books;
    }

    private ArrayList<Book> books;

    public Library(ArrayList<Book> _books) {
        books = _books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void booksByAuthor(String author) {
        ArrayList<Book> booksList = books.stream()
                .filter(c -> c.getAuthor().contains(author)).collect(Collectors.toCollection(ArrayList::new));
        for (Book book :
                booksList) {
            System.out.println(book);
        }
    }

    public void booksByPublisher(String publisher) {
        ArrayList<Book> booksList = books.stream()
                .filter(c -> c.getPublisher().equals(publisher)).collect(Collectors.toCollection(ArrayList::new));
        for (Book book :
                booksList) {
            System.out.println(book);
        }
    }

    public void booksAfterYear(int year) {
        ArrayList<Book> booksList = books.stream()
                .filter(c -> c.getYear() > year).collect(Collectors.toCollection(ArrayList::new));
        for (Book book :
                booksList) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>(Arrays.asList(
                new Book("Garden of gods", "Durrell G.", "Mir", 1985,
                        555, new BigDecimal(2.20).setScale(2, RoundingMode.HALF_UP), Binder.LEATHER),
                new Book("My family and other animals", "Durrell G.", "Mir", 1985,
                        505, new BigDecimal(2.40).setScale(2, RoundingMode.HALF_UP), Binder.LEATHER),
                new Book("Electronics", "Horovitz", "Farber", 2005,
                        1200, new BigDecimal(20).setScale(2, RoundingMode.HALF_UP), Binder.PAPER),
                new Book("Variational Calculus", "Tykun", "Asveta", 2007,
                        512, new BigDecimal(24.50).setScale(2, RoundingMode.HALF_UP), Binder.PAPER),
                new Book("Java", "Romanchyk", "Asveta", 2010,
                        750, new BigDecimal(15.70).setScale(2, RoundingMode.HALF_UP), Binder.LEATHER),
                new Book("English", "Odoyevsky", "Obninsk", 1995,
                        350, new BigDecimal(17).setScale(2, RoundingMode.HALF_UP), Binder.FABRIC)
        ));

        Library library = new Library(books);

        String authorToFind = "Durrell";
        System.out.printf("\nAll books of writer %s \n", authorToFind);
        library.booksByAuthor(authorToFind);

        String publisherToFind = "Asveta";
        System.out.printf("\nAll books of publisher %s \n", publisherToFind);
        library.booksByPublisher(publisherToFind);

        int yearToFindAfter = 1995;
        System.out.printf("\nAll books after the year %d \n", yearToFindAfter);
        library.booksAfterYear(yearToFindAfter);
    }

}