import java.util.Scanner;

public class matrix4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int row = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int column = sc.nextInt();

        int[][] matrix = new int[row][column];

        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++) {
                System.out.print("Enter the element at position "+i+","+j+" : ");
                matrix[i][j] = sc.nextInt();
            }
        }
        
        System.out.println("\nMatrix is: ");
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
        
        int sum = 0;
        for (int j = 0; j < row; j++){
            for (int i = 0; i < column; i++) {
                sum += matrix[i][j];
            }
            System.out.println("Sum of column "+j+1+" is: "+sum);
        }

        sc.close();
    }
}
