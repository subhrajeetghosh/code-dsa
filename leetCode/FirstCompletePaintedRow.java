package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/first-completely-painted-row-or-column/
 * 
 * @author subhrajeetghosh
 */
public class FirstCompletePaintedRow {
    public int firstCompleteIndex(int[] arr, int[][] mat) { // time copmlexity - O(len + m * n)
        int[] colArr = new int[mat[0].length];
        int[] rowArr = new int[mat.length];
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                map.put(mat[i][j], new int[] { i, j });
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int[] indexArr = map.get(arr[i]);
            int row = indexArr[0];
            int col = indexArr[1];
            rowArr[row]++;
            colArr[col]++;
            if (rowArr[row] == mat[0].length || colArr[col] == mat.length) {
                return i;
            }
        }
        return -1;
    }
}
