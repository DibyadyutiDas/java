import java.util.Scanner;
public class operator {
    public static void main(String[] args){

        // * Expression = operands & operator
        // * operands = values,variables,numbers,quantity
        // * operator = +,-,*,/,%


        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        double num1 = num;

        num = num / 3;              //! if here we enter 10 the output wll be 3 not 3.33 
                                    //! because of in integer division decimal value truncate
        System.out.println(num);

        num1 = num1/3;              //! Typecasting because num1 is double
        System.out.println(num1);

        sc.close();
    }
}
