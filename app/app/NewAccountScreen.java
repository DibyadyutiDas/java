package app.app;
import javax.swing.*;
import java.awt.*;
import java.util.UUID;

public class NewAccountScreen {
    public static void showNewAccountScreen() {
        JFrame frame = new JFrame("Bank Application - Create New Account");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridBagLayout());

        JLabel usernameLabel = new JLabel("Username:");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        frame.add(usernameLabel, gbc);

        JTextField usernameField = new JTextField(15);
        gbc.gridx = 1;
        frame.add(usernameField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        frame.add(passwordField, gbc);

        JButton createButton = new JButton("Create Account");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(createButton, gbc);

        JLabel statusLabel = new JLabel(" ");
        gbc.gridy = 3;
        frame.add(statusLabel, gbc);

        createButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            if (username.isEmpty() || password.isEmpty()) {
                statusLabel.setText("Username and password cannot be empty.");
                statusLabel.setForeground(Color.RED);
            } else if (BankData.getUsers().containsKey(username)) {
                statusLabel.setText("Username already exists.");
                statusLabel.setForeground(Color.RED);
            } else {
                String accountNumber = UUID.randomUUID().toString();
                User newUser = new User(username, password, accountNumber);
                BankData.getUsers().put(username, newUser);
                BankData.saveUserData();
                frame.dispose();
                LoginScreen.showLoginScreen();
            }
        });

        frame.setVisible(true);
    }
}
