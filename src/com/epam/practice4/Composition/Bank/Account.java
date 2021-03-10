package com.epam.practice4.Composition.Bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;

public class Account extends BankEntityAbstract implements Comparable {
    private AccountStatus status;
    private int id;
    private Client client;
    private BigDecimal balance;
    private static Comparator<Account> byBalance = Comparator.comparing(Account::getBalance);
    private static Comparator<Account> byClientId = Comparator.comparing(Account::getClient);

    public Account(Client client) {
        Bank bank = Bank.bank;
        id = idGenerator(new ArrayList<>(bank.getAccounts().values()));
        this.client = client;
        bank.getAccounts().put(this, id);
        status = AccountStatus.UNBLOCKED;
        balance = new BigDecimal(0);
    }

    public static BigDecimal totalBalance(Client client) {
        return client.getTotalNegativeBalance().add(client.getTotalPositiveBalance());
    }

    public void toggleStatus() {
        status = AccountStatus.values()[((status.ordinal() + 1) % 2)];
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public static Comparator<Account> getByBalance() {
        return byBalance;
    }

    public static Comparator<Account> getByClientId() {
        return byClientId;
    }

    public void deposit(double cash) {
        BigDecimal previousBalance = balance;
        if (balance.multiply(balance.add(new BigDecimal(cash))).compareTo(new BigDecimal(0)) < 0)
            toggleStatus();
        if (cash > 0)
            balance = balance.add(new BigDecimal(cash));
        else throw new IllegalArgumentException("You can deposit only positive amount! ");
        client.updateBalance();
    }

    public BigDecimal withdraw(double cash) {

        if (balance.compareTo(new BigDecimal(cash)) >= 0) {
            balance = balance.subtract(new BigDecimal(cash));
            client.updateBalance();
            return new BigDecimal(cash);
        } else {
            throw new IllegalArgumentException("No cash on balance!");
        }
    }

    public BigDecimal credit(double cash) {
        int limit = 500;
        BigDecimal credit = balance.subtract(new BigDecimal(cash));

        if (credit.compareTo(new BigDecimal(-2*limit)) < 0)
            throw new IllegalArgumentException("You can't exceed 2x limits!");
        else if (credit.compareTo(new BigDecimal(-limit)) < 0) {
            status = AccountStatus.BLOCKED;
            System.out.println("Your current account has been blocked due to limit overhead!");
        }
        balance = balance.subtract(new BigDecimal(cash));
        client.updateBalance();
        return new BigDecimal(cash);
    }

    @Override
    public String toString() {
        return "Account{" +
                "status=" + status +
                ", id=" + id +
                ", client=" + client +
                ", balance=" + balance +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(id, ((Account) o).id);
    }
}
