// ?wap to enter a number and display all its digit

import java.util.*;
public class display_number {
    public static void main(String[] args){
    
        int num,div,rem;
        int reverse = 0;
        
        System.out.print("Enter a number - ");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        sc.close();
        
        while (num != 0)
        {
            rem = num % 10;
            div = num / 10;
            reverse = (reverse*10) + rem;
            num = div;
        }
        while (reverse != 0)
        {
            rem = reverse % 10;
            div = reverse / 10;
            System.out.print(rem);
            reverse = div;
        }
    }
}