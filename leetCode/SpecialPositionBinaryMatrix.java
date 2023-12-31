package leetCode;

/**
 * https://leetcode.com/problems/special-positions-in-a-binary-matrix
 * 
 * @author subhrajeetghosh
 */

public class SpecialPositionBinaryMatrix {
    // BruteForce approch time complexity - O(m * n * (m + n))
    public int numSpecial_2ndMethod(int[][] mat) {
        int ans = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && isValidScenario(mat, i, j) == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private int isValidScenario(int[][] mat, int i, int j) {
        int sum = 0;
        int currentI = i;
        while (--currentI >= 0) {
            sum += mat[currentI][j];
        }
        currentI = i;
        while (++currentI < mat.length) {
            sum += mat[currentI][j];
        }
        int currentJ = j;
        while (--currentJ >= 0) {
            sum += mat[i][currentJ];
        }
        currentJ = j;
        while (++currentJ < mat[0].length) {
            sum += mat[i][currentJ];
        }
        return sum;
    }

    // Optimized Approch time complexity - O(mn) space complexity - O(m+n)
    public int numSpecial(int[][] mat) {
        int[] rowData = new int[mat.length];
        int[] columnData = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    rowData[i]++;
                    columnData[j]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && rowData[i] == 1 && columnData[j] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 0 },
                { 0, 1 } };
        System.out.println(new SpecialPositionBinaryMatrix().numSpecial(arr));
    }
}
