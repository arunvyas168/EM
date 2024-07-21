package M;

import java.util.ArrayList;
import java.util.Collections;

/*
Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
*/

/*
        TLDR:
            1. check null matrix or empty matrix
            2. initialize result with M*N length --- resultIndex
            3. have temp list to hold diagnoal
        NOTE: Number of diagnoals is num (M+N-1) NumRows+NumColumn+1

*/

public class DiagnoalTraverseBiDirection {
    public int[] findDiagonalOrder(int[][] matrix) {
        // Return an empty array for null or empty matrix
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        // Get dimensions of the matrix
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        // Result array to store the diagonal traversal
        int[] result = new int[numRows * numCols];

        // do this later
        int resultIndex = 0;

        // Temporary list to hold elements of a diagonal
        ArrayList<Integer> diagonalElements = new ArrayList<>();

        // Process all diagonals in the matrix
        // Number of diagnoals is num (M+N-1) NumRows+NumColumn+1
        for (int diagonal = 0; diagonal < numRows + numCols - 1; diagonal++) {
            // Clear the temporary list for the current diagonal
            diagonalElements.clear();

            // Determine the starting point of the current diagonal
            int startRow;
            int startCol;
            if (diagonal < numCols) {
                startRow = 0;  // Starting from the first row
                startCol = diagonal;  // Starting column is the diagonal index itself
            } else {
                // Otherwise, the diagonal starts from the last column
                // The starting row is calculated by subtracting the number of columns
                // from the diagonal index, plus one.
                startRow = diagonal - numCols + 1;  // Calculate the starting row
                startCol = numCols - 1;  // Always start from the last column
            }

            // Collect elements along the diagonal
            int row = startRow;
            int col = startCol;
            while (row < numRows && col >= 0) {
                diagonalElements.add(matrix[row][col]);
                row++;
                col--;
            }

            // Reverse the elements for even-numbered diagonals
            if (diagonal % 2 == 0) {
                Collections.reverse(diagonalElements);
            }

            // Copy the elements to the result array
            for (int element : diagonalElements) {
                result[resultIndex++] = element;
            }
        }

        return result;
    }
}
