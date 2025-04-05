package entities;

import services.Account;


public class CurrentAccount extends Account {
    public CurrentAccount(Client client) {
        super(client);
    }

    public CurrentAccount() {
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalStateException("Deposit invalid. The amount must be greater than zero");
        }
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (balance < amount && amount <= 0) {
            throw new IllegalStateException("Withdraw has failed");
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
