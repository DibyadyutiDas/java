import java.util.Scanner;

public class string5 {
    public static void main(String[] args) {

        String name;
        System.out.print("Enter a name - ");
        Scanner scanner = new Scanner(System.in);
        name = scanner.next();

        System.out.println("\nThe permutation are :");
        permute(name, 0, name.length() - 1);
        scanner.close();
    }

    private static void permute(String str, int l, int r) {

        System.out.println("str=" + str + ", l=" + l + ", r=" + r);
        if (l == r)
            System.out.println(str);
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                // str = swap(str, l, i);  backtrack
            }
        }
    }

    public static String swap(String a, int i, int j) {

        char[] charArray = a.toCharArray();

        System.out.println("                      str=" + a + ", " + i +"=" + charArray[i] + ", " + j +"=" + charArray[j]);
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        System.out.println("                      str=" + a + ", " + i +"=" + charArray[i] + ", " + j +"=" + charArray[j]);

        return String.valueOf(charArray);
    }
}