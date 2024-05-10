// ?WAP to solve quadratic equation

import java.util.*;

public class quadratic {
    public static void main(String[] args){

        double res1,res2;
        int a,b,c,d;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of a - ");
        a = sc.nextInt();
        System.out.print("Enter the value of b - ");
        b = sc.nextInt();
        System.out.print("Enter the value of c - ");
        c = sc.nextInt();
        sc.close();

        d=b*b-4*a*c;
        if (d>=0)
        {
            res1 = (-b + Math.sqrt(d)) / (2 * a);
            res2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println("The value of the quadratic equation is"+res1+"or"+res2);
        }
        else
        {
            System.out.println("The quadratic equation is imaginary");
        }
    }
}