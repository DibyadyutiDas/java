package app.app;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm {
    // Define custom colors to match main application theme
    private static final Color PRIMARY_COLOR = new Color(25, 118, 210);
    private static final Color SECONDARY_COLOR = new Color(245, 245, 245);
    private static final Color TEXT_COLOR = new Color(33, 33, 33);
    private static final Color ERROR_COLOR = new Color(244, 67, 54);

    public static void showLoginForm() {
        JFrame frame = new JFrame("Modern Banking System - Login");
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
        gbc.insets = new Insets(5, 0, 5, 0);

        // Welcome text
        JLabel titleLabel = new JLabel("Welcome Back");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(PRIMARY_COLOR);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLabel, gbc);

        JLabel subtitleLabel = new JLabel("Please login to your account");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitleLabel.setForeground(TEXT_COLOR);
        subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.insets = new Insets(0, 0, 20, 0);
        mainPanel.add(subtitleLabel, gbc);

        // Form fields
        JTextField usernameField = createStyledTextField("Username");
        JPasswordField passwordField = createStyledPasswordField();

        gbc.insets = new Insets(10, 0, 5, 0);
        mainPanel.add(new JLabel("Username"), gbc);
        mainPanel.add(usernameField, gbc);
        
        gbc.insets = new Insets(15, 0, 5, 0);
        mainPanel.add(new JLabel("Password"), gbc);
        mainPanel.add(passwordField, gbc);

        // Login button
        JButton loginButton = createStyledButton("Login", PRIMARY_COLOR);
        gbc.insets = new Insets(25, 0, 10, 0);
        mainPanel.add(loginButton, gbc);

        // Status label for error messages
        JLabel statusLabel = new JLabel(" ");
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        mainPanel.add(statusLabel, gbc);

        // Back to welcome button
        JButton backButton = createStyledButton("Back to Welcome", Color.GRAY);
        gbc.insets = new Insets(10, 0, 0, 0);
        mainPanel.add(backButton, gbc);

        frame.add(mainPanel, BorderLayout.CENTER);

        // Add action listeners
        loginButton.addActionListener(e -> handleLogin(frame, usernameField, passwordField, statusLabel));
        
        backButton.addActionListener(e -> {
            frame.dispose();
            MainScreen.showWelcomeScreen();
        });

        // Add key listener for Enter key
        KeyAdapter enterKeyListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    handleLogin(frame, usernameField, passwordField, statusLabel);
                }
            }
        };

        usernameField.addKeyListener(enterKeyListener);
        passwordField.addKeyListener(enterKeyListener);

        // Center on screen
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void handleLogin(JFrame frame, JTextField usernameField, 
                                  JPasswordField passwordField, JLabel statusLabel) {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            statusLabel.setText("Please enter both username and password");
            statusLabel.setForeground(ERROR_COLOR);
            return;
        }

        if (authenticateUser(username, password)) {
            frame.dispose();
            MainScreen.showMainScreen();
        } else {
            statusLabel.setText("Invalid username or password");
            statusLabel.setForeground(ERROR_COLOR);
            passwordField.setText("");
        }
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

    private static JPasswordField createStyledPasswordField() {
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

    private static boolean authenticateUser(String username, String password) {
        User user = BankData.getUsers().get(username);
        if (user != null && user.getPassword().equals(password)) {
            MainScreen.setCurrentUser(user);
            return true;
        }
        return false;
    }
}