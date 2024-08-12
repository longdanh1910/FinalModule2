package model;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BankAccountManager {
    private ArrayList<BankAccount> accounts;
    private static final String CSV_FILE = "data/bank_accounts.csv";

    public  BankAccountManager() {
        accounts = new ArrayList<>();
        loadAccountsFromCSV();
    }

    private void loadAccountsFromCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    String accountId = parts[0];
                    String accountNumber = parts[1];
                    String accountHolderName = parts[2];
                    Date creationDate = new SimpleDateFormat("yyyy-MM-dd").parse(parts[3]);

                    if (parts.length == 8) { // SavingsAccount
                        double savingsBalance = Double.parseDouble(parts[4]);
                        Date savingsStartDate = new SimpleDateFormat("yyyy-MM-dd").parse(parts[5]);
                        double interestRate = Double.parseDouble(parts[6]);
                        int term = Integer.parseInt(parts[7]);

                        accounts.add(new SavingsAccount(accountId, accountNumber, accountHolderName, creationDate, savingsBalance, savingsStartDate, interestRate, term));
                    } else if (parts.length == 6) { // CheckingAccount
                        String cardNumber = parts[4];
                        double balance = Double.parseDouble(parts[5]);

                        accounts.add(new CheckingAccount(accountId, accountNumber, accountHolderName, creationDate, cardNumber, balance));
                    }
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private void saveAccountsToCSV() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE))) {
            for (BankAccount account : accounts) {
                if (account instanceof SavingsAccount) {
                    SavingsAccount sa = (SavingsAccount) account;
                    writer.write(String.join(",",
                            sa.getAccountId(),
                            sa.getAccountNumber(),
                            sa.getAccountHolderName(),
                            new SimpleDateFormat("yyyy-MM-dd").format(sa.getCreationDate()),
                            String.valueOf(sa.getSavingsBalance()),
                            new SimpleDateFormat("yyyy-MM-dd").format(sa.getSavingsStartDate()),
                            String.valueOf(sa.getInterestRate()),
                            String.valueOf(sa.getTerm())
                    ));
                } else if (account instanceof CheckingAccount) {
                    CheckingAccount ca = (CheckingAccount) account;
                    writer.write(String.join(",",
                            ca.getAccountId(),
                            ca.getAccountNumber(),
                            ca.getAccountHolderName(),
                            new SimpleDateFormat("yyyy-MM-dd").format(ca.getCreationDate()),
                            ca.getCardNumber(),
                            String.valueOf(ca.getBalance())
                    ));
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
        saveAccountsToCSV();
    }

    public void deleteAccount(String accountId) {
        accounts.removeIf(account -> account.getAccountId().equals(accountId));
        saveAccountsToCSV();
    }

    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }

    public BankAccount searchAccount(String accountId) {
        for (BankAccount account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                return account;
            }
        }
        return null;
    }

    public String generateNextId() {
        int maxId = 0;
        for (BankAccount account : accounts) {
            try {
                int id = Integer.parseInt(account.getAccountId());
                if (id > maxId) {
                    maxId = id;
                }
            } catch (NumberFormatException e) {

            }
        }
        return String.valueOf(maxId + 1);
    }
}
