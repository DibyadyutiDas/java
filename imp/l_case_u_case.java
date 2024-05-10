// ?WAP to find upper case character

import java.util.*;
public class l_case_u_case {
    public static void main(String[] args){

        char character;

        System.out.print("Enter a character - ");
        Scanner sc = new Scanner(System.in);
        character = sc.next().charAt(0);
        sc.close();
        
        int case_ = character;

        if (case_ <= 122 && case_ >= 97)
        {
            System.out.println("It is a lower case character ");
        }
        else
        {
            System.out.println("It is upper case character");
        }
    }
}