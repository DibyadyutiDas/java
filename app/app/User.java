package app.app;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User implements Serializable {
    private final String username;
    private final String password;
    private final Map<String, Account> accounts; // Stores multiple accounts with unique account numbers

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.accounts = new HashMap<>();
        // Create a default account for the user upon registration
        String defaultAccountNumber = generateAccountNumber();
        this.accounts.put(defaultAccountNumber, new Account(defaultAccountNumber));
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public boolean addAccount() {
        String newAccountNumber = generateAccountNumber();
        if (!accounts.containsKey(newAccountNumber)) {
            accounts.put(newAccountNumber, new Account(newAccountNumber));
            return true;
        }
        return false;
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    private String generateAccountNumber() {
        return "ACC-" + System.currentTimeMillis(); // Simple account number generator
    }

    // Nested Account class to manage individual account operations
    public static class Account implements Serializable {
        private final String accountNumber;
        private double balance;
        private final List<String> transactionHistory;

        public Account(String accountNumber) {
            this.accountNumber = accountNumber;
            this.balance = 0.0;
            this.transactionHistory = new ArrayList<>();
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            balance += amount;
            String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            transactionHistory.add("Deposited: ₹" + amount + " on " + dateTime);
        }

        public void withdraw(double amount) {
            if (amount > balance) {
                throw new IllegalArgumentException("Insufficient funds.");
            }
            balance -= amount;
            String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            transactionHistory.add("Withdrew: ₹" + amount + " on " + dateTime);
        }

        public List<String> getTransactionHistory() {
            return transactionHistory;
        }
    }
}
