package app.app;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class BankData {
    private static final String DATA_FILE = "bank_data.ser";
    private static Map users = new HashMap();

    public static Map<String, User> getUsers() {
        if (users.isEmpty()) {
            loadUserData();
        }
        return users;
    }

    public static void saveUserData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadUserData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            users = (Map<String, User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            users = new HashMap<>();
        }
    }
}
