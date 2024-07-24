package Matrix;
/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
*/
public class MatrixRotate {

    /*
            TLDR:
                1. we use temp and start swapping all 4 corners
                2. The increment to swap middle
                3. we have to stop at middle and not swap corners again so we are using n/2
                    I use celi because if the columns are odd then we need to go to ceeling of it 5/2 = 2.5 but we have to go to 3rd element

    */


    // Clock Wise 90 degree
    public static void rotateMatrixClock(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < Math.ceil(((double) n) / 2.0); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }

    // Anti Clock Wise 90 degree
    public static void rotateMatrixCounterClock(int[][] matrix){
        int n = matrix.length;
        for(int i=0;i<n/2;i++){
            for (int j=0; j< Math.ceil(((double)n/2.0));j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = temp;
            }
        }
    }



    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        rotateMatrixClock(matrix);
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        rotateMatrixCounterClock(matrix);
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
