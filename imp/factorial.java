// ?WAP to find factorial of a number

import java.util.*;
public class factorial {
    public static void main(String[] args){

        int num;
        int factorial=1; //! if here factorial = 0 then it output 0
        
        System.out.print("Enter a number - ");
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        scanner.close();
        
        factorial = (num * (num+1)) / 2;        // good

        // for (int i=1; i <= num; i++)
        // {
        //     factorial *=i;
        // }

        System.out.println("The value of the factorial " +num+ " is "+factorial);
    }
}