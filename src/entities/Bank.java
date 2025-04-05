package entities;

import services.Account;

import javax.swing.colorchooser.AbstractColorChooserPanel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addNewAccount(Account account) {
        if (account == null) {
            throw new NullPointerException("Error");
        }
        accounts.add(account);
    }

    public void removeAccount(int accountNumber) {
        if (accounts.isEmpty()) {
            throw new RuntimeException("Theres no account to remove");
        }
        List<Account> accountToRemove = new ArrayList<>();
        for (Account a : accounts) {
            if (a.getAccountNumber() == accountNumber) {
                accountToRemove.add(a);
            }
        }
        accounts.removeAll(accountToRemove);
    }

    public void showAccounts() {
        if (accounts.isEmpty()) {
            throw new IllegalStateException("List of account not found");
        }
        for (Account a : accounts) {
            a.printStatementBank();
        }
    }

    public void searchAccountByAccountNumber (int targetAccount) {
        if(!accounts.isEmpty()) {
            for (Account x : accounts) {
                if (x.getAccountNumber() == targetAccount) {
                    x.printStatementBank();
                }
            }
        }
    }

    public void getBalanceByAccountNumber (int targetAccount) {
        if (accounts.isEmpty()) {
            throw new IllegalStateException("There is no balance to display as the customer list is empty!");
        }
        for (Account x : accounts) {
            if (x.getAccountNumber() == targetAccount) {
                System.out.println("Acoount number: " + x.getAccountNumber());
                System.out.println(x.getClient());
                System.out.println("Balance: $" + String.format("%.2f", x.getBalance()));
            }
        }
    }

    public void depositByAccountNumber (int targetAccount, double amount) {
        if (accounts.isEmpty()) {
            throw new IllegalStateException("Deposit invalid. Customer list is empty!");
        }
        for (Account x : accounts) {
            if (x.getAccountNumber() == targetAccount && amount > 0) {
                x.deposit(amount);
            }
        }
    }

    public void withdrawByAccountNumber (int targetAccount, double amount) {
        if (accounts.isEmpty()) {
            throw new IllegalStateException("Withdraw error. Customer list is empty!");
        }
        for (Account x : accounts) {
            if (x.getAccountNumber() == targetAccount && x.getBalance() > 0) {
                x.withdraw(amount);
            }
        }
    }

    public void transferByAccountNumber(int account, int targetAccount, double amount) {
        if (accounts.isEmpty()) {
            throw new IllegalStateException("Withdraw error. Customer list is empty!");
        }
        for (Account x : accounts) {
            if (x.getAccountNumber() == account && x.getBalance() > 0 && amount > 0) {
                x.withdraw(amount);
            }
        }
        for (Account x : accounts) {
            if (x.getAccountNumber() == targetAccount && amount > 0) {
                x.deposit(amount);
            }
        }
    }

    public void payBillByAccountNumber(int accountNumber, double amount) {
        for (Account x : accounts) {
            if (x.getAccountNumber() == accountNumber && amount > 0 && x.getBalance() >= amount) {
                x.payBill(amount);
            }
        }
    }

    public void payInstallmentsByAccountNumber(int accountNumber, double amount, int months) {
        for (Account x : accounts) {
            if (x.getAccountNumber() == accountNumber && amount > 0 && x.getBalance() >= amount) {
                x.payInInstallment(amount, months);
                break;
            }
        }
    }

}
