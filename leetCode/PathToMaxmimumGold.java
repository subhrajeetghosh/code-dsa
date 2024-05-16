package leetCode;

/**
 * @author subhrajeetghosh
 */
public class PathToMaxmimumGold {
    int result = 0;

    public int getMaximumGold(int[][] grid) { //time complexity - O(m * n * 4 ^(m * n))
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                boolean[][] visited = new boolean[grid.length][grid[0].length];
                checkMaxGold(grid, visited, i, j, 0);
            }
        }
        return result;
    }

    private void checkMaxGold(int[][] grid, boolean[][] visited, int i, int j, int currentSum) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        currentSum += grid[i][j];
        result = Math.max(result, currentSum);
        checkMaxGold(grid, visited, i + 1, j, currentSum);
        checkMaxGold(grid, visited, i - 1, j, currentSum);
        checkMaxGold(grid, visited, i, j + 1, currentSum);
        checkMaxGold(grid, visited, i, j - 1, currentSum);
        currentSum -= grid[i][j];
        visited[i][j] = false;
    }
}
