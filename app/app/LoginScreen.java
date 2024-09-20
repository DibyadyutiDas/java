package app.app;
import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class LoginScreen {
    public static void showLoginScreen() {
        JFrame frame = new JFrame("Bank Application - Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridBagLayout());

        JLabel welcomeLabel = new JLabel("Welcome to the Bank ATM");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        frame.add(welcomeLabel, gbc);

        JButton newAccountButton = new JButton("Create New Account");
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(newAccountButton, gbc);

        JButton loginButton = new JButton("Login");
        gbc.gridy = 2;
        frame.add(loginButton, gbc);

        newAccountButton.addActionListener(e -> {
            frame.dispose();
            NewAccountScreen.showNewAccountScreen();
        });

        loginButton.addActionListener(e -> {
            frame.dispose();
            LoginForm.showLoginForm();
        });

        frame.setVisible(true);
    }
}
