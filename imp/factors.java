// ?WAP for display factors of a number

import java.util.*;
public class factors {
    public static void main(String[] args){

        int num,x = 1;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number - ");
        num = sc.nextInt();
        sc.close();

        System.out.println("factors of "+num+" are ");
                
        while (x <= num)
            {
                if (num%x == 0)
                {
                    System.out.println(x);
                }
                x++;
            }
    }
}