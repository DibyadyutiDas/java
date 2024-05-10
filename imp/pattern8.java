import java.io.*;
import java.util.*;

public class pattern8 {
        public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        int radius = sc.nextInt();

        for (int i = 0; i <= 2 * radius; i++) {
            for (int j = 0; j <= 2 * radius; j++) {
                if (radius*radius >= ((radius-i)*(radius-i))+((radius-j)*(radius-j))){
                    System.out.print(" * ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.print("\n");
        }
    }
}