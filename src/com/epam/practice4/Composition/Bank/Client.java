package com.epam.practice4.Composition.Bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;

public class Client extends BankEntityAbstract implements Comparable {
    private Bank bank = Bank.bank;
    private int id = idGenerator(new ArrayList<>(bank.getClients().keySet()));
    private String name;
    private String surname;
    private ArrayList<Account> accounts = new ArrayList<>();

    private BigDecimal totalNegativeBalance;
    private BigDecimal totalPositiveBalance;
    private Comparator<Account> byBalance = Comparator.comparing(Account::getBalance);
    private static Comparator<Client> byTotalBalance = Comparator.comparing(Client::getTotalBalance);

    public Client(String name, String surname) {
        this.name = name;
        this.surname = surname;

        accounts.add(new Account(this));
        bank.getClients().put(id, this);
    }

    public Client addAccount() {
        accounts.add(new Account(this));
        return this;
    }

    public void updateBalance() {
        totalNegativeBalance = new BigDecimal(0);
        totalPositiveBalance = new BigDecimal(0);
        for (Account account :
                accounts) {
            if (account.getBalance().compareTo(new BigDecimal(0)) >= 0)
                totalPositiveBalance = totalPositiveBalance.add(account.getBalance());
            else totalNegativeBalance = totalNegativeBalance.add(account.getBalance());
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getTotalNegativeBalance() {
        return totalNegativeBalance;
    }

    public BigDecimal getTotalPositiveBalance() {
        return totalPositiveBalance;
    }

    public BigDecimal getTotalBalance() {
        return totalNegativeBalance.add(totalPositiveBalance);
    }

    public static Comparator<Client> getByTotalBalance() {
        return byTotalBalance;
    }

    public void sortAccountsByBalance() {
        accounts.sort(byBalance);
    }

    public void sortAccountsById() {
        accounts.sort(Comparator.naturalOrder());
    }

    @Override
    public String toString() {
        return "Client{" +
                "bank=" + bank +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(id, ((Client) o).id);
    }
}
