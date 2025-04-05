package services;

import entities.Client;
import entities.Installment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Account implements ServiceAccount{
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static int sequential = 1000;
    protected int accountNumber;
    protected double balance;

    private Client client;

    List<Installment> installments = new ArrayList<>();

    public List<Installment> getInstallments() {
        return installments;
    }

    public Account() {
    }

    public Account(Client client) {

        this.accountNumber = sequential++;
        this.balance = balance;
        this.client = client;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Client getClient() {
        return client;
    }

    public void payBill(double amount) {
        this.withdraw(amount);
    }

    public void payInInstallment(double amount, int months) {
        double eachInstallment = amount/ months;
        this.withdraw(eachInstallment);

        System.out.println("Installment payment date:");
        for (int i = 0; i < months; i++){
            LocalDate dueDate = LocalDate.now().plusMonths(i);
            getInstallments().add(new Installment(dueDate, eachInstallment));
            System.out.println(dueDate.format(fmt) + " - " + String.format("%.2f", eachInstallment));
        }
    }

    public void printStatementBank() {
        System.out.println(getClient()
                + "Account Number: " +accountNumber
                + ", Balance: " + String.format("%.2f", balance));

    }
}
