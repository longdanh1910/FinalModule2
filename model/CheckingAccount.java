package model;

import java.util.Date;

public class CheckingAccount extends BankAccount {


    private String cardNumber;
    private double balance;

    public CheckingAccount(String accountId, String accountNumber, String accountHolderName, Date creationDate, String cardNumber, double balance) {
        super(accountId, accountNumber, accountHolderName, creationDate);
        this.cardNumber = cardNumber;
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return super.toString() + ", Card Number: " + cardNumber + ", Balance: " + balance;
    }
}

