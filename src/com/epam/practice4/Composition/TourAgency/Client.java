package com.epam.practice4.Composition.TourAgency;

public class Client {
    private String name;
    private String surname;
    private static int counter = 0;
    private int id;

    public Client(String name, String surname) {
        this.name = name;
        this.surname = surname;
        counter++;
        id = counter;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getId() {
        return id;
    }
}
