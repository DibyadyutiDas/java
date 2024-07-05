import java.util.Scanner;
public class math {
    public static void main(String[] args){
    
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the base - ");
        double x = scanner.nextDouble();

        System.out.print("Enter the hight - ");
        double y = scanner.nextDouble();

        double z = Math.sqrt((x*x)+(y*y));

        System.out.println("The hypotenuse is "+z);

        scanner.close();
    }
}