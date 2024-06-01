// ?WAP using do while loop

import java.util.*;
public class do_while {
    public static void main(String[] args){
        
        int num;
        System.out.print("Enter a number - ");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        int i = num;
        do
        {
            System.out.println(i);
            i--;
        } while (i >= 1);
        System.out.println("Happy new Year");

        sc.close();
    }
}