package com.epam.practice4.Simple;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Piskunou Yury
 * @my.task 8. Создать класс Customer, спецификация которого приведена ниже.
 * Определить конструкторы, set- и get- методы и метод toString().
 * Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами и методами.
 * Задать критерии выбора данных и вывести эти данные на консоль.
 * <p>
 * Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
 * Найти и вывести:
 * a) список покупателей в алфавитном порядке;
 * b) список покупателей, у которых номер кредитной карточки находится в заданном интервале
 * @since 07.02.21
 */

class Customer {
    //region set/get
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(int creditCard) {
        this.creditCard = creditCard;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }
    //endregion

    private static int counter = 1;

    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private int creditCard;
    private int account;

    public Customer(String surname, String name, String patronymic, String address, int creditCard, int account) {
        id = counter++;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.creditCard = creditCard;
        this.account = account;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", address='" + address + '\'' +
                ", creditCard=" + creditCard +
                ", account=" + account +
                '}';
    }
}

class InsuranceDepartment {

    private Customer[] customers;

    public InsuranceDepartment(Customer[] customers) {
        this.customers = customers;
    }

    public void customersInAbc() {
        Arrays.sort(customers, Comparator.comparing(Customer::getSurname));
        for (Customer customer :
                customers) {
            System.out.println(customer);
        }
    }

    public void customersWithCreditCardInRange(int a, int b) {
        Customer[] intervalOnCreditCardCustomers = (Customer[]) Arrays.stream(customers)
                .filter(c -> c.getCreditCard() < b && c.getCreditCard() > a).toArray(Customer[]::new);
        for (Customer customer :
                intervalOnCreditCardCustomers) {
            System.out.println(customer);
        }
    }

    public static void main(String[] args) {

        Customer[] customers = new Customer[]{
                new Customer("Doe", "Joe", "Ivanych", "Gomel, Angels Str, 20",
                        2345, 4325),
                new Customer("Malkovich", "Scott", "Ivanych", "Minsk, Nemiga Str, 17",
                        2567, 5487),
                new Customer("Rupert", "Robert", "Ivanych", "Rome, Pietro Str, 55",
                        5412, 8732),
                new Customer("Merrydog", "Paul", "Ivanych", "Grodno, Broadway Str, 7",
                        3775, 7655),
                new Customer("Pippin", "Michael", "Ivanych", "Grodno, Broadway Str, 15",
                        4427, 8778),
                new Customer("Vaarsgaard", "Sebastian", "Ivanych", "Tromso, Sardin Str, 1",
                        7685, 5426),
                new Customer("Drogba", "Andrew", "Ivanych", "Atlanta, Walnut Str, 55",
                        7634, 2277)
        };

        InsuranceDepartment insuranceDepartment = new InsuranceDepartment(customers);

        System.out.println("All customers in abc order: ");
        insuranceDepartment.customersInAbc();

        int a = 3000;
        int b = 7000;
        System.out.printf("\nCustomers with credit cards in the range of %d - %d \n", a, b);
        insuranceDepartment.customersWithCreditCardInRange(a, b);
    }

}