package entities;

import services.Account;

public class SavingsAccount extends Account {
    private double balance;

    public SavingsAccount(Client client) {
        super(client);
    }

    public SavingsAccount() {
    }

    @Override
    public double getBalance() {
        double incomeSavings = 1.02;
        return balance *= incomeSavings;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalStateException("Deposit failed. The amount must be greater than zero");
        }
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalStateException("Withdraw not allowed!");
        }
        if (amount > balance) {
            throw new IllegalStateException("Withdraw has failed. You do not have funds enough.");
        }
        balance -= amount;
    }

    @Override
    public void transfer(double amount, Account targetAccount) {
        if (targetAccount == null) {
            throw new IllegalStateException("Account not found");
        }
        if (balance <= 0) {
            throw new IllegalStateException("Transfer is not allowed. You do not have funds!");
        }
        this.withdraw(amount);
        targetAccount.deposit(amount);
    }


}
