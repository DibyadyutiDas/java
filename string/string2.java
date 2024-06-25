import java.util.*;

public class string2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Input your name : ");
        String name = new String();
        name = scanner.nextLine();

        System.out.println(name);

        scanner.close();
    }
}