package leetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid
 * 
 * @author subhrajeetghosh
 */
public class MinOperationsMakeUniGrid {
    public int minOperations(int[][] grid, int x) { //time complexity - O(k log k) where k = n * m
        int[] arr = new int[grid.length * grid[0].length];
        int index = 0;
        int rem = grid[0][0] % x;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] % x != rem) {
                    return -1;
                }
                arr[index++] = grid[i][j];
            }
        }
        Arrays.sort(arr);
        if (arr.length % 2 != 0) {
            return minOperationsUniGrid(arr, arr[arr.length / 2], x);
        }
        return Math.min(minOperationsUniGrid(arr, arr[(arr.length / 2) - 1], x),
                minOperationsUniGrid(arr, arr[(arr.length / 2)], x));
    }

    private int minOperationsUniGrid(int[] arr, int target, int x) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += Math.abs(arr[i] - target) / x;
        }
        return result;
    }
}
