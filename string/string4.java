import java.util.*;

public class string4 {
    public static void main(String[] args) {

        String name[] = new String[5];
        // String duplicate_name[] = new String[5];
        String temp;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the students name :");

        for (int i = 0; i < name.length; i++){
            name[i] = scanner.next();
        }

        for (int i = 0; i < name.length; i++) {
            for (int j = i+1; j < name.length; j++) {
                if (name[i].compareToIgnoreCase(name[j]) > 0) {
                    temp = name[i];
                    name[i] = name[j];
                    name[j] = temp;
                }
            }
        }
        // for (int i = 0; i < name.length; i++){
        //     duplicate_name[i] = name[i].toLowerCase();
        // }

        // for (int i = 0; i < name.length; i++) {
        //     for (int j = i+1; j < name.length; j++) {
        //         if (duplicate_name[i].compareTo(duplicate_name[j]) > 0) {

        //             temp = name[i];
        //             name[i] = name[j];
        //             name[j] = temp;

        //             temp = duplicate_name[i];
        //             duplicate_name[i] = duplicate_name[j];
        //             duplicate_name[j] = temp;
        //         }
        //     }
        // }

        System.out.println("\nStudents name in acceding order :");
        for (int i = 0; i < name.length; i++){
            System.out.println(name[i]);
        }
        scanner.close();
    }
}