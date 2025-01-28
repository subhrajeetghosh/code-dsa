package leetCode;

/**
 * https://leetcode.com/problems/maximum-number-of-fish-in-a-grid
 * 
 * @author subhrajeetghosh
 */
public class MaxNumFishInGrid {
    public int findMaxFish(int[][] grid) { // time complexity - O(mn^2)
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                result = Math.max(result, dfs(grid, i, j, new boolean[grid.length][grid[0].length]));
            }
        }
        return result;
    }

    public int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }
        int ans = grid[i][j];
        visited[i][j] = true;
        ans += dfs(grid, i + 1, j, visited);
        ans += dfs(grid, i - 1, j, visited);
        ans += dfs(grid, i, j + 1, visited);
        ans += dfs(grid, i, j - 1, visited);
        return ans;
    }

    // Optimized approch
    public int findMaxFish_2ndMethod(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                result = Math.max(result, dfs(grid, i, j));
            }
        }
        return result;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        int ans = grid[i][j];
        grid[i][j] = 0;
        ans += dfs(grid, i + 1, j);
        ans += dfs(grid, i - 1, j);
        ans += dfs(grid, i, j + 1);
        ans += dfs(grid, i, j - 1);
        return ans;
    }
}
