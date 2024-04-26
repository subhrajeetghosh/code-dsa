package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-falling-path-sum-ii
 * 
 * @author subhtajeetghosh
 */
public class MinFallingPathII {
    // Bruteforce approch
    int minimum = Integer.MAX_VALUE;

    public int minFallingPathSum_3(int[][] grid) {
        for (int i = 0; i < grid[0].length; i++) {
            minimumChecker(grid, i, 0, grid[0][i]);
        }
        return minimum;
    }

    private void minimumChecker(int[][] grid, int currentIndex, int currentRow, int currentSum) {
        currentRow++;
        if (currentRow >= grid.length) {
            minimum = Math.min(currentSum, minimum);
            return;
        }

        for (int i = 0; i < grid[0].length; i++) {
            if (i != currentIndex) {
                minimumChecker(grid, i, currentRow, currentSum + grid[currentRow][i]);
            }
        }
    }

    // Using Memorization
    Map<String, Integer> map = new HashMap<>();
    int minimum_memo = Integer.MAX_VALUE;

    public int minFallingPathSum_1(int[][] grid) {
        for (int i = 0; i < grid[0].length; i++) {
            minimumChecker_1(grid, i, 0, grid[0][i]);
        }
        return minimum_memo;
    }

    private void minimumChecker_1(int[][] grid, int currentIndex, int currentRow, int currentSum) {
        currentRow++;
        if (currentRow >= grid.length) {
            minimum_memo = Math.min(currentSum, minimum_memo);
            return;
        }

        String sb = new StringBuilder().append(currentIndex).append("-").append(currentRow).toString();
        if (map.containsKey(sb) && map.get(sb) < currentSum)
            return;
        map.put(sb, currentSum);

        for (int i = 0; i < grid[0].length; i++) {
            if (i != currentIndex) {
                minimumChecker_1(grid, i, currentRow, currentSum + grid[currentRow][i]);
            }
        }
    }

    // Using Array
    Integer[][] memo;
    int minimum_1 = Integer.MAX_VALUE;

    public int minFallingPathSum_2(int[][] grid) {
        memo = new Integer[grid.length][grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            minimumChecker_2(grid, i, 0, grid[0][i]);
        }
        return minimum_1;
    }

    private void minimumChecker_2(int[][] grid, int currentIndex, int currentRow, int currentSum) {
        currentRow++;
        if (currentRow >= grid.length) {
            minimum_1 = Math.min(currentSum, minimum_1);
            return;
        }
        if (memo[currentRow][currentIndex] != null && memo[currentRow][currentIndex] <= currentSum)
            return;
        memo[currentRow][currentIndex] = currentSum;
        for (int i = 0; i < grid[0].length; i++) {
            if (i != currentIndex) {
                minimumChecker_2(grid, i, currentRow, currentSum + grid[currentRow][i]);
            }
        }
    }

    // Dynamic Programming Approch
    public int minFallingPathSum(int[][] grid) {  //time complexity - O(n m^2)
        int rowLength = grid.length;
        int colLength = grid[0].length;
        for (int row = rowLength - 2; row >= 0; row--) {
            for (int col = 0; col < colLength; col++) {
                int currentMin = Integer.MAX_VALUE;
                for (int i = 0; i < colLength; i++) {
                    if (i == col)
                        continue;
                    currentMin = Math.min(currentMin, grid[row + 1][i]);
                }
                grid[row][col] += currentMin;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < colLength; i++) {
            min = Math.min(min, grid[0][i]);
        }
        return min;
    }
}
