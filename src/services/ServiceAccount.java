package services;

import entities.Client;
import org.w3c.dom.ls.LSOutput;

public interface ServiceAccount {
    void deposit(double amount);
    void withdraw(double amount);
    void transfer(double amount, Account targetAccount);
    void printStatementBank();

}
