package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows
 * 
 * @author subhrajeetghosh
 */
public class FlipColumnsForEqualRows {
    public int maxEqualRowsAfterFlips(int[][] matrix) { // time complexity - O(m*n)
        Map<String, Integer> map = new HashMap<>();
        for (int[] row : matrix) {
            StringBuilder sb = new StringBuilder();
            StringBuilder flipSb = new StringBuilder();
            for (int val : row) {
                sb.append(val);
                flipSb.append(val == 0 ? 1 : 0);
            }
            String mainString = sb.toString();
            String flipString = flipSb.toString();

            map.put(mainString, map.getOrDefault(mainString, 0) + 1);
            map.put(flipString, map.getOrDefault(flipString, 0) + 1);
        }

        int result = 0;
        for (int count : map.values()) {
            result = Math.max(result, count);
        }
        return result;
    }
}
