package dynamicprogrammingcourse;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/cherry-pickup-ii
 * 
 * @author subhrajeetghosh
 */
public class CherryPickup2 {
    int[] arr = { -1, 0, 1 };

    public int cherryPickup_2ndMethod(int[][] grid) {
        return dfs_2ndMethod(0, 0, grid[0].length - 1, grid);
    }

    private int dfs_2ndMethod(int row, int col1, int col2, int[][] grid) {
        int res = 0;

        if (col1 == col2 || col1 < 0 || col2 < 0 || col1 >= grid[0].length || col2 >= grid[0].length)
            return res;
        if (row == grid.length - 1) {
            return grid[row][col1] + grid[row][col2];
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                res = Math.max(res, dfs_2ndMethod(row + 1, col1 + arr[i], col2 + arr[j], grid));
            }
        }
        return res + grid[row][col1] + grid[row][col2];
    }

    // memorization
    Map<String, Integer> memo;

    public int cherryPickup(int[][] grid) {
        memo = new HashMap<String, Integer>();
        return dfs(0, 0, grid[0].length - 1, grid);
    }

    private int dfs(int row, int col1, int col2, int[][] grid) {
        int res = 0;
        String key = new StringBuilder().append(row + ":" + col1 + ":" + col2).toString();
        if (memo.containsKey(key))
            return memo.get(key);
        if (col1 == col2 || col1 < 0 || col2 < 0 || col1 >= grid[0].length || col2 >= grid[0].length)
            return res;
        if (row == grid.length - 1) {
            return grid[row][col1] + grid[row][col2];
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                res = Math.max(res, dfs(row + 1, col1 + arr[i], col2 + arr[j], grid));
            }
        }
        res += grid[row][col1] + grid[row][col2];
        memo.put(key, res);
        return res;
    }
}
