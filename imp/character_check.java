// ?check weather the character is vowel or consonant


import java.util.*;
public class character_check {
    public static void main(String[] args){

        System.out.print("Enter a alphabet - ");
        Scanner scanner = new Scanner(System.in);
        char character = scanner.next().charAt(0);
        scanner.close();

        if(character >= 'a' && character <= 'z' || character >= 'A' && character <= 'Z')
        {
            if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u'
                || character == 'A' || character == 'E' || character == 'I' || character == 'O' || character == 'U')
            {
                System.out.print("This is vowel");
            }
            else
            {
                System.out.print("This is consonant");
            }
        }   
        else
        {
            System.out.print("This is not a alphabet");
        }
    }
}