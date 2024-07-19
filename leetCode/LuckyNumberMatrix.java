package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/lucky-numbers-in-a-matrix/
 * 
 * @author subhrajeetghosh
 */
public class LuckyNumberMatrix {
    public List<Integer> luckyNumbers(int[][] matrix) { // time complexity - O(n * m)
        int[][] minimumArray = new int[matrix.length][matrix[0].length];
        int[][] maximumArray = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            int[] arr = matrix[i];
            int minimum = Integer.MAX_VALUE;
            for (int j = 0; j < arr.length; j++) {
                minimum = Math.min(minimum, arr[j]);
            }
            for (int j = 0; j < matrix[0].length; j++) {
                minimumArray[i][j] = minimum;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            int maximum = Integer.MIN_VALUE;
            for (int j = 0; j < matrix.length; j++) {
                maximum = Math.max(maximum, matrix[j][i]);
            }
            for (int j = 0; j < matrix.length; j++) {
                maximumArray[j][i] = maximum;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (maximumArray[i][j] == minimumArray[i][j] && maximumArray[i][j] == matrix[i][j]) {
                    result.add(minimumArray[i][j]);
                }
            }
        }
        return result;
    }
}
