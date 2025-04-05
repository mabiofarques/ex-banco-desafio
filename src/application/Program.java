package application;


import entities.Bank;
import entities.Client;
import entities.CurrentAccount;
import entities.SavingsAccount;
import services.Account;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Bank bank = new Bank();
        try {
            do {
                System.out.println("---------------------------");
                System.out.println("BANK SYSTEM");
                System.out.println("1. Create CurrentAccount");
                System.out.println("2. Create Savings Account");
                System.out.println("3. Show customer data");
                System.out.println("4. Consult balance");
                System.out.println("5. Deposit");
                System.out.println("6. Withdraw");
                System.out.println("7. Transfer");
                System.out.println("8. Pay bill");
                System.out.println("9. Delete account");
                System.out.println("10. Show clients");
                System.out.println("11. Exit system");
                System.out.println("---------------------------");

                System.out.print("Enter the option: ");
                int option = sc.nextInt();
                sc.nextLine();

                if (option == 1) {
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.print("Birthdate(dd/MM/yyyy): ");
                    LocalDate birthdate = LocalDate.parse(sc.nextLine(), fmt);
                    System.out.print("Enter your occupation(or type student): ");
                    String occupation = sc.nextLine();
                    Client client = new Client(name, birthdate, occupation);
                    Account account = new CurrentAccount(client);
                    bank.addNewAccount(account);
                    System.out.println("---------------------------");
                    System.out.println("Current Account created successfully!");
                    account.printStatementBank();
                }
                if (option == 2) {
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.print("Birthdate(dd/MM/yyyy): ");
                    LocalDate birthdate = LocalDate.parse(sc.nextLine(), fmt);
                    System.out.print("Enter your occupation(or type student): ");
                    String occupation = sc.nextLine();
                    Client client = new Client(name, birthdate, occupation);
                    Account account = new SavingsAccount(client);
                    bank.addNewAccount(account);
                    System.out.println("---------------------------");
                    System.out.println("Savings Account created successfully!");
                    account.printStatementBank();
                }
                if (option == 3) {
                    System.out.print("Enter your account number: ");
                    int accountNumber = sc.nextInt();
                    System.out.println("---------------------------");
                    bank.searchAccountByAccountNumber(accountNumber);
                }
                if (option == 4) {
                    System.out.print("Enter your account number to consult balance: ");
                    int accountNumber = sc.nextInt();
                    System.out.println("---------------------------");
                    bank.getBalanceByAccountNumber(accountNumber);
                }
                if (option == 5) {
                    System.out.print("Enter your account number to make a deposit: ");
                    int accountNumber = sc.nextInt();
                    System.out.print("Enter the amount you want to deposit: ");
                    double amount = sc.nextDouble();
                    bank.depositByAccountNumber(accountNumber, amount);
                }
                if (option == 6) {
                    System.out.print("Enter your account number to make a withdraw: ");
                    int accountNumber = sc.nextInt();
                    System.out.print("Enter the amount you want to withdraw: ");
                    double amount = sc.nextDouble();
                    bank.withdrawByAccountNumber(accountNumber, amount);
                }
                if (option == 7) {
                    System.out.print("Enter your account number to make a transfer: ");
                    int accountNumber = sc.nextInt();
                    System.out.print("Now, enter the target account number: ");
                    int targetAccount = sc.nextInt();
                    System.out.print("Enter the amount you want to transfer: ");
                    double amount = sc.nextDouble();
                    bank.transferByAccountNumber(accountNumber, targetAccount, amount);
                }
                if (option == 8) {
                    System.out.print("Enter current account number to pay bill: ");
                    int accountNumber = sc.nextInt();
                    System.out.print("Enter the amount to pay: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Would you like to pay this amount in installments(yes/no)? ");
                    String response = sc.nextLine();

                    if (response.equalsIgnoreCase("yes")) {
                        System.out.print("How many installments do you want to pay in? ");
                        int months = sc.nextInt();
                        bank.payInstallmentsByAccountNumber(accountNumber, amount, months);
                        System.out.println("---------------------------");
                        System.out.println("Installment made successfully");
                    }
                    else {
                        bank.payBillByAccountNumber(accountNumber, amount);
                        System.out.println("---------------------------");
                        System.out.println("Payment made successfully!");
                    }

                }
                if (option == 9) {
                    System.out.println("DELETE ACCOUNT ZONE:");
                    System.out.print("Enter account number to delete: ");
                    int accountNumber = sc.nextInt();
                    bank.removeAccount(accountNumber);
                    System.out.println("---------------------------");
                    System.out.println("Account number deleted!");
                    System.out.println("Thank you for being our customer!");
                }
                if (option == 10) {
                    bank.showAccounts();
                }
                if (option == 11) {
                    break;
                }

            } while (true);

        }
        catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Closing bank system.");
            System.out.println("See you soon!");
            sc.close();
        }
    }
}
