package apps;

import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.platform.win32.User32;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.prefs.Preferences;
import java.util.*;
import java.util.prefs.Preferences;

public class AppLock {

    private static final Preferences prefs = Preferences.userRoot().node("AppLock");
    private static final String ENCRYPTION_KEY_PREF = "EncryptionKey";
    private static final String PIN_PREF = "EncryptedPin";

    private static List<String> lockedApps = new ArrayList<>(Arrays.asList("notepad.exe", "calc.exe"));
    private static Timer monitoringTimer;

    private static SecretKey encryptionKey;

    public static void main(String[] args) {
        loadEncryptionKey();
        SwingUtilities.invokeLater(AppLock::createMainWindow);
    }

    private static void createMainWindow() {
        JFrame frame = new JFrame("App Lock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JLabel infoLabel = new JLabel("Lock and monitor apps securely.");
        JPasswordField pinField = new JPasswordField();
        pinField.setEchoChar('*');
        JButton unlockButton = new JButton("Unlock with PIN");
        JButton settingsButton = new JButton("Settings");

        unlockButton.addActionListener(e -> verifyPin(new String(pinField.getPassword())));
        settingsButton.addActionListener(e -> openSettingsDialog());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.add(infoLabel);
        panel.add(pinField);
        panel.add(unlockButton);
        panel.add(settingsButton);

        frame.add(panel);
        monitoringTimer = new Timer();
        monitoringTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (String appName : lockedApps) {
                    if (isAppRunning(appName)) {
                        closeApp(appName);
                    }
                }
            }
        }, 0, 1000);

        startMonitoring();
    }

    private static void startMonitoring() {
        monitoringTimer = new Timer(1000, e -> {
            for (String appName : lockedApps) {
                if (isAppRunning(appName)) {
                    closeApp(appName);
                }
            }
        });
        monitoringTimer.start();
    }

    private static boolean isAppRunning(String appName) {
        HWND hwnd = User32.INSTANCE.GetForegroundWindow();
        char[] buffer = new char[512];
        User32.INSTANCE.GetWindowText(hwnd, buffer, 512);
        String windowTitle = Native.toString(buffer);
        return windowTitle.toLowerCase().contains(appName.toLowerCase());
    }

    private static void closeApp(String appName) {
        HWND hwnd = User32.INSTANCE.GetForegroundWindow();
        User32.INSTANCE.PostMessage(hwnd, WinUser.WM_CLOSE, null, null);
    }

    private static void verifyPin(String enteredPin) {
        String storedEncryptedPin = prefs.get(PIN_PREF, null);
        if (storedEncryptedPin == null) {
            savePin(enteredPin);
            JOptionPane.showMessageDialog(null, "PIN set successfully!");
        } else {
            String decryptedPin = decrypt(storedEncryptedPin);
            if (enteredPin.equals(decryptedPin)) {
                JOptionPane.showMessageDialog(null, "App Unlocked!");
                monitoringTimer.stop();
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect PIN!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void openSettingsDialog() {
        JFrame settingsFrame = new JFrame("Manage Locked Apps");
        settingsFrame.setSize(300, 400);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        lockedApps.forEach(listModel::addElement);
        JList<String> appList = new JList<>(listModel);

        JButton addButton = new JButton("Add App");
        JButton removeButton = new JButton("Remove Selected");

        addButton.addActionListener(e -> {
            String appName = JOptionPane.showInputDialog("Enter app name (e.g., notepad.exe):");
            if (appName != null && !appName.trim().isEmpty()) {
                lockedApps.add(appName);
                listModel.addElement(appName);
            }
        });

        removeButton.addActionListener(e -> {
            List<String> selectedApps = appList.getSelectedValuesList();
            lockedApps.removeAll(selectedApps);
            selectedApps.forEach(listModel::removeElement);
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(appList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        settingsFrame.add(panel);
        settingsFrame.setVisible(true);
    }

    private static void savePin(String pin) {
        String encryptedPin = encrypt(pin);
        prefs.put(PIN_PREF, encryptedPin);
    }

    private static void loadEncryptionKey() {
        String keyString = prefs.get(ENCRYPTION_KEY_PREF, null);
        if (keyString == null) {
            encryptionKey = generateKey();
            prefs.put(ENCRYPTION_KEY_PREF, Base64.encodeBase64String(encryptionKey.getEncoded()));
        } else {
            encryptionKey = new SecretKeySpec(Base64.decodeBase64(keyString), "AES");
        }
    }

    private static SecretKey generateKey() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            return keyGen.generateKey();
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate encryption key.", e);
        }
    }

    private static String encrypt(String data) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, encryptionKey);
            return Base64.encodeBase64String(cipher.doFinal(data.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException("Encryption failed.", e);
        }
    }

    private static String decrypt(String encryptedData) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, encryptionKey);
            return new String(cipher.doFinal(Base64.decodeBase64(encryptedData)));
        } catch (Exception e) {
            throw new RuntimeException("Decryption failed.", e);
        }
    }
}
