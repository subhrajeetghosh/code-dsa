package leetCode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner
 * 
 * @author subhrajeetghosh
 */
public class MinObstackeRemover {
    int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    int minObstacle = Integer.MAX_VALUE;
    int m, n;

    public int minimumObstacles_2ndMethod(int[][] grid) { // time complexity - O(m*n*4)
        m = grid.length;
        n = grid[0].length;
        int[][] visited = new int[m][n];
        for (int[] arr : visited) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        dfs(grid, visited, 0, 0, 0);
        return minObstacle;
    }

    private void dfs(int[][] grid, int[][] visited, int row, int col, int obstacle) {
        if (obstacle >= minObstacle || obstacle >= visited[row][col]) {
            return;
        }
        visited[row][col] = obstacle;
        if (row == m - 1 && col == n - 1) {
            minObstacle = Math.min(minObstacle, obstacle);
            return;
        }
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                dfs(grid, visited, newRow, newCol, grid[newRow][newCol] + obstacle);
            }
        }
    }

    // BFS Approch
    public int minimumObstacles(int[][] grid) { // time complexity - O(m*n)
        m = grid.length;
        n = grid[0].length;
        int[][] visited = new int[m][n];
        for (int[] arr : visited) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        visited[0][0] = 0;
        Deque<int[]> dq = new LinkedList<>();
        dq.add(new int[] { 0, 0 });
        while (!dq.isEmpty()) {
            int[] currentIndex = dq.pollFirst();
            int row = currentIndex[0];
            int col = currentIndex[1];
            if (row == m - 1 && col == n - 1) {
                return visited[row][col];
            }
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    int newObstacle = grid[newRow][newCol] + visited[row][col];
                    if (newObstacle < visited[newRow][newCol]) {
                        visited[newRow][newCol] = newObstacle;
                        if (grid[newRow][newCol] == 0) {
                            dq.offerFirst(new int[] { newRow, newCol });
                        } else {
                            dq.offerLast(new int[] { newRow, newCol });
                        }
                    }
                }
            }
        }
        return visited[m - 1][n - 1];
    }
}
