package leetCode;

/**
 * https://leetcode.com/problems/minimum-falling-path-sum
 * 
 * @author subhrajeetghosh
 */
public class MinPathFallingSum {

    public int minFallingPathSum(int[][] matrix) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            result = Math.min(result, findMinimum_12(matrix, i, 0));
        }
        return result;
    }

    private int findMinimum_12(int[][] matrix, int index, int lenIndex) {
        if (index < 0 || index >= matrix[0].length) {
            return Integer.MAX_VALUE;
        }
        if (lenIndex >= matrix.length)
            return 0;

        int left = findMinimum_12(matrix, index - 1, lenIndex + 1);
        int right = findMinimum_12(matrix, index + 1, lenIndex + 1);
        int mid = findMinimum_12(matrix, index, lenIndex + 1);

        return Math.min(right, Math.min(mid, left)) + matrix[lenIndex][index];
    }

    Integer[][] memo;

    public int minFallingPathSum_2ndMethod(int[][] matrix) {
        int result = Integer.MAX_VALUE;
        memo = new Integer[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            result = Math.min(result, findMinimum(matrix, i, 0));
        }
        return result;
    }

    private int findMinimum(int[][] matrix, int index, int lenIndex) {
        if (index < 0 || index >= matrix[0].length) {
            return Integer.MAX_VALUE;
        }
        if (lenIndex >= matrix.length)
            return 0;
        if (memo[lenIndex][index] != null)
            return memo[lenIndex][index];
        int left = findMinimum(matrix, index - 1, lenIndex + 1);
        int right = findMinimum(matrix, index + 1, lenIndex + 1);
        int mid = findMinimum(matrix, index, lenIndex + 1);

        memo[lenIndex][index] = Math.min(right, Math.min(mid, left)) + matrix[lenIndex][index];
        return memo[lenIndex][index];
    }
}
