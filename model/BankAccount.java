package model;

import java.util.Date;

public class BankAccount {
    private String accountId;
    private String accountNumber;
    private String accountHolderName;
    private Date creationDate;

    public BankAccount(String accountId, String accountNumber, String accountHolderName, Date creationDate) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.creationDate = creationDate;
    }

    public BankAccount() {
    }

    // Getter và Setter
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Account ID: " + accountId + ", Account Number: " + accountNumber +
                ", Account Holder: " + accountHolderName + ", Creation Date: " + creationDate;
    }
}

