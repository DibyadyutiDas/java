// ?WAP to revers a number

import java.util.*;
public class reverse {
    public static void main(String[] args){
        
        int num,div,rem,rev = 0;

        System.out.print("Enter a number - ");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt() ;
        sc.close();

        for (int i = num ; i != 0; i = rem) {
            div = i % 10;
            rem = i / 10;
            rev = rev*10 + div;
        }
        System.out.println(rev);
    }
}