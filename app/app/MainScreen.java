package app.app;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MainScreen {
    private static User currentUser;
    private static Map<String, User> users;
    private static final String DATA_FILE = "userData.dat";
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
        loadUserData();
        showMainScreen();
    }

    private static void showMainScreen() {
        JFrame frame = new JFrame("Modern Banking Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setMinimumSize(new Dimension(800, 500));
        frame.setLayout(new BorderLayout(0, 0));

        // Header
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(PRIMARY_COLOR);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        
        JLabel headerLabel = createHeaderLabel();
        headerPanel.add(headerLabel, BorderLayout.WEST);
        
        JLabel timeLabel = new JLabel(java.time.LocalDate.now().toString());
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
        contentPanel.add(createHistoryPanel(), "History");
        contentPanel.add(createTransferPanel(frame), "Transfer");

        // Center the frame on screen
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JLabel createHeaderLabel() {
        JLabel headerLabel = new JLabel("Welcome, " + currentUser.getUsername());
        headerLabel.setFont(new Font("Arial", Font.BOLD, 22));
        headerLabel.setForeground(Color.WHITE);
        return headerLabel;
    }

    private static JPanel createSidebar(JFrame frame) {
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(Color.WHITE);
        sidebar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(224, 224, 224)));
        sidebar.setPreferredSize(new Dimension(200, 0));

        // Create custom button style
        JButton[] buttons = {
            createStyledButton("Account Overview", "Account"),
            createStyledButton("Transaction History", "History"),
            createStyledButton("Transfer Money", "Transfer"),
            createStyledButton("Logout", "Logout")
        };

        // Add padding at the top
        sidebar.add(Box.createVerticalStrut(20));

        // Add buttons to sidebar
        for (JButton button : buttons) {
            sidebar.add(button);
            sidebar.add(Box.createVerticalStrut(10));
            
            if (button.getText().equals("Logout")) {
                sidebar.add(Box.createVerticalGlue());
                button.addActionListener(e -> {
                    frame.dispose();
                    showLoginScreen();
                });
            } else {
                final String cardName = button.getActionCommand();
                button.addActionListener(e -> 
                    switchToPanel((JPanel)((JPanel)frame.getContentPane().getComponent(0))
                        .getComponent(1), cardName));
            }
        }

        // Add padding at the bottom
        sidebar.add(Box.createVerticalStrut(20));

        return sidebar;
    }

    private static JButton createStyledButton(String text, String command) {
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
        
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(SECONDARY_COLOR);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
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

        // Balance card
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

        // Action buttons
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

    private static JButton createActionButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(200, 50));
        
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(color.darker());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(color);
            }
        });
        
        return button;
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
        JLabel accountNumberLabel = new JLabel("Account Number");
        accountNumberLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(30, 10, 5, 10);
        panel.add(accountNumberLabel, gbc);

        JTextField accountNumberField = createStyledTextField();
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 10, 20, 10);
        panel.add(accountNumberField, gbc);

        JLabel amountLabel = new JLabel("Amount");
        amountLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 10, 5, 10);
        panel.add(amountLabel, gbc);

        JTextField amountField = createStyledTextField();
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

    private static JTextField createStyledTextField() {
        JTextField field = new JTextField(20);
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(224, 224, 224)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        return field;
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

    private static void showLoginScreen() {
        // Implementation for showing the login screen
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
}