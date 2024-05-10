//? WAP to find ascii value of a character
//* ascii value of a = 97

import java.util.*;
public class ascii_value {
    public static void main(String[] args){

        char ch1;
        
        System.out.print("Enter a character -");
        Scanner scanner = new Scanner(System.in);
        ch1 = scanner.next().charAt(0);
        scanner.close();
        
        int a1 = (int)ch1;

        System.out.println("\nascii form of ch1 is - "+a1);  
        
    }
}