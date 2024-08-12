package model;

import java.util.Date;

public class SavingsAccount extends BankAccount {
    private double savingsBalance;
    private Date savingsStartDate;
    private double interestRate;
    private int term;  // Kỳ hạn (ví dụ: 12 tháng, 24 tháng, v.v.)

    public SavingsAccount(String accountId, String accountNumber, String accountHolderName, Date creationDate, double savingsBalance, Date savingsStartDate, double interestRate, int term) {
        super(accountId, accountNumber, accountHolderName, creationDate);
        this.savingsBalance = savingsBalance;
        this.savingsStartDate = savingsStartDate;
        this.interestRate = interestRate;
        this.term = term;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public Date getSavingsStartDate() {
        return savingsStartDate;
    }

    public void setSavingsStartDate(Date savingsStartDate) {
        this.savingsStartDate = savingsStartDate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return super.toString() + ", Savings Balance: " + savingsBalance +
                ", Start Date: " + savingsStartDate + ", Interest Rate: " + interestRate + ", Term: " + term + " months";
    }
}

