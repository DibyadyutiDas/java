// ?WAP to make an arithmetic calculator

import java.util.Scanner;

public class calculator {
    public static void main(String[] args){

        char operator;
        float num1,num2,res;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number - ");
        num1 = scanner.nextInt();
        System.out.print("Enter a operator - ");
        operator = scanner.next().charAt(0);
        System.out.print("Enter another number - ");
        num2 = scanner.nextInt();
        scanner.close();

        switch (operator)
        {
            case '+':
                res = num1 + num2;
                System.out.println("Addition = "+res);
                break;
            case '-':
                res = num1 - num2;
                System.out.println("Subtraction = "+res);
                break;
            case '*':
                res = num1 * num2;
                System.out.println("Multiplication = "+res);
                break;
            case '/':
                if (num2 != 0) {
                    res = num1 / num2;
                    System.out.println("Division = "+res);
                } else {
                    System.out.println("Error: Division by zero.");
                }
                break;
            default:
                System.out.println("You enter wrong info");
                break;
        }
    }
}