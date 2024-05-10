// ?WAP for leap year

import java.util.*;
public class leap_year {
    public static void main(String[] args){

        int year;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the year -");
        year = sc.nextInt();

        if (year % 4 == 0)
        {
            System.out.println("This is a leap year");
        }
        else
        {
            System.out.println("This is not a leap year");
        }

        sc.close();
    }
}