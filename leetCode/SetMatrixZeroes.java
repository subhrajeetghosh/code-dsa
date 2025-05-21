package leetCode;

/**
 * https://leetcode.com/problems/set-matrix-zeroes
 * 
 * @author subhrajeetghosh
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) { // time complexity - O(m*n * m+n)
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0 && !visited[i][j]) {
                    int tmpI = i;
                    while (tmpI >= 0) {
                        if (matrix[tmpI][j] != 0) {
                            visited[tmpI][j] = true;
                        }
                        matrix[tmpI--][j] = 0;
                    }
                    tmpI = i;
                    while (tmpI < matrix.length) {
                        if (matrix[tmpI][j] != 0) {
                            visited[tmpI][j] = true;
                        }
                        matrix[tmpI++][j] = 0;
                    }
                    int tmpJ = j;
                    while (tmpJ >= 0) {
                        if (matrix[i][tmpJ] != 0) {
                            visited[i][tmpJ] = true;
                        }
                        matrix[i][tmpJ--] = 0;
                    }
                    tmpJ = j;
                    while (tmpJ < matrix[0].length) {
                        if (matrix[i][tmpJ] != 0) {
                            visited[i][tmpJ] = true;
                        }
                        matrix[i][tmpJ++] = 0;
                    }
                }
            }
        }
    }

    public void setZeroes_2ndMethod(int[][] matrix) { // time complexity - O(m*n)
        int m = matrix.length, n = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstRowZero = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstColZero = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstRowZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (firstColZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
