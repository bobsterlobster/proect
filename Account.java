package Practika;

public class Account {
    private String accountId;
    private String accountHolder;
    private double balance;
    private String accountType;
    private boolean isActive;

    public Account(String accountId, String accountHolder, double balance, String accountType, boolean isActive) {
        this.accountId = accountId;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.accountType = accountType;
        this.isActive = isActive;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", accountHolder='" + accountHolder + '\'' +
                ", balance=" + balance +
                ", accountType='" + accountType + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}