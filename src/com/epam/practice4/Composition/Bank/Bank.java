package com.epam.practice4.Composition.Bank;

import java.util.*;
import java.util.stream.Collectors;
import static java.util.Map.Entry.comparingByKey;

/**
 * @author Piskunou Yury
 * @my.task 4. Счета.
 * Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки счета.
 * Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам.
 * Вычисление суммы по всем счетам, имеющим положительный и отрицательный балансы отдельно.
 * @since 09.01.21
 */

public class Bank {

    private String name;
    private Map<Account, Integer> accounts;
    private Map<Integer, Client> clients;
    private Map<Integer, Account> blockedAccounts;

    static Bank bank = new Bank("Swiss");

    public Bank(String name) {
        this.name = name;
        accounts = new TreeMap<>();
        clients = new TreeMap<>();
        blockedAccounts = new TreeMap<>();
    }

    public Map<Account, Integer> getAccounts() {
        return accounts;
    }

    public Map<Integer, Client> getClients() {
        return clients;
    }

    public Map<Integer, Account> getBlockedAccounts() {
        return blockedAccounts;
    }

    public String getName() {
        return name;
    }

    public Client[] findClientsOnSurname(String surname) {
        return clients.values().stream()
                .filter(c -> c.getSurname().equals(surname))
                .toArray(Client[]::new);
    }

    public ArrayList<Account> getAccountsOnSurname(String surname){
        ArrayList<Account> allAccountsOnSurname = new ArrayList<>();
        for (Client client:
             findClientsOnSurname(surname)) {
            allAccountsOnSurname.addAll(client.getAccounts());
        }

        return allAccountsOnSurname;
    }

    public void sortAccountsOnId(ArrayList<Account> accounts){
        accounts.sort(Comparator.naturalOrder());
    }

    public void sortAccountsArrayByBalance(ArrayList<Account> accounts){
        accounts.sort(Account.getByBalance());
    }

    public void sortAccountsArrayByClientId(ArrayList<Account> accounts){
        accounts.sort(Account.getByClientId());
    }

    public ArrayList<Account> findAccountsBySurname(String surname) {
        Client[] clientsBySurname = findClientsOnSurname(surname);

        if (clientsBySurname.length == 0)
            throw new IllegalArgumentException("No such person in database!");
        if (clientsBySurname.length > 1)
            System.out.println("There is more than 1 person with such surname. The first was taken on id.");

        Arrays.sort(clientsBySurname);

        return clientsBySurname[0].getAccounts();
    }

    public void sortAccountsByBalance() {
        accounts = accounts.entrySet()
                .stream()
                .sorted(comparingByKey(Account.getByBalance()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, TreeMap::new));
    }

    public void sortAccountsById() {
        accounts = accounts.entrySet()
                .stream()
                .sorted()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, TreeMap::new));
    }

    public void printAllAccountsOnSurname(String surname) {
        ArrayList<Account> accounts = findAccountsBySurname(surname);
        System.out.println("The following accounts were found: ");
        for (Account account :
                accounts) {
            System.out.println(account);
        }
    }

    public void printAllAccountsArray(ArrayList<Account> accounts){
        for (Account account :
                accounts) {
            System.out.println(account);
        }
    }

    public void printAllAccounts(Client client) {
        ArrayList<Account> accounts = client.getAccounts();
        System.out.println("The following accounts were found: ");
        for (Account account :
                accounts) {
            System.out.println(account);
        }
    }

    @Override
    public String toString() {
        return "Bank " + name;
    }

    public static void main(String[] args) {
        Client client = new Client("Ivan", "Ivanych");
        client.addAccount().addAccount().addAccount();
        client.getAccounts().get(0).deposit(2300);
        client.getAccounts().get(1).credit(400);
        client.getAccounts().get(1).credit(450);
        client.getAccounts().get(2).deposit(1500);

        Client client2 = new Client("Boe", "Markovich");
        client2.addAccount().addAccount();
        client2.getAccounts().get(0).deposit(100500);
        client2.getAccounts().get(1).deposit(500);

        ArrayList<Account> allAccounts = bank.getAccountsOnSurname("Ivanych");
        bank.printAllAccountsOnSurname("Ivanych");
        bank.sortAccountsArrayByBalance(allAccounts);
        System.out.println("After sorting by balance: ");
        bank.printAllAccountsArray(allAccounts);

        bank.sortAccountsOnId(allAccounts);
        System.out.println("After sorting by account's id: ");
        bank.printAllAccountsArray(allAccounts);

        Client ivanych = bank.findClientsOnSurname("Ivanych")[0];
        System.out.printf("Total balance of %s is %.2f\n", ivanych.getSurname(), ivanych.getTotalBalance());
        System.out.printf("Total negative balance of %s is %.2f\n", ivanych.getSurname(), ivanych.getTotalNegativeBalance());
        System.out.printf("Total positive balance of %s is %.2f\n", ivanych.getSurname(), ivanych.getTotalPositiveBalance());
    }
}
