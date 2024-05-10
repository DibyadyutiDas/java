import java.util.Scanner;

public class matrix8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int row = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int column = sc.nextInt();

        int[][] matrix = new int[row][column];
        int[][] revers_matrix = new int[row][column];

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
        
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++) {
                revers_matrix[row-i-1][j] = matrix[i][j];
            }
        }

        System.out.println("\nRevers matrix : ");
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++) {
                System.out.print(revers_matrix[i][j] + " ");
            }
            System.out.print("\n");
        }

        sc.close();
    }
}
