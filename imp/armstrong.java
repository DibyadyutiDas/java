// ?Wap to enter a number to check whether it is armstrong number or not
// *(153)There are 3 digits 1^3+5^3+3^3 = 153

import java.util.*;
public class armstrong {
    public static void main(String[] args){

        int num,rem,div,temp,armstrong;
        int powers = 0;

        System.out.print("Enter a number - ");
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        scanner.close();
        temp = num;

        do
        {
            rem = num % 10;
            armstrong = rem * rem * rem;
            div = num / 10;
            powers = powers + armstrong;
            num = div;
        } while (num != 0);
        if (powers == temp)
        {
            System.out.println("\nIt is an armstrong number");
        }
        else
        {
            System.out.println("\nIt is not an armstrong number");
        }
    }
}