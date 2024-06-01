// ?WAP using for loop

import java.util.*;

public class for_ {
    public static void main(String[] args){

        int row,column;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of row - ");
        row = sc.nextInt();
        System.out.print("Enter number of column - ");
        column = sc.nextInt();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        sc.close();
    }
}