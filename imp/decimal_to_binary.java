// ?WAP to find binary form of a decimal number

import java.util.*;
public class decimal_to_binary {
    public static void main(String[] args){
        
        int num,rem;
        int binary = 0;

        System.out.print("Enter a decimal number - ");
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        scanner.close();
        
        while (num != 0)
        {
            rem = num % 2;
            num = num / 2;
            binary = (binary*10) + rem;
        }
        
        System.out.println(binary);
    }
}