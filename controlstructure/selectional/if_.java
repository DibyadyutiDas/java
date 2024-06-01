// ?WAP using if else 

import java.util.*;
public class if_ {
    public static void main(String[] args) {

        int num;
        System.out.print("Enter a number - ");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();

        if (num%2 == 0) {
            System.out.print(num);
            System.out.println(" is an even number");
        }
        else {
            System.out.print(num);
            System.out.println(" is an odd number");
        }

        sc.close();
    }
}