import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;

public class bank {
    private static final String DATA_FILE = "bank_data.ser";
    private static Map<String, User> users = new HashMap<>();
    private static User currentUser;

    // Define custom colors
    private static final Color PRIMARY_COLOR = new Color(25, 118, 210);
    private static final Color SECONDARY_COLOR = new Color(245, 245, 245);
    private static final Color ACCENT_COLOR = new Color(33, 150, 243);
    private static final Color TEXT_COLOR = new Color(33, 33, 33);
    private static final Color SUCCESS_COLOR = new Color(76, 175, 80);
    private static final Color ERROR_COLOR = new Color(244, 67, 54);

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            loadUserData();
            showLoginScreen();
        });
    }

    private static void showLoginScreen() {
        JFrame frame = new JFrame("Modern Banking System - Welcome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setMinimumSize(new Dimension(500, 400));
        frame.setLayout(new BorderLayout());

        // Create main panel with padding
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 0, 10, 0);

        // Welcome text
        JLabel titleLabel = new JLabel("Welcome to Modern Banking");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(PRIMARY_COLOR);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLabel, gbc);

        JLabel subtitleLabel = new JLabel("Please choose an option to continue");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitleLabel.setForeground(TEXT_COLOR);
        subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.insets = new Insets(0, 0, 30, 0);
        mainPanel.add(subtitleLabel, gbc);

        // Buttons
        JButton newAccountButton = createStyledButton("Create New Account", PRIMARY_COLOR);
        gbc.insets = new Insets(10, 0, 10, 0);
        mainPanel.add(newAccountButton, gbc);

        JButton loginButton = createStyledButton("Login to Existing Account", ACCENT_COLOR);
        mainPanel.add(loginButton, gbc);

        frame.add(mainPanel, BorderLayout.CENTER);

        newAccountButton.addActionListener(e -> {
            frame.dispose();
            showNewAccountScreen();
        });

        loginButton.addActionListener(e -> {
            frame.dispose();
            showLoginForm();
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void showNewAccountScreen() {
        JFrame frame = new JFrame("Modern Banking System - Create Account");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setMinimumSize(new Dimension(500, 400));
        frame.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        // Title
        JLabel titleLabel = new JLabel("Create New Account");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(PRIMARY_COLOR);
        mainPanel.add(titleLabel, gbc);

        // Subtitle
        JLabel subtitleLabel = new JLabel("Please fill in your details");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitleLabel.setForeground(TEXT_COLOR);
        gbc.insets = new Insets(0, 0, 20, 0);
        mainPanel.add(subtitleLabel, gbc);

        // Form fields
        JTextField usernameField = createStyledTextField("Username");
        JPasswordField passwordField = createStyledPasswordField("Password");

        gbc.insets = new Insets(10, 0, 5, 0);
        mainPanel.add(usernameField, gbc);
        mainPanel.add(passwordField, gbc);

        JButton createButton = createStyledButton("Create Account", PRIMARY_COLOR);
        gbc.insets = new Insets(20, 0, 10, 0);
        mainPanel.add(createButton, gbc);

        JLabel statusLabel = new JLabel(" ");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        mainPanel.add(statusLabel, gbc);

        JButton backButton = createStyledButton("Back to Welcome", Color.GRAY);
        gbc.insets = new Insets(10, 0, 0, 0);
        mainPanel.add(backButton, gbc);

        frame.add(mainPanel, BorderLayout.CENTER);

        createButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            if (username.isEmpty() || password.isEmpty()) {
                statusLabel.setText("Username and password cannot be empty");
                statusLabel.setForeground(ERROR_COLOR);
            } else if (users.containsKey(username)) {
                statusLabel.setText("Username already exists");
                statusLabel.setForeground(ERROR_COLOR);
            } else {
                // Generate a numeric account number
                String accountNumber = String.valueOf(100000 + new Random().nextInt(900000));
                User newUser = new User(username, password, accountNumber);
                users.put(username, newUser);
                saveUserData();
                frame.dispose();
                showLoginScreen();
            }
        });

        backButton.addActionListener(e -> {
            frame.dispose();
            showLoginScreen();
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void showLoginForm() {
        JFrame frame = new JFrame("Modern Banking System - Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setMinimumSize(new Dimension(500, 400));
        frame.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(5, 0, 5, 0);

        // Title
        JLabel titleLabel = new JLabel("Login to Your Account");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(PRIMARY_COLOR);
        mainPanel.add(titleLabel, gbc);

        // Subtitle
        JLabel subtitleLabel = new JLabel("Please enter your credentials");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitleLabel.setForeground(TEXT_COLOR);
        gbc.insets = new Insets(0, 0, 20, 0);
        mainPanel.add(subtitleLabel, gbc);

        // Form fields
        JTextField usernameField = createStyledTextField("Username");
        JPasswordField passwordField = createStyledPasswordField("Password");

        gbc.insets = new Insets(10, 0, 5, 0);
        mainPanel.add(usernameField, gbc);
        mainPanel.add(passwordField, gbc);

        JButton loginButton = createStyledButton("Login", PRIMARY_COLOR);
        gbc.insets = new Insets(20, 0, 10, 0);
        mainPanel.add(loginButton, gbc);

        JLabel statusLabel = new JLabel(" ");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        mainPanel.add(statusLabel, gbc);

        JButton backButton = createStyledButton("Back to Welcome", Color.GRAY);
        gbc.insets = new Insets(10, 0, 0, 0);
        mainPanel.add(backButton, gbc);

        frame.add(mainPanel, BorderLayout.CENTER);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            if (authenticateUser(username, password)) {
                frame.dispose();
                showMainScreen();
            } else {
                statusLabel.setText("Invalid username or password");
                statusLabel.setForeground(ERROR_COLOR);
            }
        });

        backButton.addActionListener(e -> {
            frame.dispose();
            showLoginScreen();
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void showMainScreen() {
        JFrame frame = new JFrame("Modern Banking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setMinimumSize(new Dimension(800, 500));
        frame.setLayout(new BorderLayout(0, 0));

        // Header
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(PRIMARY_COLOR);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        
        JLabel headerLabel = new JLabel("Welcome, " + currentUser.getUsername());
        headerLabel.setFont(new Font("Arial", Font.BOLD, 22));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel, BorderLayout.WEST);
        
        JLabel timeLabel = new JLabel(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        headerPanel.add(timeLabel, BorderLayout.EAST);
        
        frame.add(headerPanel, BorderLayout.NORTH);

        // Main container with sidebar and content
        JPanel mainContainer = new JPanel(new BorderLayout(0, 0));
        frame.add(mainContainer, BorderLayout.CENTER);

        // Sidebar
        JPanel sidebar = createSidebar(frame);
        mainContainer.add(sidebar, BorderLayout.WEST);

        // Main content area with card layout
        JPanel contentPanel = new JPanel(new CardLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPanel.setBackground(SECONDARY_COLOR);
        mainContainer.add(contentPanel, BorderLayout.CENTER);

        // Add panels to card layout
        contentPanel.add(createAccountPanel(frame), "Account");
        contentPanel.add(createAccountInfoPanel(), "AccountInfo");
        contentPanel.add(createHistoryPanel(), "History");
        contentPanel.add(createTransferPanel(frame), "Transfer");

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JPanel createSidebar(JFrame frame) {
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(Color.WHITE);
        sidebar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(224, 224, 224)));
        sidebar.setPreferredSize(new Dimension(200, 0));

        String[] buttonLabels = {
            "Account Overview",
            "Account Info",
            "Transaction History",
            "Transfer Money",
            "Logout"
        };

        String[] commands = {
            "Account",
            "AccountInfo",
            "History",
            "Transfer",
            "Logout"
        };

        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = createSidebarButton(buttonLabels[i], commands[i]);

            if (commands[i].equals("Logout")) {
                sidebar.add(Box.createVerticalGlue());
                button.addActionListener(e -> {
                    frame.dispose();
                    showLoginScreen();
                });
            } else {
                final String cardName = commands[i];
                button.addActionListener(e -> 
                    switchToPanel((JPanel)((JPanel)frame.getContentPane()
                        .getComponent(1)).getComponent(1), cardName));
            }

            sidebar.add(button);
            sidebar.add(Box.createVerticalStrut(10));
        }

        sidebar.add(Box.createVerticalStrut(20));

        return sidebar;
    }

    private static JButton createSidebarButton(String text, String command) {
        JButton button = new JButton(text);
        button.setActionCommand(command);
        button.setMaximumSize(new Dimension(180, 40));
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setForeground(TEXT_COLOR);
        button.setBackground(Color.WHITE);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(SECONDARY_COLOR);
            }
            public void mouseExited(MouseEvent evt) {
                button.setBackground(Color.WHITE);
            }
        });
        
        return button;
    }

    private static JPanel createAccountPanel(JFrame frame) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);

        // Balance Card
        JPanel balanceCard = new JPanel(new GridBagLayout());
        balanceCard.setBackground(PRIMARY_COLOR);
        balanceCard.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JLabel balanceTitle = new JLabel("Current Balance");
        balanceTitle.setFont(new Font("Arial", Font.PLAIN, 16));
        balanceTitle.setForeground(Color.WHITE);

        JLabel balanceLabel = new JLabel("₹" + String.format("%,.2f", currentUser.getBalance()));
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 32));
        balanceLabel.setForeground(Color.WHITE);

        GridBagConstraints cardGbc = new GridBagConstraints();
        cardGbc.gridx = 0;
        cardGbc.gridy = 0;
        cardGbc.anchor = GridBagConstraints.CENTER;
        balanceCard.add(balanceTitle, cardGbc);

        cardGbc.gridy = 1;
        cardGbc.insets = new Insets(10, 0, 0, 0);
        balanceCard.add(balanceLabel, cardGbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(balanceCard, gbc);

        // Action Buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        buttonPanel.setBackground(Color.WHITE);

        JButton depositButton = createActionButton("Deposit Money", SUCCESS_COLOR);
        JButton withdrawButton = createActionButton("Withdraw Money", ACCENT_COLOR);

        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);

        gbc.gridy = 1;
        gbc.insets = new Insets(30, 20, 20, 20);
        panel.add(buttonPanel, gbc);

        depositButton.addActionListener(e -> handleDeposit(frame, balanceLabel));
        withdrawButton.addActionListener(e -> handleWithdraw(frame, balanceLabel));

        return panel;
    }

    private static JPanel createAccountInfoPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);

        // Account Info Card
        JPanel accountInfoCard = new JPanel(new GridBagLayout());
        accountInfoCard.setBackground(PRIMARY_COLOR);
        accountInfoCard.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JLabel accountInfoTitle = new JLabel("Account Information");
        accountInfoTitle.setFont(new Font("Arial", Font.PLAIN, 16));
        accountInfoTitle.setForeground(Color.WHITE);

        JLabel accountNumberLabel = new JLabel("Account Number: " + currentUser.getAccountNumber());
        accountNumberLabel.setFont(new Font("Arial", Font.BOLD, 18));
        accountNumberLabel.setForeground(Color.WHITE);

        JLabel accountCreationDateLabel = new JLabel("Created On: " + currentUser.getAccountCreationDate());
        accountCreationDateLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        accountCreationDateLabel.setForeground(Color.WHITE);

        GridBagConstraints cardGbc = new GridBagConstraints();
        cardGbc.gridx = 0;
        cardGbc.gridy = 0;
        cardGbc.anchor = GridBagConstraints.CENTER;
        accountInfoCard.add(accountInfoTitle, cardGbc);

        cardGbc.gridy = 1;
        cardGbc.insets = new Insets(10, 0, 0, 0);
        accountInfoCard.add(accountNumberLabel, cardGbc);

        cardGbc.gridy = 2;
        cardGbc.insets = new Insets(5, 0, 0, 0);
        accountInfoCard.add(accountCreationDateLabel, cardGbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(accountInfoCard, gbc);

        return panel;
    }

    private static JPanel createHistoryPanel() {
        JPanel panel = new JPanel(new BorderLayout(0, 20));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Transaction History");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(TEXT_COLOR);
        panel.add(titleLabel, BorderLayout.NORTH);

        JList<String> historyList = new JList<>(currentUser.getTransactionHistory().toArray(new String[0]));
        historyList.setFont(new Font("Arial", Font.PLAIN, 14));
        historyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        historyList.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JScrollPane scrollPane = new JScrollPane(historyList);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(224, 224, 224)));
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private static JPanel createTransferPanel(JFrame frame) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        JLabel titleLabel = new JLabel("Transfer Money");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(TEXT_COLOR);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        // Form fields
        JLabel accountNumberLabel = new JLabel("Recipient Account Number");
        accountNumberLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(30, 10, 5, 10);
        panel.add(accountNumberLabel, gbc);

        JTextField accountNumberField = createStyledTextField("");
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 10, 20, 10);
        panel.add(accountNumberField, gbc);

        JLabel amountLabel = new JLabel("Amount");
        amountLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 10, 5, 10);
        panel.add(amountLabel, gbc);

        JTextField amountField = createStyledTextField("");
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 10, 20, 10);
        panel.add(amountField, gbc);

        JButton transferButton = createActionButton("Transfer Now", ACCENT_COLOR);
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(transferButton, gbc);

        JLabel statusLabel = new JLabel(" ");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 6;
        gbc.insets = new Insets(20, 10, 10, 10);
        panel.add(statusLabel, gbc);

        transferButton.addActionListener(e -> handleTransfer(frame, accountNumberField, amountField, statusLabel));

        return panel;
    }

    private static JTextField createStyledTextField(String placeholder) {
        JTextField field = new JTextField(20);
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(224, 224, 224)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        return field;
    }

    private static JPasswordField createStyledPasswordField(String placeholder) {
        JPasswordField field = new JPasswordField(20);
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(224, 224, 224)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        return field;
    }

    private static JButton createStyledButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(color.darker());
            }
            public void mouseExited(MouseEvent evt) {
                button.setBackground(color);
            }
        });
        
        return button;
    }

    private static JButton createActionButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(color.darker());
            }

            public void mouseExited(MouseEvent evt) {
                button.setBackground(color);
            }
        });

        return button;
    }

    private static void handleDeposit(JFrame frame, JLabel balanceLabel) {
        String amountStr = JOptionPane.showInputDialog(frame, "Enter amount to deposit:");
        try {
            double amount = Double.parseDouble(amountStr);
            if (amount > 0) {
                currentUser.deposit(amount);
                balanceLabel.setText("₹" + String.format("%,.2f", currentUser.getBalance()));
                saveUserData();
                JOptionPane.showMessageDialog(frame, 
                    "Successfully deposited ₹" + String.format("%,.2f", amount), 
                    "Success", 
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, 
                    "Please enter a positive amount.", 
                    "Invalid Input", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, 
                "Please enter a valid amount.", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void handleWithdraw(JFrame frame, JLabel balanceLabel) {
        String amountStr = JOptionPane.showInputDialog(frame, "Enter amount to withdraw:");
        try {
            double amount = Double.parseDouble(amountStr);
            if (amount > 0 && amount <= currentUser.getBalance()) {
                currentUser.withdraw(amount);
                balanceLabel.setText("₹" + String.format("%,.2f", currentUser.getBalance()));
                saveUserData();
                JOptionPane.showMessageDialog(frame, 
                    "Successfully withdrawn ₹" + String.format("%,.2f", amount), 
                    "Success", 
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, 
                    "Invalid amount or insufficient funds.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, 
                "Please enter a valid amount.", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void handleTransfer(JFrame frame, JTextField accountNumberField, JTextField amountField, JLabel statusLabel) {
        String recipientAccountNumber = accountNumberField.getText().trim();
        String amountStr = amountField.getText().trim();

        try {
            double amount = Double.parseDouble(amountStr);
            if (amount > 0 && amount <= currentUser.getBalance()) {
                User recipient = findUserByAccountNumber(recipientAccountNumber);
                if (recipient != null) {
                    currentUser.withdraw(amount);
                    recipient.deposit(amount);
                    saveUserData();
                    statusLabel.setText("Transfer successful!");
                    statusLabel.setForeground(SUCCESS_COLOR);
                    accountNumberField.setText("");
                    amountField.setText("");
                } else {
                    statusLabel.setText("Recipient account not found.");
                    statusLabel.setForeground(ERROR_COLOR);
                }
            } else {
                statusLabel.setText("Invalid amount or insufficient funds.");
                statusLabel.setForeground(ERROR_COLOR);
            }
        } catch (NumberFormatException ex) {
            statusLabel.setText("Please enter a valid amount.");
            statusLabel.setForeground(ERROR_COLOR);
        }
    }

    private static boolean authenticateUser(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            currentUser = user;
            return true;
        }
        return false;
    }

    private static User findUserByAccountNumber(String accountNumber) {
        return users.values().stream()
                .filter(user -> user.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElse(null);
    }

    private static void switchToPanel(JPanel contentPanel, String panelName) {
        CardLayout cl = (CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, panelName);
    }

    private static void loadUserData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            users = (Map<String, User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            users = new HashMap<>();
        }
    }

    private static void saveUserData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class User implements Serializable {
        private final String username;
        private final String password;
        private final String accountNumber;
        private double balance;
        private final String accountCreationDate; // New field
        private final List<String> transactionHistory;

        public User(String username, String password, String accountNumber) {
            this.username = username;
            this.password = password;
            this.accountNumber = accountNumber;
            this.balance = 0.0;
            this.accountCreationDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            this.transactionHistory = new ArrayList<>();
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public double getBalance() {
            return balance;
        }

        public String getAccountCreationDate() {
            return accountCreationDate;
        }

        public void deposit(double amount) {
            balance += amount;
            String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            transactionHistory.add("Deposited: ₹" + String.format("%,.2f", amount) + " on " + dateTime);
        }

        public void withdraw(double amount) {
            balance -= amount;
            String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            transactionHistory.add("Withdrew: ₹" + String.format("%,.2f", amount) + " on " + dateTime);
        }

        public List<String> getTransactionHistory() {
            return transactionHistory;
        }
    }
}