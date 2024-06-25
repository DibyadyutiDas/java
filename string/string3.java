import java.util.*;

public class string3 {
    public static void main(String[] args) {

        String name[] = new String[5];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the students name :");

        for (int i = 0; i < name.length; i++){
            name[i] = scanner.next();
        }

        for (int i = 0; i < name.length; i++) {
            for (int j = i+1; j < name.length; j++) {
                if (name[i].compareTo(name[j]) > 0) {
                    String temp;
                    temp = name[i];
                    name[i] = name[j];
                    name[j] = temp;
                }
            }
        }

        System.out.println("\nStudents name in acceding order :");
        for (int i = 0; i < name.length; i++){
            System.out.println(name[i]);
        }
        scanner.close();
    }
}