package Matrix;

/*
    Check --- matrix[r-1][c-1] != matrix[r][c]
    only if r and c are >0
*/

public class ToeplitzDiagonal {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; ++r)
            for (int c = 0; c < matrix[0].length; ++c)
                if (r > 0 && c > 0 && matrix[r-1][c-1] != matrix[r][c])
                    return false;
        return true;
    }
}
