package controller;

import model.BankAccountManager;
import model.CheckingAccount;
import model.SavingsAccount;
import view.BankAccountView;
import model.BankAccount;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BankAccountController {
    private BankAccountManager manager;
    private BankAccountView view;

    public BankAccountController(BankAccountManager manager, BankAccountView view) {
        this.manager = manager;
        this.view = view;
    }

    public void start() {
        int choice;
        do {
            choice = view.getMenuChoice();
            switch (choice) {
                case 1:
                    addAccount();
                    break;
                case 2:
                    deleteAccount();
                    break;
                case 3:
                    viewAccounts();
                    break;
                case 4:
                    searchAccount();
                    break;
                case 5:
                    view.displayMessage("Exiting program.");
                    break;
                default:
                    view.displayMessage("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);
        view.close();
    }

    private void addAccount() {
        String id = manager.generateNextId();
        String number = view.getInput("Enter Account Number: ");
        String holderName = view.getValidAccountHolderName("Enter Account Holder Name: ");
        Date creationDate;
        try {
            creationDate = new SimpleDateFormat("yyyy-MM-dd").parse(view.getValidDate("Enter Creation Date (yyyy-MM-dd): "));
        } catch (ParseException e) {
            view.displayMessage("Invalid date format.");
            return;
        }

        int accountType = view.getValidInt("Select Account Type (1 for Savings, 2 for Checking): ");

        if (accountType == 1) {
            double balance = view.getValidDouble("Enter Savings Balance: ");
            double rate = view.getValidDouble("Enter Interest Rate: ");
            int term = view.getValidInt("Enter Term (months): ");
            Date startDate;
            try {
                startDate = new SimpleDateFormat("yyyy-MM-dd").parse(view.getValidDate("Enter Savings Start Date (yyyy-MM-dd): "));
            } catch (ParseException e) {
                view.displayMessage("Invalid date format.");
                return;
            }

            SavingsAccount savingsAccount = new SavingsAccount(id, number, holderName, creationDate, balance, startDate, rate, term);
            manager.addAccount(savingsAccount);

        } else if (accountType == 2) {
            String cardNumber = view.getValidCardNumber("Enter Card Number: ");
            double balance = view.getValidDouble("Enter Account Balance: ");

            CheckingAccount checkingAccount = new CheckingAccount(id, number, holderName, creationDate, cardNumber, balance);
            manager.addAccount(checkingAccount);
        } else {
            view.displayMessage("Invalid account type.");
        }
    }

    private void deleteAccount() {
        String accountId = view.getInput("Enter Account ID to delete: ");
        BankAccount account = manager.searchAccount(accountId);
        if (account != null) {
            view.displayAccount(account);
            String confirmation = view.getInput("Are you sure you want to delete this account? (yes/no): ").toLowerCase();
            if (confirmation.equals("yes")) {
                manager.deleteAccount(accountId);
                view.displayMessage("Account deleted successfully.");
                viewAccounts();
            } else {
                view.displayMessage("Account deletion canceled.");
            }
        } else {
            view.displayMessage("Account not found.");
        }
    }

    private void viewAccounts() {
        view.displayMessage("List of Bank Accounts:");
        for (BankAccount account : manager.getAccounts()) {
            view.displayAccount(account);
        }
    }

    private void searchAccount() {
        String accountId = view.getInput("Enter Account ID to search: ");
        BankAccount account = manager.searchAccount(accountId);
        if (account != null) {
            view.displayAccount(account);
        } else {
            view.displayMessage("Account not found.");
        }
    }

}
