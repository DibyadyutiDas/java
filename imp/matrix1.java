public class matrix1 {
    public static void main(String[] args) {

        int matrix_[][] = new int[3][3];

        matrix_[0][0] = 1;
        matrix_[0][1] = 2;
        matrix_[0][2] = 3;
        matrix_[1][0] = 4;
        matrix_[1][1] = 5;
        matrix_[1][2] = 6;
        matrix_[2][0] = 7;
        matrix_[2][1] = 8;
        matrix_[2][2] = 9;

        for (int i = 0; i < matrix_.length; i++) {
            System.out.println("");
            for (int j = 0; j < matrix_[i].length; j++) {
                System.out.print(matrix_[i][j]+" ");
            }
        }

        System.out.println("");

        // int matrix[][] = {
        //     {1, 2, 3},
        //     {4, 5, 6},
        //     {7, 8, 9}
        // };

        // for (int i = 0; i < matrix.length; i++) {
        //     System.out.println("");
        //     for (int j = 0; j < matrix[i].length; j++) {
        //         System.out.print(matrix[i][j]+" ");
        //     }
        // }
    }
}
