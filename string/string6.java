import java.util.*;

public class string6 {
    public static void main(String[] args) {
        String name;

        System.out.print("Enter a name - ");
        Scanner scanner = new Scanner(System.in);
        name = scanner.next();
        scanner.close();

        // String reversedName = new StringBuilder(name).reverse().toString();
        char[] nameArray = name.toCharArray();
        String reversedName = "";
        for (int i = nameArray.length - 1; i >= 0; i--) {
            reversedName += nameArray[i];
        }
        System.out.println("Reversed name: " + reversedName);
    }
}