package app.app;
import javax.swing.*;

public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Load user data
            BankData.loadUserData();

            // Start the application with a login screen
            LoginScreen.showLoginScreen();
        });
    }
}