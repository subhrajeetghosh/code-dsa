package leetCode;

/**
 * https://leetcode.com/problems/count-unguarded-cells-in-the-grid
 * 
 * @author subhrajeetghosh
 */
public class CountUnGuardedCell {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) { //time complexity - O(G (m+n))
        int[][] grid = new int[m][n];
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = -1;
        }
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 2;
        }
        for (int[] guard : guards) {
            guardCheck(grid, guard[0], guard[1]);
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    result++;
                }
            }
        }
        return result;
    }

    private void guardCheck(int[][] grid, int row, int col) {
        for (int i = row - 1; i >= 0; i--) {
            if (grid[i][col] == -1 || grid[i][col] == 2)
                break;
            grid[i][col] = 1;
        }
        for (int i = row + 1; i < grid.length; i++) {
            if (grid[i][col] == -1 || grid[i][col] == 2)
                break;
            grid[i][col] = 1;
        }
        for (int j = col - 1; j >= 0; j--) {
            if (grid[row][j] == -1 || grid[row][j] == 2)
                break;
            grid[row][j] = 1;
        }
        for (int j = col + 1; j < grid[0].length; j++) {
            if (grid[row][j] == -1 || grid[row][j] == 2)
                break;
            grid[row][j] = 1;
        }
    }
}
