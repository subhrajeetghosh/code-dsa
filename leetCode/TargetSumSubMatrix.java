package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/
 * 
 * @author subhrajeetghosh
 */
public class TargetSumSubMatrix {
    public int numSubmatrixSumTarget(int[][] matrix, int target) { // time complexity - O(m*n^2)
        int count = 0, m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                Map<Integer, Integer> counter = new HashMap<>();
                counter.put(0, 1);
                int sum = 0;
                for (int k = 0; k < m; k++) {
                    sum += matrix[k][j] - (i > 0 ? matrix[k][i - 1] : 0);
                    count += counter.getOrDefault(sum - target, 0);
                    counter.put(sum, counter.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return count;
    }
}
