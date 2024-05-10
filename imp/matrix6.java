import java.util.Scanner;

public class matrix6 {
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

        if (row != column) {
            System.out.println("Matrix is not a square matrix.");
        }else{
            System.out.println("\nRight diagonal elements are: ");
            for (int i = 0; i < row; i++){
                for (int j = 0; j < column; j++) {
                    if (j == row-i-1) {
                        System.out.println("Element at position "+i+","+j+" is: "+matrix[i][j]);
                    }
                }
            }
        }

        sc.close();
    }
}
