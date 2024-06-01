// ?WAP using ladder if else 

import java.util.*;
public class ladder_if {
    public static void main(String[] args) {

        int num;
        System.out.print("Enter a number - ");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();

        if (num == 0) {
            System.out.println("Number is 0");
        }
        else if (num%2 == 0) {
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